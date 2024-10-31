package cities.backend.city.dtos;

public record CityRequest(
    
    String name,
    String states,
    String country,
    String population,
    String zipCode
) {
    
}
