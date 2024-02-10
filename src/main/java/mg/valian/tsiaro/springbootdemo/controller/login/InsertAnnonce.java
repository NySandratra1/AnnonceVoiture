package mg.valian.tsiaro.springbootdemo.controller.login;

import mg.valian.tsiaro.springbootdemo.controller.UtilisateurController;
import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceFav;
import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.request.AnnonceRequest;
import mg.valian.tsiaro.springbootdemo.data.request.VoitureRequest;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import mg.valian.tsiaro.springbootdemo.service.AnnonceFavService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/annonce-login")
@CrossOrigin
public class InsertAnnonce {

    @Autowired
    AnnonceService annonceService;
    @Autowired
    AnnonceFavService annoncefavService;



    @PostMapping("/annonce")
    
    public void insertAnnonce(@RequestBody VoitureRequest voiture) {
        Voiture v = new Voiture();
        v.setIdCategorie(Integer.valueOf(voiture.getIdCategorie()));
        v.setIdEtat(Integer.valueOf(voiture.getIdEtat()));
        v.setIdMarque(Integer.valueOf(voiture.getIdMarque()));
        v.setIdMoteur(Integer.valueOf(voiture.getIdMoteur()));
        v.setIdVitesse(Integer.valueOf(voiture.getIdVitesse()));
        v.setPrix(Double.valueOf(voiture.getPrix()));
        v.setKilometrage(Double.valueOf(voiture.getKilometrage()));
        annonceService.insertAnnonce(v,voiture.getPhotoUrl());
    }

    @GetMapping("/annonce")
    public List<Annonce> getAnnonceUser() {
        return annonceService.getListeAnnoncesUser();
    }


    @GetMapping("/annoncefavuser")
    public List<Annonce> getAnnonceFavUser() {
        return annonceService.getAllAnnonceFav();
    }
    
    @PutMapping("/annonce")
    public void updateEtatAnnonce(@RequestBody AnnonceRequest a) {
        annonceService.updateAnnonce(a.getIdAnnonce());
    }

    
    @GetMapping("/annoncefav")

    public List<AnnonceFav> getAllAnnonceFav() {
        return annoncefavService.getAllAnnonceFav();
    }

    @PostMapping("/annoncefav")

    public void insertAnnonceFav(@RequestBody AnnonceRequest annonce) {
        AnnonceFav n = new AnnonceFav();
        n.setIdAnnonce(annonce.getIdAnnonce());
        annoncefavService.insertFavorie(n);
    }

    @GetMapping("/utilisateur")
    public Utilisateur getCurrentUser(){
        return annonceService.getCurrentUser();                      
    }
}