package com.amgad.service;

import com.amgad.entity.User;
import com.amgad.model.UserDTO;
import com.amgad.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    public void addUser(UserDTO userDTO) {
        this.userRepository.save(fillUser(userDTO));
    }

    private User fillUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setAge(userDTO.getAge());
        return user;
    }
}
