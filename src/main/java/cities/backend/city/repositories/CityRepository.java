package cities.backend.city.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cities.backend.city.entities.City;

public interface CityRepository extends JpaRepository<City, Integer> {
    
}
