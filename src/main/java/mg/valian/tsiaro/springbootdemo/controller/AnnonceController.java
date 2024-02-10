package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.data.request.VoitureRequest;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/annonce")
@CrossOrigin
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;

    @GetMapping("/annonce")
    public List<Annonce> getAllAnnonce() {
        return annonceService.getAllAnnonce();
    }

    @PostMapping("/annonce")
    public void insertAnnonce(@RequestBody VoitureRequest voiture) {
        Voiture v = new Voiture();
        v.setIdCategorie(voiture.getIdCategorie());
        v.setIdEtat(voiture.getIdEtat());
        v.setIdMarque(voiture.getIdMarque());
        v.setIdMoteur(voiture.getIdMoteur());
        v.setIdVitesse(voiture.getIdVitesse());
        
        annonceService.insertAnnonce(v,voiture.getPhotoUrl());
    }

    @GetMapping("/annonceadmin")
    public List<Annonce> getAllAnnonceNonAccepte() {
        return annonceService.getAllAnnonceNonAccepte();
    }

    @GetMapping("/annonceall")
    public List<Annonce> getAllAnnonceAccepte() {
        return annonceService.getAllAnnonceAccepte();
    }
}
