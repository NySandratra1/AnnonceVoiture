package mg.valian.tsiaro.springbootdemo.data.util;

import mg.valian.tsiaro.springbootdemo.auth.InscriptionRequest;
import mg.valian.tsiaro.springbootdemo.auth.LoginRequest;
import mg.valian.tsiaro.springbootdemo.response.JwtResponse;

public interface AuthUtil {
    JwtResponse signup(InscriptionRequest request);

    JwtResponse signin(LoginRequest request);
    
    JwtResponse signinadmin(LoginRequest request);
}
