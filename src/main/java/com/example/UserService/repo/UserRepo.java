package com.example.UserService.repo;

import com.example.UserService.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository <AppUser, Integer> {
    Optional<AppUser> findByEmail (String email);
}
