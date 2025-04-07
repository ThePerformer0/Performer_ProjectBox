package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.model.Projet;
import com.projectbox.projectbox_backend.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/projets")
@CrossOrigin(origins = "*")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @PostMapping
    public Projet creerProjet(@RequestBody Projet projet) {
        return projetService.creerProjet(projet);
    }

    @GetMapping("/{id}")
    public Projet obtenirProjet(@PathVariable Long id) {
        return projetService.obtenirProjetParId(id);
    }

    @GetMapping
    public List<Projet> obtenirTousLesProjets() {
        return projetService.obtenirTousLesProjets();
    }

    @GetMapping("/utilisateur/{id}")
    public List<Projet> obtenirProjetsParUtilisateur(@PathVariable Long id) {
        return projetService.obtenirProjetsParCreateur(id);
    }

    @PutMapping("/{id}")
    public Projet mettreAJourProjet(@PathVariable Long id, @RequestBody Projet projet) {
        return projetService.mettreAJourProjet(id, projet);
    }

    @DeleteMapping("/{id}")
    public void supprimerProjet(@PathVariable Long id) {
        projetService.supprimerProjet(id);
    }
}
