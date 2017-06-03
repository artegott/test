package com.company.service;


import com.company.entity.Role;

public interface UserRoleService {

    void save(Role role);

    void delete(Long id);

    void update(Role role);

    Role findById(Long id);

}
