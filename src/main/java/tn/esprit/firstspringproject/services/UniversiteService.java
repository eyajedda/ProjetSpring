package tn.esprit.firstspringproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Foyer;
import tn.esprit.firstspringproject.entities.Universite;
import tn.esprit.firstspringproject.repositories.IFoyerRepository;
import tn.esprit.firstspringproject.repositories.IUniversiteRepository;

import java.util.List;

@Service
public class UniversiteService implements IUniversiteService{
    @Autowired
    IUniversiteRepository universiteRepository;
    @Autowired
    IFoyerRepository foyerRepository;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return (List<Universite>) universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite retrieveUniversite(long idUniversite) {
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    @Override
    public Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite){

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        universite.setFoyer(foyer);
        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite (long idUniversite){
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(null);
        return universiteRepository.save(universite);
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        foyer = foyerRepository.save(foyer);
        universite.setFoyer(foyer);

        return foyerRepository.save(foyer);
    }


}
