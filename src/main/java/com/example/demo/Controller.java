package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.*;

@RestController
@RequestMapping("/api")
public class Controller {
    private final DatabaseService databaseService;
@Autowired
    public Controller(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    @GetMapping("/date")
    public Users selectUser(@RequestParam String login) throws SQLException {
        return databaseService.selectUser(login);
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> insertUser(@RequestBody Users userNew) {
        if (userNew.getLogin() != null && userNew.getPassword() != null && userNew.getEmail() != null) {
            return ResponseEntity.ok(databaseService.insertUser(userNew));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }
}