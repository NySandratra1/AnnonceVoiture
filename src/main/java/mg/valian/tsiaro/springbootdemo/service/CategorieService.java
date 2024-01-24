package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Categorie;
import mg.valian.tsiaro.springbootdemo.data.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    CategorieRepository categorieRepository;

    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    }
    public Optional<Categorie> getOneCategorie(int id) {
        return categorieRepository.findById(id);
    }

    public void insertCategorie(Categorie cat) {
        categorieRepository.save(cat);
    }

    public void updateCategorie(int id, Categorie cat){
        Categorie existcategorie=categorieRepository.findById(id).orElse(null);
        if(existcategorie !=null)
        {
            existcategorie.setIdCategorie(cat.getIdCategorie());
            existcategorie.setNomCategorie(cat.getNomCategorie());
            
        }
    }

    public void deleteCategorie(int id){
        categorieRepository.deleteById(id);
    }
}
