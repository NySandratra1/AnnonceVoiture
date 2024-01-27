package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.PhotoVoiture;
import mg.valian.tsiaro.springbootdemo.data.repository.PhotoVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotoVoitureService {

    @Autowired
    PhotoVoitureRepository photoVoitureRepository;

    public Optional<PhotoVoiture> getOnePhotoVoiture(int id) {
        return photoVoitureRepository.findById(id);
    }

    public void insertPhotoVoiture(PhotoVoiture mot) {
        photoVoitureRepository.save(mot);
    }

    public void updatePhotoVoiture(int id, PhotoVoiture mot){
        PhotoVoiture existPhotoVoiture=photoVoitureRepository.findById(id).orElse(null);
        if(existPhotoVoiture !=null)
        {
            existPhotoVoiture.setPhoto(mot.getPhoto());
            
        }
    }

    public void deletePhotoVoiture(int id){
        photoVoitureRepository.deleteById(id);
    }
}
