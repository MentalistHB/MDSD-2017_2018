package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByToken(String token);

	public User findByUsername(String username);

	public User findByUsernameAndPassword(String username, String password);
}
