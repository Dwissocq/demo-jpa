package org.bernardhugueney.demojpa.controller;

import org.bernardhugueney.demojpa.model.City;
import org.bernardhugueney.demojpa.model.User;
import org.bernardhugueney.demojpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/{identifiant}", method = RequestMethod.GET)
    public Optional<User> readOne(@PathVariable("identifiant") Long id) {
        return userRepository.findById(id);
    }
}
