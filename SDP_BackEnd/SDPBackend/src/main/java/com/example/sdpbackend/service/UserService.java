package com.example.sdpbackend.service;

import com.example.sdpbackend.dto.UserDTO;
import com.example.sdpbackend.entity.User;
import com.example.sdpbackend.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public boolean addUser(UserDTO userDTO) {
        if(userDTO.getProfilePictureUrl() == null || userDTO.getProfilePictureUrl().isEmpty()) {
            userDTO.setProfilePictureUrl("https://example.com/default-profile.png");
        }
        User user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        return true;
    }


    // Get user by ID
    public UserDTO getUserById(int userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.map(u -> modelMapper.map(u, UserDTO.class)).orElse(null);
    }

    // Update user
    public boolean updateUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepo.findById(userDTO.getUserId());
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setRole(userDTO.getRole());
            userRepo.save(user);
            return true;
        }
        return false;
    }


    // Delete user
    public boolean deleteUser(int userId) {
        if (userRepo.existsById(userId)) {
            userRepo.deleteById(userId);
            return true;
        }
        return false;
    }


    public List<UserDTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(u -> modelMapper.map(u, UserDTO.class)).collect(Collectors.toList());

    }

    // ✅ Sign In method (service part)
    public UserDTO signIn(String email, String password) {
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(password)) {
                return modelMapper.map(user, UserDTO.class);
            }
        }
        return null; // invalid login
    }
}
