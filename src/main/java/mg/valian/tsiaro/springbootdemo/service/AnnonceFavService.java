package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceFav;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceFavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


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

    private Utilisateur getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Utilisateur) authentication.getPrincipal();
    }

    public void insertFavorie(AnnonceFav a) {
        a.setUser(getCurrentUser());
        annonceFavRepository.save(a);
    }

    public void deleteAnnonceFav(int id){
        annonceFavRepository.deleteById(id);
    }
}