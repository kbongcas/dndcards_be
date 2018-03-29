package com.kb.dndchar.managers.impl;

import com.kb.dndchar.accessors.ISpellAccessor;
import com.kb.dndchar.accessors.ISpellAccessorCustom;
import com.kb.dndchar.accessors.impl.SpellAccessorCustom;
import com.kb.dndchar.converters.ISpellConverter;
import com.kb.dndchar.domains.DomainSpell;
import com.kb.dndchar.managers.ISpellManager;
import com.kb.dndchar.views.ViewSpell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpellManager implements ISpellManager{

    @Autowired
    ISpellConverter spellConverter;

    @Autowired
    ISpellAccessor spellAccessor;

    @Autowired
    SpellAccessorCustom spellAccessorCustom;

    @Override
    public List<ViewSpell> getAllSpells() {
        return spellAccessor.findAll().stream()
                .map(spellConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewSpell getSpellById(Long spellId) {
        DomainSpell domainSpell = spellAccessor.findOne(spellId);
        if (domainSpell == null) {
            throw new EntityNotFoundException("Could not retrieve Spell with Id: " +
            spellId.toString()) ;
        }
        return spellConverter.domainToView(domainSpell);
    }

    @Override
    public List<ViewSpell> getSpellsByCharId(Long charId) {
        /*
         * @TODO See what happens if List is empty cause a character might not have spell at all.
         */
        return  spellAccessorCustom.getSpellsByCharId(charId).stream()
                .map(spellConverter:: domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewSpell createSpell(ViewSpell viewSpell) {
        return spellConverter.domainToView(
                spellAccessor.save(
                        spellConverter.viewToDomain(viewSpell)));
    }

    @Override
    public ViewSpell updateSpell(Long spellId, ViewSpell viewSpell) {
        DomainSpell currentSpell = spellAccessor.findOne(spellId);
        if (spellId == null) {
            throw new EntityNotFoundException("Could not retrieve Spell with ID: " + spellId.toString());
        } else if (!viewSpell.getSpellId().equals(spellId)) {
            throw new InvalidParameterException("Provided Spell ID: "
                    + spellId.toString()
                    + " does not match provided Spell ID: "
                    + spellId.toString());
        }
        return spellConverter.domainToView(
                spellAccessor.save(
                        spellConverter.viewToDomain(viewSpell)));
    }

    @Override
    public ViewSpell deleteSpell(Long spellId) {
        DomainSpell spell = spellAccessor.findOne(spellId);
        if (spell == null) {
            throw new EntityNotFoundException("Unable to retrieve Spell: " + spellId.toString());
        }
        spellAccessor.delete(spellId);
        return spellConverter.domainToView(spell);
    }
}
