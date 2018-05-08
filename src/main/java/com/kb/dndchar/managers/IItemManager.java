package com.kb.dndchar.managers;

import com.kb.dndchar.views.ViewItem;

import java.util.List;

public interface IItemManager {
    List<ViewItem> getAllItemsOfUser(String username);

    ViewItem getItemById(Long itemId, String username);

    ViewItem createItemForUser(String username, ViewItem viewItem);

    ViewItem updateItem(Long itemId, ViewItem viewItem);

    ViewItem deleteItem(Long itemId);
}
