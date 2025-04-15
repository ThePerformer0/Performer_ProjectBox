package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Statut;
import com.projectbox.projectbox_backend.model.Task;

import java.util.List;

public interface TaskService {
    Task creerTache(Task task);
    Task obtenirTacheParId(Long id);
    List<Task> obtenirToutesLesTaches();
    List<Task> obtenirTacheParSatut(Statut statut);
    List<Task> obtenirTacheParProjet(Long projetId);
    Task mettreAJourTache(Long id, Task task);
    void supprimerTache(Long id);
}