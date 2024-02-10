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
    String idCategorie; 
    String idEtat; 
    String idMarque; 
    String idMoteur ;
    String idVitesse;
    String photoUrl;
}
