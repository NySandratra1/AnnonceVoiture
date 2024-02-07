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
@CrossOrigin("*")
public class InsertAnnonce {

    @Autowired
    AnnonceService annonceService;
    @Autowired
    AnnonceFavService annoncefavService;



    @PostMapping("/annonce")
    @CrossOrigin("*")
    public void insertAnnonce(@RequestBody VoitureRequest voiture) {
        Voiture v = new Voiture();
        v.setIdCategorie(voiture.getIdCategorie());
        v.setIdEtat(voiture.getIdEtat());
        v.setIdMarque(voiture.getIdMarque());
        v.setIdMoteur(voiture.getIdMarque());
        v.setIdVitesse(voiture.getIdVitesse());
        v.setPrix(voiture.getPrix());
        v.setKilometrage(voiture.getKilometrage());
        System.out.println("huhu");
        annonceService.insertAnnonce(v);
    }

    @GetMapping("/annonce")
    @CrossOrigin("*")
    public List<Annonce> getAnnonceUser() {
        return annonceService.getListeAnnoncesUser();
    }


    @GetMapping("/annoncefavuser")
    @CrossOrigin("*")

    public List<Annonce> getAnnonceFavUser() {
        return annonceService.getAllAnnonceFav();
    }
    
    @PutMapping("/annonce")
    @CrossOrigin("*")

    public void updateEtatAnnonce(@RequestBody AnnonceRequest a) {
        annonceService.updateAnnonce(a.getIdAnnonce());
    }

    
    @GetMapping("/annoncefav")
    @CrossOrigin("*")

    public List<AnnonceFav> getAllAnnonceFav() {
        return annoncefavService.getAllAnnonceFav();
    }

    @PostMapping("/annoncefav")
    @CrossOrigin("*")

    public void insertAnnonceFav(@RequestBody AnnonceRequest annonce) {
        AnnonceFav n = new AnnonceFav();

        n.setIdAnnonce(annonce.getIdAnnonce());
        annoncefavService.insertFavorie(n);
    }

    @GetMapping("/utilisateur")
    @CrossOrigin("*")
    public Utilisateur getCurrentUser(){
        return annonceService.getCurrentUser();                      
    }
}