package com.example.Projeto_Integrador.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Projeto_Integrador.Model.BusModel;

@Repository
public interface BusRepository extends JpaRepository<BusModel, UUID> {

	Optional<BusModel> findById(Long Id);

	void deleteById(Long Id);


	

	

}
