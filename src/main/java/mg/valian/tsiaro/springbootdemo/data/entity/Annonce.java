package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idAnnonce;

    @ManyToOne
    @JoinColumn(name = "idVoiture")
    private Voiture voiture; 

    @Column
    private Date dateAnnonce;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Utilisateur user; 

    @Column
    private int EtatAnnonce;

    @Column(name = "photo_url")
    private String photoUrl;

    @PrePersist
    protected void onCreate() {
        dateAnnonce = new Date(System.currentTimeMillis());
    }
}
