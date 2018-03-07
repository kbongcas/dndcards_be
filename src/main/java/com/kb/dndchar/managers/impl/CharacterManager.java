package com.kb.dndchar.managers.impl;

import com.kb.dndchar.accessors.ICharacterAccessor;
import com.kb.dndchar.converters.ICharacterConverter;
import com.kb.dndchar.converters.ILocalDateTimeConverter;
import com.kb.dndchar.domains.DomainCharacter;
import com.kb.dndchar.managers.ICharacterManager;
import com.kb.dndchar.views.ViewCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CharacterManager implements ICharacterManager {

    @Autowired
    ICharacterAccessor characterAccessor;

    @Autowired
    ICharacterConverter characterConverter;

    @Autowired
    ILocalDateTimeConverter localDateTimeConverter;

    @Override
    public List<ViewCharacter> getAllCharacters() {
        return characterAccessor.findAll().stream()
                .map(characterConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public ViewCharacter getCharacterById(Long characterId) {
        DomainCharacter domainCharacter = characterAccessor.findOne(characterId);
        if (domainCharacter == null) {
            throw new EntityNotFoundException("Unable to retrieve Character: " + characterId.toString());
        }
        return characterConverter.domainToView(domainCharacter);
    }

    @Override
    public ViewCharacter createCharacter(ViewCharacter viewCharacter) {
        return characterConverter.domainToView(
                characterAccessor.save(
                        characterConverter.viewToDomain(viewCharacter)));
    }

    @Override
    public ViewCharacter updateCharacter(Long characterId, ViewCharacter viewCharacter) {
        DomainCharacter currentCharacter = characterAccessor.findOne(characterId);
        if (currentCharacter == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + characterId.toString());
        } else if (!viewCharacter.getCharId().equals(characterId)) {
            throw new InvalidParameterException("Provided post id: "
                    + characterId.toString()
                    + " does not match provided post: "
                    + viewCharacter.toString());
        }
        return characterConverter.domainToView(
                characterAccessor.save(
                        characterConverter.viewToDomain(viewCharacter)));
    }

    @Override
    public ViewCharacter deleteCharacter(Long characterId) {
        DomainCharacter character = characterAccessor.findOne(characterId);
        if (character == null) {
            throw new EntityNotFoundException("Unable to retrieve post: " + characterId.toString());
        }
        characterAccessor.delete(characterId);
        return characterConverter.domainToView(character);
    }

    @Override
    public List<ViewCharacter> getCharacterByCreatedDate(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return characterAccessor.findByCreatedOnBetween(ldtStartDate, ldtEndDate).stream()
                .map(characterConverter::domainToView)
                .collect(Collectors.toList());
    }

    @Override
    public List<ViewCharacter> getCharacterByLastUpdated(Long startDate, Long endDate) {
        LocalDateTime ldtStartDate = localDateTimeConverter.convertLongToLocalDateTime(startDate);
        LocalDateTime ldtEndDate = localDateTimeConverter.convertLongToLocalDateTime(endDate);
        return characterAccessor.findByLastUpdatedBetween(ldtStartDate, ldtEndDate).stream()
                .map(characterConverter::domainToView)
                .collect(Collectors.toList());
    }
}
