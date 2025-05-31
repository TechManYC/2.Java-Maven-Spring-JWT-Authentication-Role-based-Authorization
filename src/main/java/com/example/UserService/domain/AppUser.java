package com.example.UserService.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Collection;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Builder //Good for fast object initialization
@Table(name ="_user") //Do not use "user"
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private String email; //includes email
    private String password;
    //@ManyToMany(fetch = FetchType.EAGER )
    //private Collection<Role> roles = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private Role role;

}
