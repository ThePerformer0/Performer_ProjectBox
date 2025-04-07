package com.projectbox.projectbox_backend.repository;

import com.projectbox.projectbox_backend.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepository extends JpaRepository<Projet, Long> {
    List<Projet> findByCreateurId(Long utilisateurId);
}
