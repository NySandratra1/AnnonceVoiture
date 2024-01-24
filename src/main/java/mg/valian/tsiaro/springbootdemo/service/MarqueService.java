package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Marque;
import mg.valian.tsiaro.springbootdemo.data.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarqueService {

    @Autowired
    MarqueRepository marqueRepository;

    public List<Marque> getAllMarque() {
        return marqueRepository.findAll();
    }
    public Optional<Marque> getOneMarque(int id) {
        return marqueRepository.findById(id);
    }

    public void insertMarque(Marque mq) {
        marqueRepository.save(mq);
    }

    public void updateMarque(int id, Marque mq){
        Marque existmarque=marqueRepository.findById(id).orElse(null);
        if(existmarque !=null)
        {
            existmarque.setNomMarque(mq.getNomMarque());
            
        }
    }

    public void deleteMarque(int id){
        marqueRepository.deleteById(id);
    }
}
