package mg.valian.tsiaro.springbootdemo.data.repository;

import mg.valian.tsiaro.springbootdemo.data.entity.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture, Integer> {

}
