package com.kb.dndchar.converters.impl;

import com.kb.dndchar.accessors.ISpellAccessor;
import com.kb.dndchar.converters.ISpellConverter;
import com.kb.dndchar.domains.DomainSpell;
import com.kb.dndchar.views.ViewSpell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpellConverter implements ISpellConverter {

    @Autowired
    ISpellAccessor spellAccessor;

    @Override
    public DomainSpell viewToDomain(ViewSpell viewSpell) {

        DomainSpell domainSpell = new DomainSpell();
        domainSpell.setSpellId(viewSpell.getSpellId());
        domainSpell.setSpellName(viewSpell.getSpellName());
        domainSpell.setIsRitual(viewSpell.getIsRitual());
        domainSpell.setRitualName(viewSpell.getRitualName());
        domainSpell.setLevel(viewSpell.getLevel());
        domainSpell.setCastingTime(viewSpell.getCastingTime());
        domainSpell.setRange(viewSpell.getRange());
        domainSpell.setDuration(viewSpell.getDuration());
        domainSpell.setComponents(viewSpell.getComponents());
        domainSpell.setMaterials(viewSpell.getMaterials());
        domainSpell.setSpellDesc(viewSpell.getSpellDesc());
        domainSpell.setHigherLevelDescOne(viewSpell.getHigherLevelDescOne());
        domainSpell.setHigherLevelDescTwo(viewSpell.getHigherLevelDescTwo());
        return domainSpell;
    }

    @Override
    public ViewSpell domainToView(DomainSpell domainSpell) {
        ViewSpell viewSpell = new ViewSpell();
        viewSpell.setSpellId(domainSpell.getSpellId());
        viewSpell.setSpellName(domainSpell.getSpellName());
        viewSpell.setIsRitual(domainSpell.getIsRitual());
        viewSpell.setRitualName(domainSpell.getRitualName());
        viewSpell.setLevel(domainSpell.getLevel());
        viewSpell.setCastingTime(domainSpell.getCastingTime());
        viewSpell.setRange(domainSpell.getRange());
        viewSpell.setDuration(domainSpell.getDuration());
        viewSpell.setComponents(domainSpell.getComponents());
        viewSpell.setMaterials(domainSpell.getMaterials());
        viewSpell.setSpellDesc(domainSpell.getSpellDesc());
        viewSpell.setHigherLevelDescOne(domainSpell.getHigherLevelDescOne());
        viewSpell.setHigherLevelDescTwo(domainSpell.getHigherLevelDescTwo());
        return viewSpell;
    }
}
