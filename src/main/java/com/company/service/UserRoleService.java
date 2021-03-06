package com.company.service;


import com.company.persistence.entity.Role;

public interface UserRoleService {

    Role save(Role role);

    void delete(Long id);

    Role findById(Long id);

}
