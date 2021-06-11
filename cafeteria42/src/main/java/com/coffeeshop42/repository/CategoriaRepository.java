package com.coffeeshop42.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop42.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
		
	Optional<Categoria> findById(Long id);
	Optional<Categoria> findByName(String nome);
}
