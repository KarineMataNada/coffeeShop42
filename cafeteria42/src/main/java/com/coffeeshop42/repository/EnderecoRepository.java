package com.coffeeshop42.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop42.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
		
	Optional<Endereco> findById(Long id);
	Optional<Endereco> findByCep(String cep);
}
