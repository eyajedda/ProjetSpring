package tn.esprit.firstspringproject.services;

import tn.esprit.firstspringproject.entities.Etudiant;
import tn.esprit.firstspringproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite retrieveUniversite (long idUniversite);

}
