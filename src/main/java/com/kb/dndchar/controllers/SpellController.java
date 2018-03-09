package com.kb.dndchar.controllers;

import com.kb.dndchar.views.ViewSpell;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Spell")
public class SpellController {

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewSpell>> getAllSpells() {
       return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
    }

    @RequestMapping(value = "/{spellId}", method = RequestMethod.GET)
    ResponseEntity<ViewSpell> getSpell(@PathVariable Long spellId) {
        return new ResponseEntity<>(new ViewSpell(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{charId}", method = RequestMethod.GET)
    ResponseEntity<List<ViewSpell>> getSpellByCharId(@PathVariable Long charId) {
       return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.OK);
    }
}
