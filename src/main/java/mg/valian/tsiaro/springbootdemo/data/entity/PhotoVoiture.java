package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoVoiture {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idPhotoVoiture;

    @ManyToOne
    @JoinColumn(name="idVoiture_Voiture")
    private Voiture voiture;

    @Column
    private String photo;


}
