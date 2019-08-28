package com.waiter.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        Authentication authentication = null;
        try {
            String token = servletRequest.getHeader(AuthConstants.HEADER_NAME);
            if (token != null) {
                Claims claims = Jwts.parser().setSigningKey(AuthConstants.SECRET_KEY)
                        .parseClaimsJws(token.replace(AuthConstants.TOKEN_PREFIX, "")).getBody();

                authentication = claims != null
                        ? new SessionContext(claims.get("id", Long.class), claims.get("username", String.class), Collections.emptyList()) : null;
            }
        } catch (ExpiredJwtException eje) {
            log.warn("Authorization Token is Expired.", eje.getMessage());
        } catch (Exception e) {
            log.error("Authentication failed.", e);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
}