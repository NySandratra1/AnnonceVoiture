package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;

    public List<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }
    public Optional<Annonce> getOneAnnonce(int id) {
        return annonceRepository.findById(id);
    }

    public void insertAnnonce(Annonce an) {
        annonceRepository.save(an);
    }

    public void updateAnnonce(int id, int etat){
        Annonce existannonce=annonceRepository.findById(id).orElse(null);
        if(existannonce !=null)
        {
            existannonce.setEtatAnnonce(etat);
            
        }
    }

    public void deleteAnnonce(int id){
        annonceRepository.deleteById(id);
    }
}
