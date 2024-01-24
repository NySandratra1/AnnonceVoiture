package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceFav;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceFavService {

    @Autowired
    AnnonceFavRepository annonceFavRepository;
    public List<AnnonceFav> getAllAnnonceFav() {
        return annonceFavRepository.findAll();
    }
    public Optional<AnnonceFav> getOneAnnonceFav(int id) {
        return annonceFavRepository.findById(id);
    }
    public void insertAnnonceFav(AnnonceFav an) {
        annonceFavRepository.save(an);
    }
    public void updateAnnonceFav(int id, AnnonceFav an){
        AnnonceFav existannonceFav=annonceFavRepository.findById(id).orElse(null);
        if(existannonceFav !=null)
        {
            existannonceFav.setIdAnnonce(an.getIdUser());
            existannonceFav.setIdAnnonce(an.getIdAnnonce());
            
        }
    }
    public void deleteAnnonceFav(int id){
        annonceFavRepository.deleteById(id);
    }
}