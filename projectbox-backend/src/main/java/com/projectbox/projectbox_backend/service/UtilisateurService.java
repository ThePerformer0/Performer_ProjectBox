package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur ajouterUtilisateur(Utilisateur utilisateur);
    Utilisateur obtenirUtilisateurParId(Long id);
    List<Utilisateur> obtenirTousLesUtilisateurs();
    Optional<Utilisateur> obtenirUtilisateurParEmail(String email);
    Utilisateur mettreAJourUtilisateur(Long id, Utilisateur utilisateur);
    void supprimerUtilisateur(Long id);
}