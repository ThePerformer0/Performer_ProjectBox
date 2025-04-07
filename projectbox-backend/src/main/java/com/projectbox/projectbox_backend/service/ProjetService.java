package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Projet;

import java.util.List;

public interface ProjetService {
    Projet creerProjet(Projet projet);
    Projet obtenirProjetParId(Long id);
    List<Projet> obtenirTousLesProjets();
    List<Projet> obtenirProjetsParCreateur(Long createurId);
    Projet mettreAJourProjet(Long id, Projet projet);
    void supprimerProjet(Long id);
}
