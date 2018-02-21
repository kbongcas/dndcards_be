package com.kb.dndchar.domains;

import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Character")
public class Character {


    @RequestMapping(method = RequestMethod.GET)
    List<Character> getAllCharacters() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    Character createCharacter(@RequestBody Character character) {
        return null;
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.GET)
    Character getCharacter(@PathVariable Long characterId) {
        return null;
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.PUT)
    Character updateCharacter(@PathVariable Long characterId, @RequestBody Character character) {
        return null;
    }

    @RequestMapping(value = "/{characterId}", method = RequestMethod.DELETE)
    Character deleteCharacter(@PathVariable Long characterId) {
        return null;
    }
}
