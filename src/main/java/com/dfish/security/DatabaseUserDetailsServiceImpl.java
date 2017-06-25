package com.dfish.security;

import com.dfish.domain.entity.User;
import com.dfish.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Administrator on 2017/6/21 0021.
 */

@Service
public class DatabaseUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        UserDetails userDetails = null;
        if (user == null) {
            throw new UsernameNotFoundException("user not found!");
        } else {
            Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));

            userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
        }
        return userDetails;
    }
}
