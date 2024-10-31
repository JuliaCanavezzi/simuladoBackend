package cities.backend.city.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("cities/{id}")
    public City getCityById(@PathVariable int id) {
        return service.getCityById(id); 
    }

    @PostMapping("cities")
    public City save (@RequestBody City city){
        return service.save(city);
    }

    @DeleteMapping("cities/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("cities/{id}")
    public void update(@PathVariable int id, 
                       @RequestBody City city){
        service.update(id, city);
    }
    
}
