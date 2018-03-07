package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public interface ICharacterAccessor extends JpaRepository<DomainCharacter, Long> {

    List<DomainCharacter> findByCreatedOnBetween(LocalDateTime ldtStartDate, LocalDateTime ldtEndDate);
    List<DomainCharacter> findByLastUpdatedBetween(LocalDateTime ldtStartDate, LocalDateTime ldtEndDate);
}
