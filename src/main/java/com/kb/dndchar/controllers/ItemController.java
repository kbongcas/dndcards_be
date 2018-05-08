package com.kb.dndchar.controllers;

import com.kb.dndchar.managers.IItemManager;
import com.kb.dndchar.views.ViewItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Item")
public class ItemController {

    @Autowired
    IItemManager IItemManager;

     @RequestMapping(value ="", method = RequestMethod.GET)
    ResponseEntity<List<ViewItem>> getAllItemsOfUser(Principal principal) {
       return new ResponseEntity<>(IItemManager.getAllItemsOfUser(principal.getName()), HttpStatus.OK);
    }

     @RequestMapping(value ="/{itemId}", method = RequestMethod.GET)
    ResponseEntity<ViewItem> getItemById(Principal principal, @PathVariable Long itemId) {
       return new ResponseEntity<>(IItemManager.getItemById(itemId, principal.getName()), HttpStatus.OK);
    }

    /**
     * TODO - Don't let this override other items in the db.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<ViewItem> createItemForUser(Principal principal, @RequestBody ViewItem viewItem) {
        return new ResponseEntity<>(IItemManager.createItemForUser(principal.getName(), viewItem), HttpStatus.OK);
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
    ResponseEntity<ViewItem> updateItem(@PathVariable Long itemId,
                                                  @RequestBody ViewItem viewItem) {
        return new ResponseEntity<>(IItemManager
                .updateItem(itemId, viewItem), HttpStatus.OK);
    }

    /**
     * TODO - fix returning viewitem giving a different item id.
     */
    @RequestMapping(value = "/{itemId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewItem> deleteItem(@PathVariable Long itemId) {
        return new ResponseEntity<>(IItemManager.deleteItem(itemId), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    ResponseEntity<String> customers(Principal principal){
        return new ResponseEntity<>(principal.getName(), HttpStatus.OK);
    }
}
