package mg.valian.tsiaro.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceAccepte;
import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceAccepteRepository;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceRepository;
import org.springframework.stereotype.Service;

@Service
public class AnnonceAccepteService {
    
    @Autowired
    AnnonceAccepteRepository annonceAccepteRepository;

    @Autowired
    AnnonceRepository annonceRepository;

    public void insertAnnonceAccepte(AnnonceAccepte a) {
        annonceAccepteRepository.save(a);
    }

    public void deleteAnnonce(Annonce a) {
        annonceRepository.delete(a);
    }
}
