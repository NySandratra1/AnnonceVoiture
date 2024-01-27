package mg.valian.tsiaro.springbootdemo.data.entity;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur implements UserDetails{

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
