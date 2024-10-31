package cities.backend.city.dtos;


public record CityResponse(
    Integer id,
    String name,
    String states,
    String country,
    String population,
    String zipCode
) {
    
}
