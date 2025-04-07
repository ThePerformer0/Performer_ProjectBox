package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.model.StatutTache;
import com.projectbox.projectbox_backend.model.Tache;
import com.projectbox.projectbox_backend.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/taches")
@CrossOrigin(origins = "*")
public class TacheController {

    @Autowired
    private TacheService tacheService;

    @PostMapping
    public Tache creerTache(@RequestBody Tache tache){
        return tacheService.creerTache(tache);
    }

    @GetMapping("/{id}")
    public Tache obtenirTache(@PathVariable Long id){
        return tacheService.obtenirTacheParId(id);
    }

    @GetMapping
    public List<Tache> obtenirToutesLesTaches() {
        return tacheService.obtenirToutesLesTaches();
    }

    @GetMapping("/{statut}")
    public List<Tache> obtenirTacheParSatut(@PathVariable StatutTache statut) {
        return tacheService.obtenirTacheParSatut(statut);
    }

    @GetMapping("/projet/{projetId}")
    public List<Tache> obtenirTacheParProjet(@PathVariable Long projetId) {
        return tacheService.obtenirTacheParProjet(projetId);
    }

    @PutMapping("/{id}")
    public Tache mettreAJourTache(@PathVariable Long id, @RequestBody Tache tache) {
        return tacheService.mettreAJourTache(id, tache);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        tacheService.supprimerTache(id);
    }
}
