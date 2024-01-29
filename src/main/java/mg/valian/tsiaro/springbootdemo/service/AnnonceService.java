package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.repository.AnnonceRepository;
import mg.valian.tsiaro.springbootdemo.data.repository.UserRepository;
import mg.valian.tsiaro.springbootdemo.data.repository.VoitureRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;
    
    
    @Autowired
    VoitureRepository voitureRepository;
    
    @Autowired
    UserRepository userRepository;

    public List<Annonce> getAllAnnonce() {
        return annonceRepository.findAll();
    }
    public Optional<Annonce> getOneAnnonce(int id) {
        return annonceRepository.findById(id);
    }

    public void insertAnnonce(Voiture voiture) {
        Voiture savedVoiture = voitureRepository.save(voiture);
        Annonce an = new Annonce();
        an.setDateAnnonce(Date.valueOf(LocalDate.now()));
        Utilisateur user = getCurrentUser();
        an.setUser(user);
        an.setVoiture(savedVoiture);
        an.setEtatAnnonce(0);
        annonceRepository.save(an);
    }

    public List<Annonce> getAllAnnonceNonAccepte(){
        return annonceRepository.findAllNotInAnnonceAccepte();      
    }


    public List<Annonce> getAllAnnonceFav(){
        return annonceRepository.findAllInAnnonceFav();      
    }
    
    public List<Annonce> getAllAnnonceAccepte(){
        return annonceRepository.findAllInAnnonceAccepte();      
    }

    public void updateAnnonce(int id){
        annonceRepository.updateEtatAnnonceByIdAnnonce(id);
    }

    public List<Annonce> getListeAnnoncesUser(){
        return annonceRepository.findByUser(getCurrentUser());
    }

    private Utilisateur getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Utilisateur) authentication.getPrincipal();
    }

    public void deleteAnnonce(int id){
        annonceRepository.deleteById(id);
    }
}
