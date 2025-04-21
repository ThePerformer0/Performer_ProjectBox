package com.projectbox.projectbox_backend.dto;

import com.projectbox.projectbox_backend.model.UserRole;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private UserRole role;

}
