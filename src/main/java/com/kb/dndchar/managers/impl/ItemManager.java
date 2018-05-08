package com.kb.dndchar.managers.impl;

import com.kb.dndchar.accessors.IItemAccessor;
import com.kb.dndchar.accessors.IUserAccessor;
import com.kb.dndchar.accessors.impl.ItemAccessorCustom;
import com.kb.dndchar.accessors.impl.UserAccessorCustom;
import com.kb.dndchar.converters.IItemConverter;
import com.kb.dndchar.domains.DomainItem;
import com.kb.dndchar.views.ViewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemManager implements com.kb.dndchar.managers.IItemManager {

    @Autowired
    IItemConverter itemConverter;

    @Autowired
    IItemAccessor itemAccessor;

    @Autowired
    IUserAccessor userAccessor;

    @Autowired
    UserAccessorCustom userAccessorCustom;

    @Autowired
    ItemAccessorCustom itemAccessorCustom;

    @Override
    public List<ViewItem> getAllItemsOfUser(String username) {
        return itemAccessorCustom.getItemsOfUser(username).stream()
                .map(itemConverter::domainToView)
                .collect(Collectors.toList());
    }

    /**
     * @Todo need to make sure not to get/edit other peoples's item
     */
    @Override
    public ViewItem getItemById(Long itemId, String username) {
        DomainItem domainItem = itemAccessor.findOne(itemId);
        if (domainItem == null) {
            throw new EntityNotFoundException("Could not retrieve Item with Id: " +
            itemId.toString()) ;
        }
        return itemConverter.domainToView(domainItem);
    }

    @Override
    public ViewItem createItemForUser(String username, ViewItem viewItem) {
        if(userAccessor.findByUsername(username) == null){
            throw new EntityNotFoundException("Could not retrieve user with username: " +
            username);
        }
        ViewItem createdItem = itemConverter.domainToView(
                        itemAccessor.save(
                        itemConverter.viewToDomain(viewItem)));
        if(createdItem != null) {
            userAccessorCustom.addToHasItemTable(username, createdItem.getItemId());
        }
        return createdItem;
    }

     /**
     * @Todo need to make sure not to get/edit other peoples's item
     */
    @Override
    public ViewItem updateItem(Long itemId, ViewItem viewItem) {
        DomainItem currentItem = itemAccessor.findOne(itemId);
        if (itemId == null) {
            throw new EntityNotFoundException("Could not retrieve Item with ID: " + itemId.toString());
        } else if (!viewItem.getItemId().equals(itemId)) {
            throw new InvalidParameterException("Provided Item ID: "
                    + itemId.toString()
                    + " does not match provided Item ID: "
                    + itemId.toString());
        }
        return itemConverter.domainToView(
                itemAccessor.save(
                        itemConverter.viewToDomain(viewItem)));
    }

    @Override
    public ViewItem deleteItem(Long itemId) {
        DomainItem item = itemAccessor.findOne(itemId);
        if (item == null) {
            throw new EntityNotFoundException("Unable to retrieve Item: " + itemId.toString());
        }
        itemAccessor.delete(itemId);
        return itemConverter.domainToView(item);
    }

    /*8
    @Override
    public List<ViewItem> getItemName(String name) {
         return  itemAccessorCustom.getItemsOfUser(name).stream()
                .map(itemConverter:: domainToView)
                .collect(Collectors.toList());
    }
    */
}
