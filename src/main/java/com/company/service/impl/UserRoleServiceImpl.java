package com.company.service.impl;

import com.company.entity.Role;
import com.company.repository.UserRoleRepository;
import com.company.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service(value = "userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role add(Role role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }

    @Override
    public Role edit(Role role) {
        return repository.saveAndFlush(role);
    }

}

