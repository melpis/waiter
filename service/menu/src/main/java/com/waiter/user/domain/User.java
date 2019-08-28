package com.waiter.user.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String password;

    private String role;

    public User(String name, String password, String role) {
        Assert.notNull(name, "require name");
        Assert.notNull(password, "require password");

        this.name = name;
        this.password = password;
        this.role = role;
    }
}
