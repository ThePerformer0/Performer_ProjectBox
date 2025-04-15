package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User ajouterUtilisateur(User utilisateur);
    User obtenirUtilisateurParId(Long id);
    List<User> obtenirTousLesUtilisateurs();
    Optional<User> obtenirUtilisateurParEmail(String email);
    User mettreAJourUtilisateur(Long id, User utilisateur);
    void supprimerUtilisateur(Long id);
    void createAdmin();
}