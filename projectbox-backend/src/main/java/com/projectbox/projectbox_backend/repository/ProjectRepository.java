package com.projectbox.projectbox_backend.repository;

import com.projectbox.projectbox_backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByCreateurId(Long utilisateurId);
}
