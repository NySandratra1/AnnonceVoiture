package mg.valian.tsiaro.springbootdemo.data.entity;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    @ManyToOne
    @JoinColumn(name="idMarque")
    private Marque marque = new Marque();

    @Autowired
    @ManyToOne
    @JoinColumn(name="idEtat")
    private Etat etat = new Etat();

    @Autowired
    @ManyToOne
    @JoinColumn(name="idCategorie")
    private Categorie categorie = new Categorie();

    @Column
    private double prix;

    @Column
    private double kilometrage;

    @Autowired
    @ManyToOne
    @JoinColumn(name="idVitesse")
    private Vitesse vitesse = new Vitesse();

    @Autowired
    @ManyToOne
    @JoinColumn(name="idMoteur")
    private Moteur moteur = new Moteur();


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
