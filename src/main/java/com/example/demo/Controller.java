package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.currentTimeMillis;

@RestController
@RequestMapping("/api")
public class Controller {

    @GetMapping("/date")
    public ResponseEntity<?> getStaticJson() {
        try {
            Thread.sleep(2000); // добавляем задержку в 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Map<String, String> response = new HashMap<>();
        response.put("message", "Static JSON");

        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<?> postLogin(@RequestBody Map<String, String> userNew) {
        try {
            Thread.sleep(2000); // добавляем задержку в 2 секунды
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (userNew.size() == 2 && userNew.containsKey("login") && userNew.containsKey("password")) {
            User user = new User();
            user.setLogin(userNew.get("login"));
            user.setPassword(userNew.get("password"));
            user.setDate(LocalDateTime.now());

            return ResponseEntity.ok(user);

        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}