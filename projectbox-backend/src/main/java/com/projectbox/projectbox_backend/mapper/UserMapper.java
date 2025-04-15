package com.projectbox.projectbox_backend.mapper;

import com.projectbox.projectbox_backend.dto.ProjectDTO;
import com.projectbox.projectbox_backend.dto.UserDTO;
import com.projectbox.projectbox_backend.model.Project;
import com.projectbox.projectbox_backend.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setNom(user.getNom());
        dto.setPrenom(user.getPrenom());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
