package cities.backend.city.resources;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import cities.backend.city.dtos.CityRequest;
import cities.backend.city.dtos.CityResponse;
import cities.backend.city.services.CityService;
import jakarta.validation.Valid;

@RestController
public class CityController {

    @Autowired
    private CityService service;

    @GetMapping("cities")
    public ResponseEntity <List<CityResponse>> getCities(){
        return ResponseEntity.ok(service.getCities()); //chama o serviço e devolve as cidades. //chama o serviço e devolve as cidades
    }

    @GetMapping("cities/{id}")
    public ResponseEntity <CityResponse> getCityById(@PathVariable int id) {
        return ResponseEntity.ok(service.getCityById(id));   
    }

    @PostMapping("cities")
    public ResponseEntity <CityResponse> save (@Valid @RequestBody CityRequest city){
        CityResponse newCity = service.save(city);
        URI location = ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(newCity.id())
                            .toUri();

        return ResponseEntity.created(location).body(newCity);
    }

    @DeleteMapping("cities/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        service.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("cities/{id}")
    public ResponseEntity<Void> update(@PathVariable int id,
                                       @RequestBody CityRequest city){
        service.update(id, city);

        return ResponseEntity.ok().build();
    }
    
}
