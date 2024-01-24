package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceFav {


    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idAnnonceFav;

    @ManyToOne
    @JoinColumn(name="idUser_User")
    private Utilisateur user;

    @ManyToOne
    @JoinColumn(name="idAnnonce_Annonce")
    private Annonce annonce;

    public Integer getIdUser() {
        return user != null ? user.getIdUser() : null;
    }


    public Integer getIdAnnonce() {
        return annonce != null ? annonce.getIdAnnonce() : null;
    }

    public void setIdAnnonce(int idAnnonce) {
        annonce.setIdAnnonce(idAnnonce);
    }
}
