package com.projectbox.projectbox_backend.service;

import com.projectbox.projectbox_backend.model.StatutTache;
import com.projectbox.projectbox_backend.model.Tache;
import com.projectbox.projectbox_backend.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacheServiceImpl implements TacheService {
    @Autowired
    private TacheRepository tacheRepository;

    @Override
    public Tache creerTache(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public Tache obtenirTacheParId(Long id) {
        return tacheRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("tache non trouvé avec ID : " + id));
    }

    @Override
    public List<Tache> obtenirToutesLesTaches() {
        return tacheRepository.findAll();
    }

    @Override
    public List<Tache> obtenirTacheParSatut(StatutTache statut) {
        return tacheRepository.findByStatut(statut);
    }

    @Override
    public List<Tache> obtenirTacheParProjet(Long projetId) {
        return tacheRepository.findByProjetId(projetId);
    }

    @Override
    public Tache mettreAJourTache(Long id, Tache tacheModifie) {
        Tache tacheExistant = obtenirTacheParId(id);
        tacheExistant.setTitre(tacheModifie.getTitre());
        tacheExistant.setDescription(tacheModifie.getDescription());
        tacheExistant.setDateEcheance(tacheModifie.getDateEcheance());
        tacheExistant.setStatut(tacheModifie.getStatut());
        return tacheRepository.save(tacheExistant);
    }

    @Override
    public void supprimerTache(Long id) {
        tacheRepository.deleteById(id);
    }
}
