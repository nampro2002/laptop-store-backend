package com.example.backendspringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backendspringboot.Entity.User;
import com.example.backendspringboot.model.user.dto.LoginDTOResponse;
import com.example.backendspringboot.model.user.dto.UserInfoDTOResponse;
import com.example.backendspringboot.model.userDetails.MyUserDetails;
import com.example.backendspringboot.repository.UserRepository;
import com.example.backendspringboot.security.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    // private final PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserDetails(user);
    }

    public LoginDTOResponse login(String username, String password) {
        System.out.println("username: " + username + " password: " + password);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        username,
                        password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);
        User user = userRepository.findByUsername(username);
        UserInfoDTOResponse userInfoDTOResponse = UserInfoDTOResponse.builder().id(user.getId()).username(user.getUsername())
                .name(user.getName())
                .phone(user.getPhone()).imgUrl(user.getImgUrl()).address(user.getAddress()).build();
        return LoginDTOResponse.builder().accessToken(token).userInfo(userInfoDTOResponse).build();

    }

}
