package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Vitesse;
import mg.valian.tsiaro.springbootdemo.service.VitesseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")

@CrossOrigin
public class VitesseController {

    @Autowired
    VitesseService vitesseService;

    @GetMapping("/vitesse")
    public List<Vitesse> getAllVitesse() {
        return vitesseService.getAllVitesse();
    }

    @PostMapping("/vitesse")
    public void insertVitesse(@RequestBody Vitesse mq) {
       vitesseService.insertVitesse(mq);
    }
}


