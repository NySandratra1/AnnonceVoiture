package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Etat;
import mg.valian.tsiaro.springbootdemo.data.repository.EtatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatService {

    @Autowired
    EtatRepository etatRepository;

    public List<Etat> getAllEtat() {
        return etatRepository.findAll();
    }
    public Optional<Etat> getOneEtat(int id) {
        return etatRepository.findById(id);
    }

    public void insertEtat(Etat et) {
        etatRepository.save(et);
    }

    public void updateEtat(int id, Etat et){
        Etat existetat=etatRepository.findById(id).orElse(null);
        if(existetat !=null)
        {
            existetat.setNomEtat(et.getNomEtat());
            
        }
    }

    public void deleteEtat(int id){
        etatRepository.deleteById(id);
    }
}
