package mg.valian.tsiaro.springbootdemo.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mg.valian.tsiaro.springbootdemo.data.entity.AnnonceAccepte;

@Repository
public interface AnnonceAccepteRepository extends JpaRepository<AnnonceAccepte,Integer>{
    
}
