package com.example.demo;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Map;
import java.sql.*;

@RestController
@RequestMapping("/api")
public class Controller {
    DatabaseService userService = new DatabaseService();

    @GetMapping("/date")
    public Users selectUser(@RequestParam String login) throws SQLException {
        return userService.selectUser(login);
    }

//    @GetMapping("/date")
//    public Users selectUser(String login) throws SQLException {
//        Connection connection = null;
//        ResultSet resultSet = null;
//        Statement statement = null;



    @PostMapping("/login")
    public int insertUser(@RequestBody Map<String,String> userNew) {
        if (userNew.size() == 3 && userNew.containsKey("login") && userNew.containsKey("password") && userNew.containsKey("email")) {
            return userService.insertUser((Users) userNew);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

//        @PostMapping("/login")
//        public int insertUser(Users userNew) {
//            String queryInsert = "INSERT INTO users(login, password) VALUES (?,?);" + "\n" + "INSERT INTO emails(login, email) VALUES (?,?)";
//            try (Connection connection2 = DriverManager.getConnection(url, username, password);
//                 PreparedStatement ps = connection2.prepareStatement(queryInsert)) {

    }
}