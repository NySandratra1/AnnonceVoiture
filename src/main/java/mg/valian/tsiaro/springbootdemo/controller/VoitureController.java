package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import mg.valian.tsiaro.springbootdemo.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class VoitureController {

    @Autowired
    VoitureService voitureService;

    @GetMapping("/voiture")
    public List<Voiture> getAllVoiture() {
        return voitureService.getAllVoiture();
    }

    @PostMapping("/voiture")
    public void insertVoiture(@RequestBody Voiture mq) {
       voitureService.insertVoiture(mq);
    }
}


