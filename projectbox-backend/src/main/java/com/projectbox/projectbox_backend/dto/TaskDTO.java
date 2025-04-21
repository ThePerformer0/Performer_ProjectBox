package com.projectbox.projectbox_backend.dto;

import com.projectbox.projectbox_backend.model.Statut;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private Statut statut;
    private LocalDate dueDate;
    private Long projectId;
    private Long assigneeId;
}
