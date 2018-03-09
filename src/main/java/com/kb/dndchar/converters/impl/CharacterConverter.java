package com.kb.dndchar.converters.impl;

import com.kb.dndchar.accessors.IAbilityScoresAccessor;
import com.kb.dndchar.converters.IAbilityScoresConverter;
import com.kb.dndchar.converters.ICharacterConverter;
import com.kb.dndchar.converters.ILocalDateTimeConverter;
import com.kb.dndchar.domains.DomainCharacter;
import com.kb.dndchar.views.ViewCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CharacterConverter implements ICharacterConverter {

    @Autowired
    ILocalDateTimeConverter localDateTimeConverter;

    @Autowired
    IAbilityScoresConverter abilityScoresConverter;

    @Autowired
    IAbilityScoresAccessor abilityScoresAccessor;

    @Override
    public DomainCharacter viewToDomain(ViewCharacter viewCharacter) {
        DomainCharacter domainCharacter = new DomainCharacter();
        domainCharacter.setCharId(viewCharacter.getCharId());
        domainCharacter.setCharName(viewCharacter.getCharName());
        LocalDateTime now = LocalDateTime.now();
        domainCharacter.setLastUpdated(now);
        if (viewCharacter.getCharId() == null){
            domainCharacter.setCreatedOn(now);
        } else {
            domainCharacter.setCreatedOn(localDateTimeConverter
                    .convertLongToLocalDateTime(viewCharacter.getCreatedOn()));
        }
        domainCharacter.setDomainAbilityScores(abilityScoresConverter
                .viewToDomain(viewCharacter.getViewAbilityScores(), viewCharacter.getCharId()));
        return domainCharacter;
    }

    @Override
    public ViewCharacter domainToView(DomainCharacter domainCharacter) {
        ViewCharacter viewCharacter = new ViewCharacter();
        viewCharacter.setCharId(domainCharacter.getCharId());
        viewCharacter.setCharName(domainCharacter.getCharName());
        viewCharacter.setLastUpdated(localDateTimeConverter
                .convertLocalDateTimeToLong(domainCharacter.getLastUpdated()));
        viewCharacter.setCreatedOn(localDateTimeConverter
                .convertLocalDateTimeToLong(domainCharacter.getCreatedOn()));
        viewCharacter.setViewAbilityScores(abilityScoresConverter
                .domainToView(abilityScoresAccessor.findOne(domainCharacter.getCharId())));
        return viewCharacter;
    }
}
