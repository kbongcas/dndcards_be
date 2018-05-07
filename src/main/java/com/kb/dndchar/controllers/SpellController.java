package com.kb.dndchar.controllers;

import com.kb.dndchar.managers.ISpellManager;
import com.kb.dndchar.views.ViewSpell;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Spell")
public class SpellController {

    @Autowired
    ISpellManager spellManager;

    @RequestMapping(value ="", method = RequestMethod.GET)
    ResponseEntity<List<ViewSpell>> getAllSpellsOfUser( Principal principal) {
       return new ResponseEntity<>(spellManager.getAllSpellsOfUser(principal.getName()), HttpStatus.OK);
    }

     @RequestMapping(value ="/{spellId}", method = RequestMethod.GET)
    ResponseEntity<ViewSpell> getSpellById( Principal principal, @PathVariable Long spellId) {
       return new ResponseEntity<>(spellManager.getSpellById(spellId, principal.getName()), HttpStatus.OK);
    }

    /**
     * TODO - Don't let this override other spells in the db.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    ResponseEntity<ViewSpell> createSpellForUser(Principal principal, @RequestBody ViewSpell viewSpell) {
        return new ResponseEntity<>(spellManager.createSpellForUser(principal.getName(), viewSpell), HttpStatus.OK);
    }

    @RequestMapping(value = "/{spellId}", method = RequestMethod.PUT)
    ResponseEntity<ViewSpell> updateSpell(@PathVariable Long spellId,
                                                  @RequestBody ViewSpell viewSpell) {
        return new ResponseEntity<>(spellManager
                .updateSpell(spellId, viewSpell), HttpStatus.OK);
    }

    /**
     * TODO - fix returning viewspell giving a different spell id.
     */
    @RequestMapping(value = "/{spellId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewSpell> deleteSpell(@PathVariable Long spellId) {
        return new ResponseEntity<>(spellManager.deleteSpell(spellId), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    ResponseEntity<String> customers(Principal principal){
        return new ResponseEntity<>(principal.getName(), HttpStatus.OK);
    }
}
