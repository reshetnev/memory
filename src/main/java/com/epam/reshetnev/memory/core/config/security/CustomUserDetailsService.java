package com.epam.reshetnev.memory.core.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.epam.reshetnev.memory.core.entity.User;
import com.epam.reshetnev.memory.core.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        User user = userService.findByEmail(userName);
        if(user == null){
            throw new UsernameNotFoundException("UserName "+userName+" not found");
        }
        return new SecurityUser(user);
    }
}
