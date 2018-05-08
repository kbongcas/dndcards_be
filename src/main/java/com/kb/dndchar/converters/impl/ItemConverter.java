package com.kb.dndchar.converters.impl;

import com.kb.dndchar.converters.IItemConverter;
import com.kb.dndchar.domains.DomainItem;
import com.kb.dndchar.views.ViewItem;
import org.springframework.stereotype.Service;

@Service
public class ItemConverter implements IItemConverter {
    @Override
    public DomainItem viewToDomain(ViewItem viewItem) {
        DomainItem domainItem = new DomainItem();
        domainItem.setItemId(viewItem.getItemId());
        domainItem.setItemName(viewItem.getItemName());
        domainItem.setItemType(viewItem.getItemType());
        domainItem.setItemCost(viewItem.getItemCost());
        domainItem.setItemWeight(viewItem.getItemWeight());
        domainItem.setItemDesc(viewItem.getItemDesc());
        return domainItem;
    }

    @Override
    public ViewItem domainToView(DomainItem domainItem) {
        ViewItem viewItem = new ViewItem();
        viewItem.setItemId(domainItem.getItemId());
        viewItem.setItemName(domainItem.getItemName());
        viewItem.setItemType(domainItem.getItemType());
        viewItem.setItemCost(domainItem.getItemCost());
        viewItem.setItemWeight(domainItem.getItemWeight());
        viewItem.setItemDesc(domainItem.getItemDesc());
        return viewItem;
    }
}
