package io.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.File;

public interface FileRepository extends JpaRepository<File, String> {

	public File findByName(String name);
}
