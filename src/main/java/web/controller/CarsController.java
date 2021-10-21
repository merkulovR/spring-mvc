package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.List;

@Controller
public class CarsController {
    @Autowired
    private CarService carService;

    /**
    * Сперва сделал все в этом методе, в нем было на 2-3 строчки больше кода,
    * но меня очень смутил пункт в задаче, где просят сделать "сервис"
    * в общем, все и так работало, но я решил добавить сервис и дао слои,
    * если я верно понял, что подразумевалось под сервисом
    */
    @GetMapping(value = "/cars")
    public String printCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        List<Car> carList;

        if (count != null && count > 0 && count < 5) {
            carList = carService.getSomeCars(count);
        } else {
            carList = carService.getAllCars();
        }

        model.addAttribute("carList", carList);
        return "cars";
    }
}
