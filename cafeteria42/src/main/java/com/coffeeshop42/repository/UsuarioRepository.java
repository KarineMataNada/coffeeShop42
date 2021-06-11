package com.coffeeshop42.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coffeeshop42.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
	Optional<Usuario> findById(Long id);
	Optional<Usuario> findByUsername(String username);
	List<Usuario> findByNomeContaining(String nome);

}
