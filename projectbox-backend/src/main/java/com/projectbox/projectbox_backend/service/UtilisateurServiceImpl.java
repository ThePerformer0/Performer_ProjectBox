package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Utilisateur;
import com.projectbox.projectbox_backend.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public Utilisateur ajouterUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur obtenirUtilisateurParId(Long id) {
        return utilisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("utilisateur non trouvé avec ID : " + id));
    }

    @Override
    public List<Utilisateur> obtenirTousLesUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> obtenirUtilisateurParEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    @Override
    public Utilisateur mettreAJourUtilisateur(Long id, Utilisateur utilisateurModifie) {
        Utilisateur utilisateurExistant = obtenirUtilisateurParId(id);
        utilisateurExistant.setEmail(utilisateurModifie.getEmail());
        utilisateurExistant.setPrenom(utilisateurModifie.getPrenom());
        utilisateurExistant.setNom(utilisateurModifie.getNom());
        utilisateurExistant.setMotDePasse(utilisateurModifie.getMotDePasse());
        return utilisateurRepository.save(utilisateurExistant);
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
