package com.projectbox.projectbox_backend.mapper;

import com.projectbox.projectbox_backend.dto.ProjectDTO;
import com.projectbox.projectbox_backend.model.Project;
import com.projectbox.projectbox_backend.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {
    public static ProjectDTO toDTO(Project projet) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(projet.getId());
        dto.setTitle(projet.getTitle());
        dto.setDescription(projet.getDescription());
        dto.setStartDate(projet.getStartDate());
        dto.setEndDate(projet.getEndDate());
        dto.setCreatorId(projet.getCreator() != null ? projet.getCreator().getId() : null);
        dto.setTasksId(projet.getTasks().stream()
                .map(Task::getId)
                .collect(Collectors.toList()));
        return dto;
    }

    public static List<ProjectDTO> toDTOList(List<Project> projects) {
        return projects.stream()
                .map(ProjectMapper::toDTO)
                .collect(Collectors.toList());
    }
}
