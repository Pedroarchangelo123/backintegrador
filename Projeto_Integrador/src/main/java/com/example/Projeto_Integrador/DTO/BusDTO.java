package com.example.Projeto_Integrador.DTO;

import jakarta.validation.constraints.NotBlank;

public record BusDTO(Long Id,@NotBlank String marca,String cor, @NotBlank String modelo, String detalhe,int ano,double preco ) {

}
