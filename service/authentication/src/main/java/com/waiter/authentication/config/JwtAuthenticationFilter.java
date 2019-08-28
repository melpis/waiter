package com.waiter.authentication.config;

import com.waiter.authentication.user.User;
import com.waiter.authentication.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private UserService userService;

    protected JwtAuthenticationFilter(String urlPath, AuthenticationManager manager, UserService userService) {
        super(urlPath);
        setAuthenticationManager(manager);
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        log.info("attemptAuthentication  call!!");
        WaiterCredentials user = new ObjectMapper().readValue(request.getInputStream(), WaiterCredentials.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        log.info("successfulAuthentication call!!");

        User user = userService.findByUserName(auth.getName());

        String jwt = Jwts.builder()
                .setExpiration(
                        new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(AuthConstants.EXPIRATION_HOUR)))
                .claim("id", user.getId())
                .claim("username", user.getName())
                .signWith(SignatureAlgorithm.HS512, AuthConstants.SECRET_KEY).compact();
        response.addHeader(AuthConstants.HEADER_NAME, AuthConstants.TOKEN_PREFIX + jwt);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        System.out.println(failed);
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
