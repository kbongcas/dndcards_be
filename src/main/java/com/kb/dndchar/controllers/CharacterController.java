package com.kb.dndchar.controllers;

import com.kb.dndchar.domains.DomainCharacter;
import com.kb.dndchar.managers.ICharacterManager;
import com.kb.dndchar.views.ViewCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Character")
public class CharacterController {

    @Autowired
    ICharacterManager characterManager;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewCharacter>> getAllCharacters() {
        return new ResponseEntity<> (characterManager.getAllCharacters(), HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewCharacter> createCharacter(@RequestBody ViewCharacter viewCharacter) {
        return new ResponseEntity<>(characterManager.createCharacter(viewCharacter), HttpStatus.OK);
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.GET)
    ResponseEntity<ViewCharacter> getCharacter(@PathVariable Long characterId) {
        return new ResponseEntity<>(characterManager.getCharacterById(characterId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.PUT)
    ResponseEntity<ViewCharacter> updateCharacter(@PathVariable Long characterId,
                                                  @RequestBody ViewCharacter viewCharacter) {
        return new ResponseEntity<>(characterManager
                .updateCharacter(characterId, viewCharacter), HttpStatus.OK);
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewCharacter> deleteCharacter(@PathVariable Long characterId) {
        return new ResponseEntity<>(characterManager.deleteCharacter(characterId), HttpStatus.OK);
    }
}
