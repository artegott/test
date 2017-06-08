package com.company.service;


import com.company.persistence.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(String login);

    User findByLogin(String login);

    List<User> findAll();

    boolean exists(String login);

}
