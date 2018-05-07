package com.kb.dndchar.managers.impl;

import com.kb.dndchar.accessors.ISpellAccessor;
import com.kb.dndchar.accessors.ISpellAccessorCustom;
import com.kb.dndchar.accessors.IUserAccessor;
import com.kb.dndchar.accessors.impl.SpellAccessorCustom;
import com.kb.dndchar.accessors.impl.UserAccessorCustom;
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
    IUserAccessor userAccessor;

    @Autowired
    UserAccessorCustom userAccessorCustom;

    @Autowired
    SpellAccessorCustom spellAccessorCustom;

    @Override
    public List<ViewSpell> getAllSpellsOfUser(String username) {
        return spellAccessorCustom.getSpellsOfUser(username).stream()
                .map(spellConverter::domainToView)
                .collect(Collectors.toList());
    }

    /**
     * @Todo need to make sure not to get/edit other peoples's spell
     */
    @Override
    public ViewSpell getSpellById(Long spellId, String username) {
        DomainSpell domainSpell = spellAccessor.findOne(spellId);
        if (domainSpell == null) {
            throw new EntityNotFoundException("Could not retrieve Spell with Id: " +
            spellId.toString()) ;
        }
        return spellConverter.domainToView(domainSpell);
    }

    @Override
    public ViewSpell createSpellForUser(String username, ViewSpell viewSpell) {
        if(userAccessor.findByUsername(username) == null){
            throw new EntityNotFoundException("Could not retrieve user with username: " +
            username);
        }
        ViewSpell createdSpell = spellConverter.domainToView(
                        spellAccessor.save(
                        spellConverter.viewToDomain(viewSpell)));
        if(createdSpell != null) {
            userAccessorCustom.addToHasSpellTable(username, createdSpell.getSpellId());
        }
        return createdSpell;
    }

     /**
     * @Todo need to make sure not to get/edit other peoples's spell
     */
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

    @Override
    public List<ViewSpell> getSpellName(String name) {
         return  spellAccessorCustom.getSpellsOfUser(name).stream()
                .map(spellConverter:: domainToView)
                .collect(Collectors.toList());
    }
}
