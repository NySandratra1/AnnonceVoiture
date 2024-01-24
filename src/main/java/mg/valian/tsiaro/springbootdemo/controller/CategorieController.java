package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Categorie;
import mg.valian.tsiaro.springbootdemo.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategorieController {

    @Autowired
    CategorieService categorieService;

    @GetMapping("/categorie")
    public List<Categorie> getAllCategorie() {
        return categorieService.getAllCategorie();
    }

    @PostMapping("/categorie")
    public void insertCategorie(@RequestBody Categorie categorie) {
        categorieService.insertCategorie(categorie);
    }
}


