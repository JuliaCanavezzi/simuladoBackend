package cities.backend.city.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cities.backend.city.dtos.CityRequest;
import cities.backend.city.entities.City;
import cities.backend.city.mappers.CityMapper;
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

    public City save(CityRequest dtoRequestCity){
        return repository.save(CityMapper.toEntity(dtoRequestCity));
    }

    public void deleteById(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Cidade não Cadastrada");
        }
    }

    public void update(int id, CityRequest dtoRequestCity){
        City aux = repository.getReferenceById(id);
        aux.setName(dtoRequestCity.name());
        aux.setStates(dtoRequestCity.states());
        aux.setCountry(dtoRequestCity.country());
        aux.setPopulation(dtoRequestCity.population());
        aux.setZipCode(dtoRequestCity.zipCode());
        repository.save(aux);
    }
}
