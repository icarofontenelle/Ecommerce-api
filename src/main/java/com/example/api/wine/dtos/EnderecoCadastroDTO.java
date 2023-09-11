package com.example.api.wine.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoCadastroDTO(
    
    @NotBlank
    String rua,

    @NotBlank
    String bairro,

    @NotBlank 
    String cidade,

    @NotBlank 
    String uf,

    @NotBlank
    @Pattern(regexp = "\\d{8}") 
    String cep) {

}
