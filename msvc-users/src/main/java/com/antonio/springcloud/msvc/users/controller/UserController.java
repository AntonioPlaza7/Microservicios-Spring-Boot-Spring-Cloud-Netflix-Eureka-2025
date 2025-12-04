package com.antonio.springcloud.msvc.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.antonio.springcloud.msvc.users.entities.User;
import com.antonio.springcloud.msvc.users.services.IUserService;
import com.antonio.springcloud.msvc.users.services.UserService;


@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        logger.info("UserController::getUserById: obteniendo user con id {}", id);
        return userService.findById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        logger.info("UserController::getUserByUsername login con {}", username);
        return userService.findByUsername(username)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        logger.info("UserController::getAllUsers: listando usuarios");
        return ResponseEntity.ok(userService.findAll());
    }
    

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        logger.info("UserController::createUser: creando {}", user);
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        logger.info("UserController::updateUser: actualizando {}", user);
        return userService.update(user, id)
        .map(userUpdated -> ResponseEntity.status(HttpStatus.CREATED).body(userUpdated))
        .orElseGet(() -> ResponseEntity.notFound().build());       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        logger.info("UserController::deleteUser: eliminando con id {}", id);
        return ResponseEntity.noContent().build();
    }
}
