package com.projectbox.projectbox_backend.mapper;

import com.projectbox.projectbox_backend.dto.ProjectDTO;
import com.projectbox.projectbox_backend.dto.TaskDTO;
import com.projectbox.projectbox_backend.model.Project;
import com.projectbox.projectbox_backend.model.Task;

import java.util.List;
import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskDTO toDTO(Task task){
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatut(task.getStatut());
        dto.setDueDate(task.getDueDate());
        dto.setProjectId(task.getProject().getId());
        dto.setAssigneeId(task.getAssignee() != null ? task.getAssignee().getId() : null);
        return dto;
    }

    public static List<TaskDTO> toDTOList(List<Task> tasks) {
        return tasks.stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }
}
