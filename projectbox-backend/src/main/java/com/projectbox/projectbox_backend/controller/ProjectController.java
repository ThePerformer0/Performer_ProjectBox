package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.model.Project;
import com.projectbox.projectbox_backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project creerProjet(@RequestBody Project project) {
        System.out.println("Hellos");
        return projectService.creerProjet(project);
    }

    @GetMapping("/{id}")
    public Project obtenirProjet(@PathVariable Long id) {
        return projectService.obtenirProjetParId(id);
    }

    @GetMapping
    public List<Project> obtenirTousLesProjets() {
        return projectService.obtenirTousLesProjets();
    }

    @GetMapping("/utilisateur/{id}")
    public List<Project> obtenirProjetsParUtilisateur(@PathVariable Long id) {
        return projectService.obtenirProjetsParCreateur(id);
    }

    @PutMapping("/{id}")
    public Project mettreAJourProjet(@PathVariable Long id, @RequestBody Project project) {
        return projectService.mettreAJourProjet(id, project);
    }

    @DeleteMapping("/{id}")
    public void supprimerProjet(@PathVariable Long id) {
        projectService.supprimerProjet(id);
    }
}
