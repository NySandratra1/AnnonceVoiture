package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Etat;
import mg.valian.tsiaro.springbootdemo.service.EtatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")

@CrossOrigin
public class EtatController {

    @Autowired
    EtatService etatService;

    @GetMapping("/etat")
    public List<Etat> getAllEtat() {
        return etatService.getAllEtat();
    }

    @PostMapping("/etat")
    public void insertEtat(@RequestBody Etat et) {
        etatService.insertEtat(et);
    }
}


