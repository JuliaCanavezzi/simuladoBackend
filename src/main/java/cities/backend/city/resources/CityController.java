package cities.backend.city.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cities.backend.city.entities.City;
import cities.backend.city.repositories.CityRepository;

@RestController
public class CityController {

    @Autowired
    private CityRepository repository;

    @GetMapping("cities")
    public List<City> getCities(){
        return repository.findAll(); //devolve a lista
    }
    
}
