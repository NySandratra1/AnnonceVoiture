package mg.valian.tsiaro.springbootdemo.service;

import mg.valian.tsiaro.springbootdemo.data.entity.Messagerie;
import mg.valian.tsiaro.springbootdemo.data.repository.MessagerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessagerieService {

    @Autowired
    MessagerieRepository messagerieRepository;

    
}
