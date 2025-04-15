package com.projectbox.projectbox_backend.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Statut {
    TODO("TODO"),
    DOING("DOING"),
    DONE("DONE");

    private String label;

    Statut(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    public static Statut fromValue(String value){
        switch (value) {
            case "TODO":
                return Statut.TODO;
            case "DOING":
                return Statut.DOING;
            case "DONE":
                return Statut.DONE;
            default:
                return null;
        }
    }
}
