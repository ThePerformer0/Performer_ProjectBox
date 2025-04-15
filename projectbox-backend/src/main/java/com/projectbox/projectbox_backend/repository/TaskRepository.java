package com.projectbox.projectbox_backend.repository;

import com.projectbox.projectbox_backend.model.Statut;
import com.projectbox.projectbox_backend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjetId(Long projetId);
    List<Task> findByAssigneeId(Long assigneeId);
    List<Task> findByStatut(Statut statut);
}