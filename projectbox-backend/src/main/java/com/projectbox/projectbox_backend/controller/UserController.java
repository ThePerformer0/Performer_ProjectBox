package com.projectbox.projectbox_backend.controller;

import com.projectbox.projectbox_backend.model.User;
import com.projectbox.projectbox_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public User obtenirUtilisateurParId(@PathVariable Long id){
        return userService.obtenirUtilisateurParId(id);
    }

    @GetMapping
    public List<User> obtenirTousLesUtilisateurs() {
        return userService.obtenirTousLesUtilisateurs();
    }

    @GetMapping("/utilisateur/{email}")
    public Optional<User> obtenirUtilisateurParEmail(@PathVariable String email) {
        return userService.obtenirUtilisateurParEmail(email);
    }

    @PutMapping("/{id}")
    public User mettreAJourUtilisateur(@PathVariable Long id, @RequestBody User utilisateur) {
        return userService.mettreAJourUtilisateur(id, utilisateur);
    }

    @DeleteMapping("/{id}")
    public void supprimerUtilisateur(@PathVariable Long id) {
        userService.supprimerUtilisateur(id);
    }
}
