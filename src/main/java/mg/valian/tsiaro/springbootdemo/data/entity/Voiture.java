package mg.valian.tsiaro.springbootdemo.data.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voiture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idVoiture;

    @ManyToOne
    @JoinColumn(name="idMarque_Marque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name="idEtat_Etat")
    private Etat etat;

    @ManyToOne
    @JoinColumn(name="idCategorie_Categorie")
    private Categorie categorie;

    @Column
    private double prix;

    @Column
    private double kilometrage;

    @ManyToOne
    @JoinColumn(name="idVitesse_Vitesse")
    private Vitesse vitesse;

    @ManyToOne
    @JoinColumn(name="idMoteur_Moteur")
    private Moteur moteur;


    public int getIdVitesse(){
        return vitesse.getIdVitesse();
    }

    public int getIdMoteur(){
        return moteur.getIdMoteur();
    }

    public int getIdCategorie(){
        return categorie.getIdCategorie();
    }

    public void setIdVitesse(int idvitesse){
        vitesse.setIdVitesse(idvitesse);
    }

    public void setIdMoteur(int idmoteur){
        moteur.setIdMoteur(idmoteur);
    }

    public void setIdCategorie(int idcategorie){
        categorie.setIdCategorie(idcategorie);
    }

    public int getIdEtat(){
        return etat.getIdEtat();
    }

    public void setIdEtat(int idetat){
        etat.setIdEtat(idetat);
    }

    public int getIdMarque(){
        return marque.getIdMarque();
    }

    public void setIdMarque(int idmarque){
        marque.setIdMarque(idmarque);
    }
}
