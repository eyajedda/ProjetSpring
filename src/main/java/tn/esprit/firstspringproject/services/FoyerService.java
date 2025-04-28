package tn.esprit.firstspringproject.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstspringproject.entities.Foyer;
import tn.esprit.firstspringproject.entities.Universite;
import tn.esprit.firstspringproject.repositories.IFoyerRepository;
import tn.esprit.firstspringproject.repositories.IUniversiteRepository;

import java.util.List;
@Service
public class FoyerService implements IFoyerService{
    @Autowired
    IFoyerRepository foyerRepository;
    @Autowired
    IUniversiteRepository universiteRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }


    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        foyer = foyerRepository.save(foyer);
        universite.setFoyer(foyer);

        // université est le bout master , donc c'est lui qui va agir
        return foyer;
    }
}
