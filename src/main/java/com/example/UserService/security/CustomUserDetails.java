package com.example.UserService.security;

import com.example.UserService.domain.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.UserService.domain.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private AppUser appUser;

    public CustomUserDetails(AppUser appUser) {
        this.appUser = appUser;
        this.role = appUser.getRole();
    }

    @Enumerated(EnumType.STRING)
    private Role role;

    // --- Core UserDetails methods ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
        // Map each Role object from AppUser to a SimpleGrantedAuthority
        //return appUser.getRole().stream()
         //       .map(role -> new SimpleGrantedAuthority(role.getName()))
         //       .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return appUser.getEmail();
    }

    // --- Account status methods ---
    // For now, they return true, assuming accounts are generally active.

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement logic based on AppUser if you track account expiry
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement logic based on AppUser if you track account locking
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement logic based on AppUser if you track credential expiry
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement logic based on AppUser if you have an 'enabled' field
    }

    // --- Custom method to access the underlying AppUser ---
    // This is useful for accessing other properties of AppUser
    public AppUser getAppUser() {
        return appUser;
    }

    /**
     * Static factory method to build a CustomUserDetails instance from an AppUser.
     * This can be convenient in your UserDetailsService.
     * @param appUser The AppUser entity to build UserDetails from.
     * @return A new CustomUserDetails instance.
     */
    public static CustomUserDetails build(AppUser appUser) {
        return new CustomUserDetails(appUser);
    }

}
