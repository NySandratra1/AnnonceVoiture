package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Vitesse;
import mg.valian.tsiaro.springbootdemo.data.repository.VitesseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VitesseService {

    @Autowired
    VitesseRepository vitesseRepository;

    public List<Vitesse> getAllVitesse() {
        return vitesseRepository.findAll();
    }
    public Optional<Vitesse> getOneVitesse(int id) {
        return vitesseRepository.findById(id);
    }

    public void insertVitesse(Vitesse vit) {
        vitesseRepository.save(vit);
    }

    public void updateVitesse(int id, Vitesse vit){
        Vitesse existvitesse=vitesseRepository.findById(id).orElse(null);
        if(existvitesse !=null)
        {
            existvitesse.setNomVitesse(vit.getNomVitesse());
            
        }
    }

    public void deleteVitesse(int id){
        vitesseRepository.deleteById(id);
    }
}
