package com.company.service.impl;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.entity.UserRole;
import com.company.repository.UserRepository;
import com.company.service.UserRoleService;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, @Qualifier("userRoleService") UserRoleService roleService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }


    @Override
    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user = repository.saveAndFlush(user);
        Role role = new Role();
        role.setRole(UserRole.ROLE_USER);
        role.setUser(user);
        roleService.add(role);
        return user;
    }

    @Override
    public void delete(String login) {
        repository.delete(login);
    }

    @Override
    public User edit(User user) {
        return repository.saveAndFlush(user);
    }

    @Override
    public User getByLogin(String login) {
        return repository.getOne(login);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean exist(String login) {
        return repository.exists(login);
    }
}