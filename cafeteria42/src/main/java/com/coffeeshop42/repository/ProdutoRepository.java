package com.coffeeshop42.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop42.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
		
	Optional<Produto> findById(Long id);
}
