package com.projectbox.projectbox_backend.repository;

import com.projectbox.projectbox_backend.model.StatutTache;
import com.projectbox.projectbox_backend.model.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TacheRepository extends JpaRepository<Tache, Long> {
    List<Tache> findByProjetId(Long projetId);
    List<Tache> findByAssigneeId(Long assigneeId);
    List<Tache> findByStatut(StatutTache statut);
}