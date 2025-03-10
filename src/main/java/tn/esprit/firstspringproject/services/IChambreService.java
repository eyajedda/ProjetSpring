package tn.esprit.firstspringproject.services;

import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.entities.TypeChambre;

import java.util.List;

public interface IChambreService {

    List<Chambre> retrieveAllChambres();
    Chambre addChambre(Chambre c);
    Chambre updateChambre (Chambre c);
    Chambre retrieveChambre (long idChambre);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, TypeChambre type);
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);
}
