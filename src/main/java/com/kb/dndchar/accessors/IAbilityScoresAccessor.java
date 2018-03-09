package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainAbilityScores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAbilityScoresAccessor extends JpaRepository<DomainAbilityScores, Long> {
}
