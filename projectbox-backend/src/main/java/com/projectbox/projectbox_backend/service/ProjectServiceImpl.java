package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Project;
import com.projectbox.projectbox_backend.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project creerProjet(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project obtenirProjetParId(Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project non trouvé avec ID : " + id));
    }

    @Override
    public List<Project> obtenirTousLesProjets() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> obtenirProjetsParCreateur(Long createurId) {
        return projectRepository.findByCreator_id(createurId);
    }

    @Override
    public Project mettreAJourProjet(Long id, Project projectModifie) {
        Project projectExistant = obtenirProjetParId(id);
        projectExistant.setTitle(projectModifie.getTitle());
        projectExistant.setDescription(projectModifie.getDescription());
        projectExistant.setStartDate(projectModifie.getStartDate());
        projectExistant.setEndDate(projectModifie.getEndDate());
        return projectRepository.save(projectExistant);
    }

    @Override
    public void supprimerProjet(Long id) {
        projectRepository.deleteById(id);
    }
}
