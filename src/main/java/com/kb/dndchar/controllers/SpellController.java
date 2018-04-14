package com.kb.dndchar.controllers;

import com.kb.dndchar.managers.ISpellManager;
import com.kb.dndchar.views.ViewSpell;
import org.keycloak.KeycloakPrincipal;
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

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewSpell>> getAllSpells() {
       return new ResponseEntity<>(spellManager.getAllSpells(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{spellId}", method = RequestMethod.GET)
    ResponseEntity<ViewSpell> getSpell(@PathVariable Long spellId) {
        return new ResponseEntity<>( spellManager.getSpellById(spellId), HttpStatus.OK);
    }

    /**
     * TODO - Don't let this override other spells in the db.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewSpell> createSpell(@RequestBody ViewSpell viewSpell) {
        return new ResponseEntity<>(spellManager.createSpell(viewSpell), HttpStatus.OK);
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
