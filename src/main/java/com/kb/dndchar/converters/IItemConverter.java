package com.kb.dndchar.converters;

import com.kb.dndchar.domains.DomainItem;
import com.kb.dndchar.views.ViewItem;

public interface IItemConverter {
    DomainItem viewToDomain(ViewItem viewItem);
    ViewItem domainToView(DomainItem domainItem);
}
