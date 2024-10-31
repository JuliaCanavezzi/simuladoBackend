package cities.backend.city.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cities.backend.city.entities.City;
import cities.backend.city.repositories.CityRepository;

@Service
public class CityService {
    
    @Autowired
    private CityRepository repository;

    public List <City> getCities(){
        return repository.findAll();
    }
}
