package cities.backend.city.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cities.backend.city.entities.City;
import cities.backend.city.repositories.CityRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
    
    @Autowired
    private CityRepository repository;

    public List <City> getCities(){
        return repository.findAll();
    }

    public City getCityById(int id){
        return repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não Cadastrada")
        );
    }

    public City save (City city){
        return repository.save(city);
    }

    public void deleteById(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Cidade não Cadastrada");
        }
    }

    public void update(int id, City city){
        City aux = repository.getReferenceById(id);
        aux.setName(city.getName());
        aux.setStates(city.getStates());
        aux.setCountry(city.getCountry());
        aux.setPopulation(city.getPopulation());
        aux.setZipCode(city.getZipCode());
        repository.save(aux);
    }
}
