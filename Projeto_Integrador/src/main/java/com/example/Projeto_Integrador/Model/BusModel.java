package com.example.Projeto_Integrador.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "onibus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "Id")
public class BusModel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	
	private Long Id;
	private String marca;
	private String cor;
	private String modelo;
	@Column(name="detalhe")
	private  String detalhe;
	private int ano;
	private double preco;

	
	

	
	
	

	
	
	
}
