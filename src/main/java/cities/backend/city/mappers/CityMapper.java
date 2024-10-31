package cities.backend.city.mappers;

import cities.backend.city.dtos.CityRequest;
import cities.backend.city.entities.City;

public class CityMapper {

    public static City toEntity(CityRequest request){
        City city = new City();
        city.setName(request.name());
        city.setStates(request.states());
        city.setCountry(request.country());
        city.setPopulation(request.population());
        city.setZipCode(request.zipCode());
        return city;
    }
    
}
