package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;

    @GetMapping("/annonce")
    public List<Annonce> getgetAllAnnonce() {
        return annonceService.getAllAnnonce();
    }

    @PostMapping("/annonce")
    public void insertAnnonce(@RequestBody Annonce annonce) {
        annonceService.insertAnnonce(annonce);
    }
}
