package mg.valian.tsiaro.springbootdemo.data.repository;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
/* */
@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Annonce a SET a.EtatAnnonce = 1 WHERE a.idAnnonce = :idAnnonce")
    void updateEtatAnnonceByIdAnnonce(int idAnnonce);

    @Query("SELECT a FROM Annonce a WHERE a NOT IN (SELECT aa.annonce FROM AnnonceAccepte aa)")
    List<Annonce> findAllNotInAnnonceAccepte();

    @Query("SELECT a FROM Annonce a WHERE a IN (SELECT aa.annonce FROM AnnonceAccepte aa)")
    List<Annonce> findAllInAnnonceAccepte();

    @Query("SELECT a FROM Annonce a WHERE a IN (SELECT aa.annonce FROM AnnonceFav aa)")
    List<Annonce> findAllInAnnonceFav();


    List<Annonce> findByUser(Utilisateur utilisateur);
}
