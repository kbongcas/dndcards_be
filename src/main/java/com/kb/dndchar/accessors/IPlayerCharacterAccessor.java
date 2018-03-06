package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.DomainCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerCharacterAccessor extends JpaRepository<DomainCharacter, Long> {

}
