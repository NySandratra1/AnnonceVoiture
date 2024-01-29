package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AnnonceAccepte {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idAnnonceAccepte;

    @ManyToOne
    @JoinColumn(name = "idAnnonce")
    private Annonce annonce = new Annonce();

    public void setIdAnnonce(int idAnnonce){
        this.getAnnonce().setIdAnnonce(idAnnonce);
    }

    public int getIdAnnonce(){
        return this.getAnnonce().getIdAnnonce();
    }
}
