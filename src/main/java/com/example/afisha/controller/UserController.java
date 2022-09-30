package com.example.afisha.controller;

import com.example.afisha.entity.UserEntity;
import com.example.afisha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try{
            userRepository.save(user);
            return ResponseEntity.ok("Пользователь " + user.getUsername() + " добавлен (точно добавлен)");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }


    @GetMapping
    public ResponseEntity getUsers(){
        try{
            return ResponseEntity.ok("Сервер работает (точно работает)");
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
