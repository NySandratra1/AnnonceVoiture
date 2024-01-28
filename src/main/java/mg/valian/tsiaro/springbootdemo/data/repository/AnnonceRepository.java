package mg.valian.tsiaro.springbootdemo.data.repository;

import mg.valian.tsiaro.springbootdemo.data.entity.Annonce;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Annonce a SET a.EtatAnnonce = 1 WHERE a.idAnnonce = :idAnnonce")
    void updateEtatAnnonceByIdAnnonce(int idAnnonce);
    
    List<Annonce> findByUser(Utilisateur utilisateur);
}
