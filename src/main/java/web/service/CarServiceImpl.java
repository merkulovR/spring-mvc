package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao = new CarDaoImpl();

    @Override
    public List<Car> getAllCars() {
        return carDao.getAllCars();
    }

    @Override
    public List<Car> getSomeCars(Integer count) {
        return carDao.getSomeCars(count);
    }
}
