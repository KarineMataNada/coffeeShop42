package com.coffeeshop42.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop42.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	Optional<Usuario> findById(Long id);
	Optional<Usuario> findByUsername(String username);
}
