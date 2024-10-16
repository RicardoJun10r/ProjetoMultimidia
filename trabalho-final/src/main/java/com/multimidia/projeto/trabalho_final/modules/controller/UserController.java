package com.multimidia.projeto.trabalho_final.modules.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.multimidia.projeto.trabalho_final.modules.model.User;
import com.multimidia.projeto.trabalho_final.modules.service.UserService;
import com.multimidia.projeto.trabalho_final.modules.shared.AuthenticationRequest;
import com.multimidia.projeto.trabalho_final.modules.shared.UserResponseDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserResponseDTO> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> authenticate(@RequestBody AuthenticationRequest authRequest) {
        boolean isAuthenticated = userService.authenticate(authRequest.getNickname(), authRequest.getPassword());
        return ResponseEntity.ok(isAuthenticated);
    }

    @PostMapping("/{userNickname}/friends/{friendNickname}")
    public ResponseEntity<Void> addFriend(@PathVariable String userNickname, @PathVariable String friendNickname) {
        userService.addFriend(userNickname, friendNickname);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable UUID id) {
        UserResponseDTO user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLogin user){
        return this.userService.login(user.email(), user.password());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/buscar/{nickname}")
    public ResponseEntity<UserResponseDTO> getUserByNickname(@PathVariable String nickname) {
        UserResponseDTO user = userService.findByNickname(nickname);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
