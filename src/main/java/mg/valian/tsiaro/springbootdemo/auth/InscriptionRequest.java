package mg.valian.tsiaro.springbootdemo.auth;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscriptionRequest {
    private String nomUtilisateur;
    private String mail;
    private String motDePasse;
    private Date dateDeNaissance;
}
