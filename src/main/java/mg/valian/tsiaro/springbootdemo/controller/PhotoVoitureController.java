package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.PhotoVoiture;
import mg.valian.tsiaro.springbootdemo.service.PhotoVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/annonce")

@CrossOrigin
public class PhotoVoitureController {

    @Autowired
    PhotoVoitureService photoVoitureService;

    @GetMapping("/photoVoiture")
    public Optional<PhotoVoiture> getOnePhotoVoiture( int id) {
        return photoVoitureService.getOnePhotoVoiture(id);
    }

    @PostMapping("/photoVoiture")
    public void insertPhotoVoiture(@RequestBody PhotoVoiture mq) {
       photoVoitureService.insertPhotoVoiture(mq);
    }
}


