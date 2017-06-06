package com.company.service.impl;

import com.company.entity.Role;
import com.company.entity.User;
import com.company.entity.UserRole;
import com.company.repository.sql.UserRepository;
import com.company.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole(new Role(user, UserRole.ROLE_USER));
        return repository.save(user);
    }

    @Override
    public void delete(String login) {
        repository.delete(login);
    }

    @Override
    public User findByLogin(String login) {
        return repository.getOne(login);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean exists(String login) {
        return repository.exists(login);
    }
}