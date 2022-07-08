package br.com.spring.frontrange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.spring.frontrange.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
}
