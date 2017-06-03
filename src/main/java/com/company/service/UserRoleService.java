package com.company.service;


import com.company.entity.Role;

public interface UserRoleService {

    Role add(Role role);

    void delete(long id);

    Role edit(Role role);

}
