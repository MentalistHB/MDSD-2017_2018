package io.swagger.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.swagger.model.File;

public interface FileRepository extends JpaRepository<File, UUID>{

}
