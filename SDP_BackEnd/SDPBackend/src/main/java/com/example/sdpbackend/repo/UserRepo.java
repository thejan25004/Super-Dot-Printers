package com.example.sdpbackend.repo;

import com.example.sdpbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByUserId(Long userId);
    Optional<User> findByEmail(String email);



}





