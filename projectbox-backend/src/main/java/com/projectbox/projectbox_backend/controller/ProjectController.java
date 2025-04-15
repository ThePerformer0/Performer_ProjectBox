package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.dto.ProjectDTO;
import com.projectbox.projectbox_backend.mapper.ProjectMapper;
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
        System.out.println("Hello");
        return projectService.creerProjet(project);
    }

    @GetMapping("/{id}")
    public ProjectDTO obtenirProjet(@PathVariable Long id) {
        return ProjectMapper.toDTO(projectService.obtenirProjetParId(id));
    }

    @GetMapping
    public List<ProjectDTO> obtenirTousLesProjets() { ;
        return ProjectMapper.toDTOList(projectService.obtenirTousLesProjets());
    }

    @GetMapping("/user/{id}")
    public List<ProjectDTO> obtenirProjetsParUtilisateur(@PathVariable Long id) {
        return ProjectMapper.toDTOList(projectService.obtenirProjetsParCreateur(id));
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
