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
            return  spellAccessor.findOne(viewSpell.getSpellId());
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
