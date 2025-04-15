package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.User;
import com.projectbox.projectbox_backend.model.UserRole;
import com.projectbox.projectbox_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository UserRepository;

    @Override
    public User ajouterUtilisateur(User utilisateur) {
        return UserRepository.save(utilisateur);
    }

    @Override
    public User obtenirUtilisateurParId(Long id) {
        return UserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("utilisateur non trouvé avec ID : " + id));
    }

    @Override
    public List<User> obtenirTousLesUtilisateurs() {
        return UserRepository.findAll();
    }

    @Override
    public Optional<User> obtenirUtilisateurParEmail(String email) {
        return UserRepository.findByEmail(email);
    }

    @Override
    public User mettreAJourUtilisateur(Long id, User utilisateurModifie) {
        User utilisateurExistant = obtenirUtilisateurParId(id);
        utilisateurExistant.setEmail(utilisateurModifie.getEmail());
        utilisateurExistant.setPrenom(utilisateurModifie.getPrenom());
        utilisateurExistant.setNom(utilisateurModifie.getNom());
        utilisateurExistant.setPassWord(utilisateurModifie.getPassWord());
        return UserRepository.save(utilisateurExistant);
    }

    @Override
    public void createAdmin() {
        var optional = UserRepository.findByRole(UserRole.ADMIN);
        if(!optional.isPresent()) {
            var user = new User();
            user.setNom("admin");
            user.setEmail("admin@gmail.com");
            user.setPassWord((new BCryptPasswordEncoder()).encode("0000"));
            user.setRole(UserRole.ADMIN);

            UserRepository.save(user);
        }
    }

    @Override
    public void supprimerUtilisateur(Long id) {
        UserRepository.deleteById(id);
    }
}
