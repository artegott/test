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
    public void save(Role role) {
        repository.save(role);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void update(Role role) {
        repository.save(role);
    }

    @Override
    public Role findById(Long id) {
        return repository.findOne(id);
    }

}

