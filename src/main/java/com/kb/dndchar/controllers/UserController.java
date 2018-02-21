package com.kb.dndchar.controllers;

import com.kb.dndchar.domains.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAllUsers() {
        return Collections.emptyList();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    User createUser(@RequestBody User user) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    User getUser(@PathVariable Long userId) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return null;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    User deleteUser(@PathVariable Long userId) {
        return null;
    }
}
