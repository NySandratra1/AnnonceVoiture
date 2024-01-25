package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Marque;
import mg.valian.tsiaro.springbootdemo.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MarqueController {

    @Autowired
    MarqueService marqueService;

    @GetMapping("/marque")
    public List<Marque> getAllMarque() {
        return marqueService.getAllMarque();
    }

    @PostMapping("/marque")
    public void insertMarque(@RequestBody Marque mq) {
        marqueService.insertMarque(mq);
    }
}