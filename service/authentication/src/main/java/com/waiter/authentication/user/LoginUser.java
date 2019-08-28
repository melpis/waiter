package com.waiter.authentication.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class LoginUser extends User {

    private Long userId;

    private String userName;

    private String password;

    public LoginUser(Long userId, String userName, String password) {
        super(userName, password, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
