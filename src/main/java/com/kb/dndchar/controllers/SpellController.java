package com.kb.dndchar.controllers;

import com.kb.dndchar.managers.ISpellManager;
import com.kb.dndchar.views.ViewSpell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewSpell>> getSpellsByCharId(@RequestParam(value="charId")Long charId) {
       return new ResponseEntity<>(spellManager.getSpellsByCharId(charId), HttpStatus.OK);
    }
}
