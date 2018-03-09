package com.kb.dndchar.converters.impl;

import com.kb.dndchar.accessors.IAbilityScoresAccessor;
import com.kb.dndchar.converters.IAbilityScoresConverter;
import com.kb.dndchar.domains.DomainAbilityScores;
import com.kb.dndchar.views.ViewAbilityScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbilityScoresConverter implements IAbilityScoresConverter {

    @Override
    public DomainAbilityScores viewToDomain(ViewAbilityScores viewAbilityScores, Long charId) {
        DomainAbilityScores domainAbilityScores = new DomainAbilityScores();
        domainAbilityScores.setStrengthScore(viewAbilityScores.getStrengthScore());
        domainAbilityScores.setDexterityScore(viewAbilityScores.getDexterityScore());
        domainAbilityScores.setConstitutionScore(viewAbilityScores.getConstitutionScore());
        domainAbilityScores.setIntelligenceScore(viewAbilityScores.getIntelligenceScore());
        domainAbilityScores.setWisdomScore(viewAbilityScores.getWisdomScore());
        domainAbilityScores.setCharismaScore(viewAbilityScores.getCharismaScore());
        domainAbilityScores.setCharId(charId);
        return domainAbilityScores;
    }

    @Override
    public ViewAbilityScores domainToView(DomainAbilityScores domainAbilityScores) {
        ViewAbilityScores viewAbilityScores = new ViewAbilityScores();
        viewAbilityScores.setStrengthScore(domainAbilityScores.getStrengthScore());
        viewAbilityScores.setDexterityScore(domainAbilityScores.getDexterityScore());
        viewAbilityScores.setConstitutionScore(domainAbilityScores.getConstitutionScore());
        viewAbilityScores.setIntelligenceScore(domainAbilityScores.getIntelligenceScore());
        viewAbilityScores.setWisdomScore(domainAbilityScores.getWisdomScore());
        viewAbilityScores.setCharismaScore(domainAbilityScores.getCharismaScore());
        return viewAbilityScores;
    }
}
