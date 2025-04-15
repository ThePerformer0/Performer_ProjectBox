package com.projectbox.projectbox_backend.dto;

import com.projectbox.projectbox_backend.model.Statut;

import java.time.LocalDate;

public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private Statut statut;
    private LocalDate dueDate;
    private Long projectId;
    private Long assigneeId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Statut getStatut() {
        return statut;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Long getProjectId() {
        return projectId;
    }

    public Long getAssigneeId() {
        return assigneeId;
    }
}
