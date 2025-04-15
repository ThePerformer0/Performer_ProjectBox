package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Project;

import java.util.List;

public interface ProjectService {
    Project creerProjet(Project project);
    Project obtenirProjetParId(Long id);
    List<Project> obtenirTousLesProjets();
    List<Project> obtenirProjetsParCreateur(Long createurId);
    Project mettreAJourProjet(Long id, Project project);
    void supprimerProjet(Long id);
}
