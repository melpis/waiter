package com.waiter.config;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
public class SessionContext extends UsernamePasswordAuthenticationToken {

    private Long id;

    private String name;

    public SessionContext(Long userId, String name, Collection<? extends GrantedAuthority> authorities) {
        super(userId, null, authorities);
        this.id = userId;
        this.name = name;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
