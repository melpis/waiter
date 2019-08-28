package com.waiter.authentication.config;

import com.waiter.authentication.user.LoginUser;
import com.waiter.authentication.user.User;
import com.waiter.authentication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(username).orElseThrow(() -> new NoSuchElementException());
        return new LoginUser(user.getId(), user.getLoginId(), user.getPassword());
    }
}
