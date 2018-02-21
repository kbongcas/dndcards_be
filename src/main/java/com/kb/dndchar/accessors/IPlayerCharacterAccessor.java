package com.kb.dndchar.accessors;

import com.kb.dndchar.domains.PlayerCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlayerCharacterAccessor extends JpaRepository<PlayerCharacter, Long> {

}
