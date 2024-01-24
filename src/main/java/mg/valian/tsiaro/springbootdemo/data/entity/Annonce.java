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
    private Voiture voiture; // Assuming you have a Voiture entity

    @Column
    private Date dateAnnonce;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Utilisateur user; // Assuming you have a User entity

    @Column
    private int EtatAnnonce;

}
