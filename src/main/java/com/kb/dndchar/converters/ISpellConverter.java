package com.kb.dndchar.converters;

import com.kb.dndchar.domains.DomainSpell;
import com.kb.dndchar.views.ViewSpell;

public interface ISpellConverter {
    DomainSpell viewToDomain(ViewSpell viewSpell);
    ViewSpell domainToView(DomainSpell domainSpell);
}
