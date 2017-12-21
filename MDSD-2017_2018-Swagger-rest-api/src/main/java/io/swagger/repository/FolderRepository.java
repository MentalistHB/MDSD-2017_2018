package io.swagger.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Folder;

@Repository
public interface FolderRepository extends JpaRepository<Folder, String> {

}
