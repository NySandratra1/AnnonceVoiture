package mg.valian.tsiaro.springbootdemo.data.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VoitureRequest {
    String kilometrage ;
    String prix ;
    int idCategorie; 
    int idEtat; 
    int idMarque; 
    int idMoteur ;
    int idVitesse;
    int photoUrl;
}
