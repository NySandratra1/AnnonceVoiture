package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.PhotoVoiture;
import mg.valian.tsiaro.springbootdemo.service.PhotoVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
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


