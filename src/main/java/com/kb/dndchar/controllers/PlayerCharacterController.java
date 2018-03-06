package com.kb.dndchar.controllers;

import com.kb.dndchar.domains.DomainCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/DomainCharacter")
public class PlayerCharacterController {


    @RequestMapping(method = RequestMethod.GET)
    List<DomainCharacter> getAllPlayerCharacters() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    DomainCharacter createPlayerCharacter(@RequestBody DomainCharacter domainCharacter) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.GET)
    DomainCharacter getPlayerCharacter(@PathVariable Long playerCharacterId) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.PUT)
    DomainCharacter updatePlayerCharacter(@PathVariable Long playerCharacterId, @RequestBody DomainCharacter domainCharacter) {
        return null;
    }

    @RequestMapping(value = "/{playerCharacterId}", method = RequestMethod.DELETE)
    DomainCharacter deletePlayerCharacter(@PathVariable Long playerCharacterId) {
        return null;
    }
}
