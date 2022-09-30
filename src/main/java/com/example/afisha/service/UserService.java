package com.example.afisha.service;

import com.example.afisha.entity.UserEntity;
import com.example.afisha.exception.UserAlreadyExistException;
import com.example.afisha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            return userRepository.save(user);
        } else
            throw new UserAlreadyExistException("Пользователь " + user.getUsername() + " уже существует");

    }
}
