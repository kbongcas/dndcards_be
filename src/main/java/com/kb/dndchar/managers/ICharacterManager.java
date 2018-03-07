package com.kb.dndchar.managers;

import com.kb.dndchar.views.ViewCharacter;

import java.util.List;

public interface ICharacterManager {
    List<ViewCharacter> getAllCharacters();
    ViewCharacter getCharacterById(Long characterId);
    ViewCharacter createCharacter(ViewCharacter viewCharacter);
    ViewCharacter updateCharacter(Long characterId, ViewCharacter viewCharacter);
    ViewCharacter deleteCharacter(Long characterId);
    List<ViewCharacter> getCharacterByCreatedDate(Long startDate, Long endDate);
    List<ViewCharacter> getCharacterByLastUpdated(Long startDate, Long endDate);
}
