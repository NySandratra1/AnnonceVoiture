package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceAccepte;
import mg.valian.tsiaro.springbootdemo.data.request.AnnonceRequest;

import mg.valian.tsiaro.springbootdemo.service.AnnonceAccepteService;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/annonce")
@CrossOrigin
public class AnnonceAccepteController {
    @Autowired
    AnnonceAccepteService annonceAccepteService;

    @Autowired
    AnnonceService annonceService;

    @PostMapping("/annonceaccepte")
    public void insertAnnonce(@RequestBody AnnonceRequest annonce) {
        AnnonceAccepte n = new AnnonceAccepte();
        n.setIdAnnonce(annonce.getIdAnnonce());
        annonceAccepteService.insertAnnonceAccepte(n);
    }

    @DeleteMapping("/annonceaccepte")
    public void deleteAnnonce(@RequestBody AnnonceRequest annonce) {
        Optional<Annonce> a = annonceService.getOneAnnonce(annonce.getIdAnnonce());
        annonceAccepteService.deleteAnnonce(a.get());
    }
}