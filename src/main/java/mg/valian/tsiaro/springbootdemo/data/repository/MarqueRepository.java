package mg.valian.tsiaro.springbootdemo.data.repository;

import mg.valian.tsiaro.springbootdemo.data.entity.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Integer> {

}
