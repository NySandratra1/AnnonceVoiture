package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Utilisateur;
import mg.valian.tsiaro.springbootdemo.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    public List<Utilisateur> getAllUser() {
        return userRepository.findAll();
    }
    public Optional<Utilisateur> getOneUser(int id) {
        return userRepository.findById(id);
    }

    public Utilisateur getOneUserByMail(String mail) throws Exception{
        Utilisateur u = userRepository.findFirstByMail(mail);
        if(u==null) throw new Exception("mail non existant");
        return u;
    }

    public void insertUser(Utilisateur us) {
        userRepository.save(us);
    }

    public void updateUser(int id, Utilisateur us){
        Utilisateur existuser=userRepository.findById(id).orElse(null);
        if(existuser !=null)
        {
            existuser.setIdUser(us.getIdUser());
            
        }
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
