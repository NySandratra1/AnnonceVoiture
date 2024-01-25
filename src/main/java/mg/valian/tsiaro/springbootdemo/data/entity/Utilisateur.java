package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idUser;

    private String nomUtilisateur;
    
    private String motDePasse;

    private String mail;

    private Date dateDeNaissance;

    public Utilisateur(String nomUtilisateur,String motDePasse,String mail, Date dateDeNaissance){
        this.setNomUtilisateur(nomUtilisateur);
        this.setMotDePasse(motDePasse);
        this.setMail(mail);
        this.setDateDeNaissance(dateDeNaissance);
    }

}
