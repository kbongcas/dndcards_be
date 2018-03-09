package com.kb.dndchar.converters;

import com.kb.dndchar.domains.DomainAbilityScores;
import com.kb.dndchar.views.ViewAbilityScores;

public interface IAbilityScoresConverter {
    DomainAbilityScores viewToDomain(ViewAbilityScores viewAbilityScores, Long CharId);
    ViewAbilityScores domainToView(DomainAbilityScores domainAbilityScores);
}
