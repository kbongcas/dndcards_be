package com.kb.dndchar.converters;

import com.kb.dndchar.domains.DomainCharacter;
import com.kb.dndchar.views.ViewCharacter;

public interface ICharacterConverter {
    DomainCharacter viewToDomain(ViewCharacter viewCharacter);
    ViewCharacter domainToView(DomainCharacter domainCharacter);
}
