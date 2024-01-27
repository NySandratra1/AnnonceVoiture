package mg.valian.tsiaro.springbootdemo.data.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mg.valian.tsiaro.springbootdemo.data.repository.UserRepository;
import mg.valian.tsiaro.springbootdemo.data.util.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService{
    @Autowired
    private final UserRepository userRepository;
    
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByMail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
