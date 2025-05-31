package com.example.UserService.security;

import com.example.UserService.domain.AppUser;
import com.example.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        if (appUser == null) { // Check if user is null
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        // Convert your AppUser to CustomUserDetails
        // Assuming CustomUserDetails constructor takes AppUser or has a static build method
        return new CustomUserDetails(appUser);
        // Or using the static build method if available: return CustomUserDetails.build(appUser);
    }
}
