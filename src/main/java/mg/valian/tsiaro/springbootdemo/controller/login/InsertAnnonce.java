package mg.valian.tsiaro.springbootdemo.controller.login;

import mg.valian.tsiaro.springbootdemo.controller.UtilisateurController;
import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceFav;
import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.request.AnnonceRequest;
import mg.valian.tsiaro.springbootdemo.data.request.VoitureRequest;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import mg.valian.tsiaro.springbootdemo.service.ImageService;
import mg.valian.tsiaro.springbootdemo.service.AnnonceFavService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@RequestMapping("/annonce-login")
@CrossOrigin
public class InsertAnnonce {

    @Autowired
    AnnonceService annonceService;
    @Autowired
    AnnonceFavService annoncefavService;
    @Autowired
    ImageService imageService;


    @PostMapping("/annonce")
    
    public String insertAnnonce(@RequestParam("file") MultipartFile file,@RequestParam("voiture") String voiture) {
        String photoUrl = "";
        try{
            Voiture v = new Voiture();

            ObjectMapper mapper = new ObjectMapper();
            VoitureRequest voitu =  mapper.readValue(voiture, VoitureRequest.class);

            v.setIdCategorie(voitu.getIdCategorie());
            v.setIdEtat(voitu.getIdEtat());
            v.setIdMarque(voitu.getIdMarque());
            v.setIdMoteur(voitu.getIdMoteur());
            v.setIdVitesse(voitu.getIdVitesse());
            v.setPrix(Double.valueOf(voitu.getPrix()));
            v.setKilometrage(Double.valueOf(voitu.getKilometrage()));
            
            photoUrl = imageService.upload(file);
            

            annonceService.insertAnnonce(v, photoUrl);
            

        }
        catch(Exception e){
            e.printStackTrace();
        }
        return photoUrl;
            
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