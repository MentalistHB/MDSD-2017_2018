package io.swagger.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.User;

public interface UserRepository extends JpaRepository<User, UUID>{

	public User findByToken(UUID token);
}
