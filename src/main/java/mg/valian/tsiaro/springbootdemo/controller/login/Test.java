package mg.valian.tsiaro.springbootdemo.controller.login;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/annonce-login")
@CrossOrigin
@RequiredArgsConstructor
public class Test {
    @GetMapping
    public ResponseEntity<String> sayHello() {
        System.out.println("haha");
        return ResponseEntity.ok("Here is your resource");
    }
}