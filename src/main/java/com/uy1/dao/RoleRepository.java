package com.uy1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uy1.Entities.Role;

public interface RoleRepository extends JpaRepository<Role, String> {

}
