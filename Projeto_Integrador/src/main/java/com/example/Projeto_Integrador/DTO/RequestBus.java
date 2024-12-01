package com.example.Projeto_Integrador.DTO;


import java.util.UUID;

import jakarta.validation.constraints.NotBlank;


public record RequestBus(UUID Id,@NotBlank String marca, @NotBlank String modelo, String Description,int ano,double preco) {
  
}
