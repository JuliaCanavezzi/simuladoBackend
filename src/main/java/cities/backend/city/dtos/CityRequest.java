package cities.backend.city.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CityRequest(

    @NotBlank(message = "Nome da Cidade não pode ser em branco")
    @Size(min=3, message = "Tamanho mínimo para nome da cidade é 3")
    String name,

    @NotBlank(message = "Estado não pode ser em branco")
    @Size(min=2, message = "Tamanho mínimo para estado é 2")
    String states,

    @NotBlank(message = "País não pode ser em branco")
    @Size(min=4, message = "Tamanho mínimo para país é 2")
    String country,

    @NotBlank(message = "População não pode ser em branco")
    @Size(min=3, message = "Tamanho mínimo para população é 3")
    String population,

    @NotBlank(message = "Código Postal não pode ser em branco")
    @Size(min=4, message = "Tamanho mínimo para Código Postal é 4")
    String zipCode
) {
    
}
