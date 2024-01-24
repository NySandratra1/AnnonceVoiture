package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Moteur {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private int idMoteur;

    @Column
    private String nomMoteur;


}
