package com.FundManager.service;

import com.FundManager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyDBAuthenticationService  implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(" User " + username + "was not found in the database");
        }

        List<GrantedAuthority> grantedList = new ArrayList<>();
        grantedList.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),grantedList);
        return userDetails;
    }
}
