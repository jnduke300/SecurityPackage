package com.dvi.app.security.securitypackage.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
     if(request.getServletPath().equals("/api/login")){
       filterChain.doFilter(request,response);
     }else{
         String authorizationHeader = request.getHeader(AUTHORIZATION);
         if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
             try {
                 String token = authorizationHeader.substring("Bearer ".length());
                 Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                 JWTVerifier verifier = JWT.require(algorithm).build();
                 DecodedJWT decodeToken = verifier.verify(token);
                 String username = decodeToken.getSubject();
                 String[] roles = decodeToken.getClaim("roles").asArray(String.class);
                 Collection<SimpleGrantedAuthority> authority = new ArrayList<>();
                 stream(roles).forEach(role -> authority.add(new SimpleGrantedAuthority(role)));
                 UsernamePasswordAuthenticationToken authenticationToken =
                         new UsernamePasswordAuthenticationToken(username,null,authority);
                 SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                 filterChain.doFilter(request,response);
             } catch (IllegalArgumentException e) {
                 log.error("Authorization Error Occoured:- {} ",e.getMessage());
                 response.setHeader("error",e.getMessage());

                 Map<String ,String> error = new HashMap<>();
                 error.put("error_message",e.getMessage());
                 response.setContentType(APPLICATION_JSON_VALUE);
                 new ObjectMapper().writeValue(response.getOutputStream(),error);
             } catch (JWTVerificationException e) {
                 log.error("Authorization Error Occoured:- {} ",e.getMessage());
                 response.setHeader("error",e.getMessage());

                 Map<String ,String> error = new HashMap<>();
                 error.put("error_message",e.getMessage());
                 response.setContentType(APPLICATION_JSON_VALUE);
                 new ObjectMapper().writeValue(response.getOutputStream(),error);

             }

         }else{
             filterChain.doFilter(request,response);
         }
     }
    }
}
