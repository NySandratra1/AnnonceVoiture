package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Messagerie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private int idMessagerie;

    @ManyToOne
    @JoinColumn(name = "envoyeur_id_user")
    private Utilisateur envoyeur;

    @ManyToOne
    @JoinColumn(name = "recepteur_id_user")
    private Utilisateur recepteur;

    @Column
    private Date dateMessage;

    @Column
    private String message;


}
