package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.dto.UserDTO;
import com.projectbox.projectbox_backend.mapper.UserMapper;
import com.projectbox.projectbox_backend.model.User;
import com.projectbox.projectbox_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User ajouterUtilisateur(@RequestBody User utilisateur){
        return userService.ajouterUtilisateur(utilisateur);
    }

    @GetMapping("/{id}")
    public UserDTO obtenirUtilisateurParId(@PathVariable Long id){
        return UserMapper.toDTO(userService.obtenirUtilisateurParId(id));
    }

    @GetMapping
    public List<UserDTO> obtenirTousLesUtilisateurs() {
        return UserMapper.toDTOList(userService.obtenirTousLesUtilisateurs());
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> obtenirUtilisateurParEmail(@PathVariable String email) {
        return userService.obtenirUtilisateurParEmail(email)
                .map(user -> ResponseEntity.ok(UserMapper.toDTO(user)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public UserDTO mettreAJourUtilisateur(@PathVariable Long id, @RequestBody User user) {
        return UserMapper.toDTO(userService.mettreAJourUtilisateur(id, user));
    }

    @DeleteMapping("/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        userService.supprimerUtilisateur(id);
    }
}
