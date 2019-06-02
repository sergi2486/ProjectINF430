package com.uy1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.uy1.Entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	

	@Modifying
	@Query(value="insert into user_role (user, role) values(?1, ?2)", nativeQuery = true)
	public int insertRoleToUser(String user, String role);
}
