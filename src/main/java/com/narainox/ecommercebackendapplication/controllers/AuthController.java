package com.narainox.ecommercebackendapplication.controllers;

import com.narainox.ecommercebackendapplication.dto.UserDto;
import com.narainox.ecommercebackendapplication.payloads.JwtAuthRequest;
import com.narainox.ecommercebackendapplication.payloads.JwtAuthResponse;
import com.narainox.ecommercebackendapplication.security.JwtTokenHelper;
import com.narainox.ecommercebackendapplication.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request)
    {
        authenticate(request.getUsername(),request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtTokenHelper.generateToken(userDetails);
        String username = jwtTokenHelper.getUsernameFromToken(token);
        JwtAuthResponse response=new JwtAuthResponse();
        response.setToken(token);
        response.setUsername(username);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(username,password);
        try {
            authenticationManager.authenticate(authenticationToken);
        }
        catch (BadCredentialsException badCredentialsException)
        {
            throw new BadCredentialsException("Credentials Invalid !!");
        }

    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto)
    {
        UserDto registerUser = userService.registerUser(userDto);
        return new ResponseEntity<>(registerUser,HttpStatus.CREATED);
    }
}
