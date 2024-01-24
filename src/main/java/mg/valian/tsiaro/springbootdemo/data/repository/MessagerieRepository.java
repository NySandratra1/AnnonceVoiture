package mg.valian.tsiaro.springbootdemo.data.repository;
import mg.valian.tsiaro.springbootdemo.data.entity.Messagerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagerieRepository extends JpaRepository<Messagerie, Integer> {

        @Query(value="SELECT * FROM Messagerie WHERE envoyeur = :envoyeur AND recepteur = :recepteur", nativeQuery = true)
        List<Messagerie> findmessage(@Param("envoyeur") int envoyeur, @Param("recepteur") int recepteur );
}
