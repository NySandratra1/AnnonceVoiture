package mg.valian.tsiaro.springbootdemo.data.repository;

import mg.valian.tsiaro.springbootdemo.data.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
