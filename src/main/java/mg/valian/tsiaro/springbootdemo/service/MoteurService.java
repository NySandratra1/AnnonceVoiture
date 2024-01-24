package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Moteur;
import mg.valian.tsiaro.springbootdemo.data.repository.MoteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoteurService {

    @Autowired
    MoteurRepository moteurRepository;

    public List<Moteur> getAllMoteur() {
        return moteurRepository.findAll();
    }
    public Optional<Moteur> getOneMoteur(int id) {
        return moteurRepository.findById(id);
    }

    public void insertMoteur(Moteur mot) {
        moteurRepository.save(mot);
    }

    public void updateMoteur(int id, Moteur mot){
        Moteur existmoteur=moteurRepository.findById(id).orElse(null);
        if(existmoteur !=null)
        {
            existmoteur.setNomMoteur(mot.getNomMoteur());
            
        }
    }

    public void deleteMoteur(int id){
        moteurRepository.deleteById(id);
    }
}
