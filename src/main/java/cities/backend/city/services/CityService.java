package cities.backend.city.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cities.backend.city.dtos.CityRequest;
import cities.backend.city.dtos.CityResponse;
import cities.backend.city.entities.City;
import cities.backend.city.mappers.CityMapper;
import cities.backend.city.repositories.CityRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CityService {
    
    @Autowired
    private CityRepository repository;

     public List <CityResponse> getCities(){
        return repository.findAll()
                         .stream()
                         .map(city -> CityMapper.toDto(city))
                         .toList();
    }

    public CityResponse getCityById(int id ){
        City city = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Cidade não Cadastrada")
        );
            return CityMapper.toDto(city); 
    }

    public CityResponse save(CityRequest dtoRequestCity){
        City city = repository.save(CityMapper.toEntity(dtoRequestCity));
        return CityMapper.toDto(city);
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
