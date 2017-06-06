package com.company.repository.sql;


import com.company.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, Long> {
}
