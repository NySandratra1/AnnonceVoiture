package mg.valian.tsiaro.springbootdemo.service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class UtilisateurDescription implements UserDetails {

    private String nom;
    private String mail;
    private String motDePasse;

    // Constructor
    public UtilisateurDescription(String nom, String mail, String motDepasse) {
        this.nom = nom;
        this.mail = mail;
        this.motDePasse = motDepasse;
    }

    // Getters

    public String getNom() {
        return nom;
    }

    public String getMail() {
        return mail;
    }

    // UserDetails methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // You can return authorities if needed
        return null;
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
        // You can implement custom logic for account expiration
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // You can implement custom logic for account locking
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // You can implement custom logic for credential expiration
        return true;
    }

    @Override
    public boolean isEnabled() {
        // You can implement custom logic for account enabling/disabling
        return true;
    }
}

