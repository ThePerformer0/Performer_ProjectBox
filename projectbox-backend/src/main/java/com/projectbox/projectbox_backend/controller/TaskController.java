package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.dto.TaskDTO;
import com.projectbox.projectbox_backend.mapper.TaskMapper;
import com.projectbox.projectbox_backend.model.Statut;
import com.projectbox.projectbox_backend.model.Task;
import com.projectbox.projectbox_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task creerTache(@RequestBody Task task){
        return taskService.creerTache(task);
    }

    @GetMapping("/{id}")
    public TaskDTO obtenirTache(@PathVariable Long id){
        return TaskMapper.toDTO(taskService.obtenirTacheParId(id));
    }

    @GetMapping
    public List<TaskDTO> obtenirToutesLesTaches() {
        return TaskMapper.toDTOList(taskService.obtenirToutesLesTaches());
    }

    @GetMapping("/{statut}")
    public List<TaskDTO> obtenirTacheParSatut(@PathVariable Statut statut) {
        return TaskMapper.toDTOList(taskService.obtenirTacheParSatut(statut));
    }

    @GetMapping("/project/{projectId}")
    public List<TaskDTO> obtenirTacheParProjet(@PathVariable Long projectId) {
        return TaskMapper.toDTOList(taskService.obtenirTacheParProjet(projectId));
    }

    @PutMapping("/{id}")
    public Task mettreAJourTache(@PathVariable Long id, @RequestBody Task task) {
        return taskService.mettreAJourTache(id, task);
    }

    @DeleteMapping("/{id}")
    public void supprimerTache(@PathVariable Long id) {
        taskService.supprimerTache(id);
    }
}
