package com.example.afisha.service;

import com.example.afisha.entity.UserEntity;
import com.example.afisha.exception.UserAlreadyExistException;
import com.example.afisha.exception.UserNotFoundException;
import com.example.afisha.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

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

    public UserEntity getUser(Long id) throws UserNotFoundException {
        try {
            userRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return userRepository.findById(id).get();
    }
}
