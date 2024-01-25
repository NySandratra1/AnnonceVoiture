package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceFav;
import mg.valian.tsiaro.springbootdemo.service.AnnonceFavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class AnnonceFavController {

    @Autowired
    AnnonceFavService annoncefavService;

    @GetMapping("/annoncefav")
    public List<AnnonceFav> getAllAnnonceFav() {
        return annoncefavService.getAllAnnonceFav();
    }

    @PostMapping("/annoncefav")
    public void insertAnnonceFav(@RequestBody AnnonceFav annoncefav) {
        annoncefavService.insertAnnonceFav(annoncefav);
    }
}
