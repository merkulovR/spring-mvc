package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    private static List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car("Ford", "T", 20));
        cars.add(new Car("Toyota", "Celica", 200));
        cars.add(new Car("Fiat", "500", 100));
        cars.add(new Car("Mercedes", "S", 400));
        cars.add(new Car("Horse", "Bolivar", 1));
    }

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getSomeCars(Integer count) {
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
