package com.projectbox.projectbox_backend.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserRole {

    CHEF("CHEF"),
    EQUIPIER("EQUIPIER"),
    ADMIN("ADMIN");

    private String label;

    UserRole(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    public static UserRole fromValeur(String value) {
        switch (value) {
            case "CHEF":
                return UserRole.CHEF;
            case "EQUIPIER":
                return UserRole.EQUIPIER;
            case "ADMIN":
                return UserRole.ADMIN;
            default:
                return null;
        }
    }
}