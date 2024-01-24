package mg.valian.tsiaro.springbootdemo.controller;

import mg.valian.tsiaro.springbootdemo.data.entity.Car;
import mg.valian.tsiaro.springbootdemo.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarsService carsService;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carsService.getCars();
    }

    @PostMapping("/cars")
    public void saveCar(@RequestBody Car car) {
        carsService.saveCar(car);
    }
}
