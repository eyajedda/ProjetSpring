package tn.esprit.firstspringproject.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstspringproject.entities.Bloc;
import tn.esprit.firstspringproject.entities.Chambre;
import tn.esprit.firstspringproject.repositories.IBlocRepository;
import tn.esprit.firstspringproject.repositories.IChambreRepository;

import java.util.List;

@Service
@Slf4j
public class BlocService implements IBlocService {
    @Autowired
    IBlocRepository blocRepository;
    @Autowired
    IChambreRepository chambreRepository;

    @Override
    //@Scheduled(fixedRate = 60000)
    public List<Bloc> retrieveBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc retrieveBloc(long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(long idBloc) {
        blocRepository.deleteById(idBloc);

    }


    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        List<Chambre> chambres = (List<Chambre>) chambreRepository.findAllByIdChambreIn(numChambres);

        for (Chambre chambre : chambres) {
            log.info (String.valueOf(chambre.getIdChambre()));
            chambre.setBloc(bloc);
        }

        chambreRepository.saveAll(chambres);
        return bloc;
    }
}
