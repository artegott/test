package com.company.security;

import com.company.persistence.entity.Role;
import com.company.persistence.entity.User;
import com.company.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service(value = "customUserDetails")
public class MyUserDetails implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public MyUserDetails(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = repository.findByLogin(s);
        List<Role> roles = Arrays.asList(user.getRole());
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(), user.getPassword(), user.getEnabled(), true,
                true, true, buildUserAuthority(roles));
    }

    private List<GrantedAuthority> buildUserAuthority(List<Role> roles) {
        List<GrantedAuthority> setAuth = new ArrayList<>();
        for (Role role : roles) {
            setAuth.add(new SimpleGrantedAuthority(role.getRole().name()));
        }
        return setAuth;
    }


}
