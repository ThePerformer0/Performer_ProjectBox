package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.Statut;
import com.projectbox.projectbox_backend.model.Task;
import com.projectbox.projectbox_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task creerTache(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task obtenirTacheParId(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("tache non trouvé avec ID : " + id));
    }

    @Override
    public List<Task> obtenirToutesLesTaches() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> obtenirTacheParSatut(Statut statut) {
        return taskRepository.findByStatut(statut);
    }

    @Override
    public List<Task> obtenirTacheParProjet(Long projetId) {
        return taskRepository.findByProject_id(projetId);
    }

    @Override
    public Task mettreAJourTache(Long id, Task taskModifie) {
        Task taskExistant = obtenirTacheParId(id);
        taskExistant.setTitle(taskModifie.getTitle());
        taskExistant.setDescription(taskModifie.getDescription());
        taskExistant.setDueDate(taskModifie.getDueDate());
        taskExistant.setStatut(taskModifie.getStatut());
        return taskRepository.save(taskExistant);
    }

    @Override
    public void supprimerTache(Long id) {
        taskRepository.deleteById(id);
    }
}
