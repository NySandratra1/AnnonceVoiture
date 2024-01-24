package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Messagerie;
import mg.valian.tsiaro.springbootdemo.service.MessagerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagerieController {

    @Autowired
    MessagerieService messagerieService;

    @GetMapping("/messagerie")
    public List<Messagerie> getAllMessagerie(int e,int r) {
        return messagerieService.getAllMessagerie(e,r);
    }

    @PostMapping("/messagerie")
    public void insertMessagerie(@RequestBody Messagerie mq) {
        messagerieService.insertMessagerie(mq);
    }
}


