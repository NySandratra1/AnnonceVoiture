package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {

    @Autowired
    VoitureRepository voitureRepository;

    public List<Voiture> getAllVoiture() {
        return voitureRepository.findAll();
    }
    public Optional<Voiture> getOneVoiture(int id) {
        return voitureRepository.findById(id);
    }

    public void insertVoiture(Voiture car) {
        voitureRepository.save(car);
    }

    public void updateVoiture(int id, Voiture car){
        Voiture existVoiture=voitureRepository.findById(id).orElse(null);
        if(existVoiture !=null)
        {
            existVoiture.setIdMarque(car.getIdMarque());
            existVoiture.setIdEtat(car.getIdEtat());
            existVoiture.setIdCategorie(car.getIdCategorie());
            existVoiture.setPrix(car.getPrix());
            existVoiture.setKilometrage(car.getKilometrage());
            existVoiture.setIdVitesse(car.getIdVitesse());
            existVoiture.setIdMoteur(car.getIdMoteur());
        }
    }

    public void deleteVoiture(int id){
        voitureRepository.deleteById(id);
    }
}
