package cities.backend.city.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import cities.backend.city.entities.City;
import cities.backend.city.services.CityService;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("cities")
    public List<City> getCities(){
        return service.getCities(); //chama o serviço e devolve as cidades
    }
    
}
