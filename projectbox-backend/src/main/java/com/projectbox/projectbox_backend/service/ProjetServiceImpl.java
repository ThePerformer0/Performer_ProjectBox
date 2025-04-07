package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Projet;
import com.projectbox.projectbox_backend.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetServiceImpl implements ProjetService  {
    @Autowired
    private ProjetRepository projetRepository;

    @Override
    public Projet creerProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet obtenirProjetParId(Long id) {
        return projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé avec ID : " + id));
    }

    @Override
    public List<Projet> obtenirTousLesProjets() {
        return projetRepository.findAll();
    }

    @Override
    public List<Projet> obtenirProjetsParCreateur(Long createurId) {
        return projetRepository.findByCreateurId(createurId);
    }

    @Override
    public Projet mettreAJourProjet(Long id, Projet projetModifie) {
        Projet projetExistant = obtenirProjetParId(id);
        projetExistant.setTitre(projetModifie.getTitre());
        projetExistant.setDescription(projetModifie.getDescription());
        projetExistant.setDateDebut(projetModifie.getDateDebut());
        projetExistant.setDateFin(projetModifie.getDateFin());
        return projetRepository.save(projetExistant);
    }

    @Override
    public void supprimerProjet(Long id) {
        projetRepository.deleteById(id);
    }
}
