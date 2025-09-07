package com.example.sdpbackend.controller;

import com.example.sdpbackend.dto.UserDTO;
import com.example.sdpbackend.entity.User;
import com.example.sdpbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;



    // Add user
    @PostMapping(value = "save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserDTO userDTO) {
        boolean res = userService.addUser(userDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", res ? "User Save success" : "User Save failed");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Get user by ID
    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") int userId) {
        UserDTO user = userService.getUserById(userId);
        if (user != null) return ResponseEntity.ok(user);
        else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // Update user
    @PutMapping("/update")
    public ResponseEntity<Map<String, String>> updateUser(@RequestBody UserDTO userDTO) {
        boolean res = userService.updateUser(userDTO);
        Map<String,String> response = new HashMap<>();
        response.put("message", res ? "User updated successfully" : "User update failed");
        return ResponseEntity.ok(response);
    }


    // Delete user
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable("id") int userId) {
        boolean res = userService.deleteUser(userId);
        Map<String, String> response = new HashMap<>();
        response.put("message", res ? "User Delete success" : "User Delete failed");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signIn(@RequestBody UserDTO userDTO) {
        UserDTO loggedUser = userService.signIn(userDTO.getEmail(), userDTO.getPassword());
        Map<String, String> response = new HashMap<>();

        if (loggedUser != null) {
            response.put("message", "Login successful");
            response.put("userId", String.valueOf(loggedUser.getUserId()));
            response.put("name", loggedUser.getName());
            response.put("role", loggedUser.getRole());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }



}
