package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Moteur;
import mg.valian.tsiaro.springbootdemo.service.MoteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MoteurController {

    @Autowired
    MoteurService moteurService;

    @GetMapping("/moteur")
    public List<Moteur> getAllMoteur() {
        return moteurService.getAllMoteur();
    }

    @PostMapping("/moteur")
    public void insertMoteur(@RequestBody Moteur mq) {
       moteurService.insertMoteur(mq);
    }
}


