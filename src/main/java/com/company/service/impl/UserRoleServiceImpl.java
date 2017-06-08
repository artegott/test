package com.company.service.impl;

import com.company.persistence.entity.Role;
import com.company.persistence.repository.UserRoleRepository;
import com.company.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Service(value = "userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository;
    private final Logger log = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Role findById(Long id) {
        return repository.findOne(id);
    }

}