package com.waiter.authentication.user;

import com.waiter.authentication.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public void saveUser(String username, String password, String name){
        userRepository.save(new User(username, passwordEncoder.encode(password), name));
    }

    public User findByUserName(String username) {
        return userRepository.findByLoginId(username).orElseThrow(() -> new NoSuchElementException());
    }
}
