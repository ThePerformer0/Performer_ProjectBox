package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.StatutTache;
import com.projectbox.projectbox_backend.model.Tache;

import java.util.List;

public interface TacheService {
    Tache creerTache(Tache tache);
    Tache obtenirTacheParId(Long id);
    List<Tache> obtenirToutesLesTaches();
    List<Tache> obtenirTacheParSatut(StatutTache statut);
    List<Tache> obtenirTacheParProjet(Long projetId);
    Tache mettreAJourTache(Long id, Tache tache);
    void supprimerTache(Long id);
}