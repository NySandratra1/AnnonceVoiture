package mg.valian.tsiaro.springbootdemo.data.util;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    UserDetailsService userDetailsService();
}
