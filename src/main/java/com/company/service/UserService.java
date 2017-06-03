package com.company.service;


import com.company.entity.User;

import java.util.List;

public interface UserService {

    User add(User user);

    void delete(String login);

    User edit(User user);

    User getByLogin(String login);

    List<User> getAll();

    boolean exist(String login);

}
