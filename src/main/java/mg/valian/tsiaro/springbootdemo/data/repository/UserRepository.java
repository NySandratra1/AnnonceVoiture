package mg.valian.tsiaro.springbootdemo.data.repository;



import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

}