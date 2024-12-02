package com.example.Projeto_Integrador.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Projeto_Integrador.DTO.BusDTO;
import com.example.Projeto_Integrador.Model.BusModel;
import com.example.Projeto_Integrador.Repository.BusRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("onibus")
@CrossOrigin(origins = "https://mapbus.netlify.app")
public class BusController {
	
	@Autowired
	BusRepository repository;
	@GetMapping("getonibus")
	public ResponseEntity<?> GetBus(){
		List<BusModel> lista = repository.findAll();
				return ResponseEntity.ok(lista);
	}

	@PostMapping("postonibus") 
	public ResponseEntity<?> PostBus(@RequestBody @Valid BusDTO data){
		BusModel newBus = new BusModel();
		newBus.setDetalhe(data.detalhe());
		newBus.setCor(data.cor());
		newBus.setAno(data.ano());
		newBus.setMarca(data.marca());
		newBus.setPreco(data.preco());
		newBus.setModelo(data.modelo());
		repository.save(newBus);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBus);
	}
	
	@PutMapping("putonibus/{Id}")
	@Transactional
	public ResponseEntity<?> UpdateBus(@PathVariable ("Id") Long Id, @RequestBody  @Valid BusDTO busDTO){
		Optional<BusModel>  optionalBusModel = repository.findById(Id);
		
		if (optionalBusModel.isPresent()) {
			BusModel Bus = optionalBusModel.get();
			Bus.setAno(busDTO.ano());
			Bus.setDetalhe(busDTO.detalhe());
			Bus.setMarca(busDTO.marca());
			Bus.setModelo(busDTO.modelo());
			Bus.setPreco(busDTO.preco());
			repository.save(Bus);
		    return ResponseEntity.ok(Bus);
		     
		   
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("deleteonibus/{Id}")
	@Transactional
	public ResponseEntity DeleteBus(@PathVariable Long Id) {
		repository.deleteById(Id);
		return ResponseEntity.noContent().build();
	}
	}
	

