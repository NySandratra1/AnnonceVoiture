package mg.valian.tsiaro.springbootdemo.controller.login;


import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.request.VoitureRequest;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/annonce-login")
@CrossOrigin
public class InsertAnnonce {

    @Autowired
    AnnonceService annonceService;


    
    @PostMapping("/annonce")
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
}

