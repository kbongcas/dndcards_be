package com.kb.dndchar.controllers;

import com.kb.dndchar.domains.DomainUser;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    List<DomainUser> getAllUsers() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    DomainUser createUser(@RequestBody DomainUser domainUser) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    DomainUser getUser(@PathVariable Long userId) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    DomainUser updateUser(@PathVariable Long userId, @RequestBody DomainUser domainUser) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    DomainUser deleteUser(@PathVariable Long userId) {
        return null;
    }
}
