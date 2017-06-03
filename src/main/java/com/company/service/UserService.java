package com.company.service;


import com.company.entity.User;

import java.util.List;

public interface UserService {

    void save(User user);

    void delete(String login);

    void update(User user);

    User findByLogin(String login);

    List<User> findAll();

    boolean exists(String login);

}
