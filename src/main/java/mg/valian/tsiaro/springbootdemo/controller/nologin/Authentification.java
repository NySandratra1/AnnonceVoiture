package mg.valian.tsiaro.springbootdemo.controller.nologin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mg.valian.tsiaro.springbootdemo.auth.InscriptionRequest;
import mg.valian.tsiaro.springbootdemo.auth.LoginRequest;
import mg.valian.tsiaro.springbootdemo.data.util.AuthUtil;
import mg.valian.tsiaro.springbootdemo.response.JwtResponse;

@RestController
@RequestMapping("/annonce")
@RequiredArgsConstructor
@CrossOrigin
public class Authentification {
    @Autowired
    private final AuthUtil authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtResponse> signup(@RequestBody InscriptionRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> signin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

    @PostMapping("/signinadmin")
    public ResponseEntity<JwtResponse> signinadmin(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authenticationService.signinadmin(request));
    }
}
