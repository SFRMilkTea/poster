package com.example.afisha.controller;

import com.example.afisha.entity.EventEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @PostMapping
    public ResponseEntity createEvent(@RequestBody EventEntity event,
                                      @RequestParam Long userId) {
        try {
            return ResponseEntity.ok("OK.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
