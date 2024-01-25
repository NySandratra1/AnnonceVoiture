package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {

    @Autowired
    UserService userService;

    @GetMapping("/utilisateur")
    public List<Utilisateur> getAllUser() {
        return userService.getAllUser();
    }

    @PostMapping("/utilisateur")
    public void insertUser(@RequestBody Utilisateur mq) {
       userService.insertUser(mq);
    }
}


