package mg.valian.tsiaro.springbootdemo.data.implementation;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mg.valian.tsiaro.springbootdemo.auth.LoginRequest;
import mg.valian.tsiaro.springbootdemo.auth.InscriptionRequest;
import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.repository.UserRepository;
import mg.valian.tsiaro.springbootdemo.data.util.AuthUtil;
import mg.valian.tsiaro.springbootdemo.data.util.JwtUtil;
import mg.valian.tsiaro.springbootdemo.response.JwtResponse;

@Service
@RequiredArgsConstructor
public class AuthImplementation implements AuthUtil {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtService;
    private final AuthenticationManager authenticationManager;
   
    @Override
    public JwtResponse signup(InscriptionRequest request) {
        var user = Utilisateur.builder().nomUtilisateur(request.getNomUtilisateur()).mail(request.getMail())
                .dateDeNaissance(request.getDateDeNaissance()).motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }

    @Override
    public JwtResponse signin(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getMail(), request.getMotDePasse()));
        var user = userRepository.findByMail(request.getMail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }

    @Override
    public JwtResponse signinadmin(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getMail(), request.getMotDePasse()));
        var user = userRepository.findByMail(request.getMail())
                .orElseThrow(() -> new IllegalArgumentException("Not authorized"));
        if (!"admin".equals(user.getMail())) {
            throw new IllegalArgumentException("User is not authorized");
        }
        var jwt = jwtService.generateToken(user);
        return JwtResponse.builder().token(jwt).build();
    }
}
