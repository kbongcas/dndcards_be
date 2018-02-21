package com.kb.dndchar.controllers;

import com.kb.dndchar.domains.PlayerCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/PlayerCharacter")
public class PlayerCharacterController {


    @RequestMapping(method = RequestMethod.GET)
    List<PlayerCharacter> getAllPlayerCharacters() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    PlayerCharacter createPlayerCharacter(@RequestBody PlayerCharacter playerCharacter) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.GET)
    PlayerCharacter getPlayerCharacter(@PathVariable Long playerCharacterId) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.PUT)
    PlayerCharacter updatePlayerCharacter(@PathVariable Long playerCharacterId, @RequestBody PlayerCharacter playerCharacter) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.DELETE)
    PlayerCharacter deletePlayerCharacter(@PathVariable Long playerCharacterId) {
        return null;
    }
}
