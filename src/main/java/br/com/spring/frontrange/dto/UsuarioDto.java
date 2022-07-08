package br.com.spring.frontrange.dto;

import br.com.spring.frontrange.modelo.Usuario;

public class UsuarioDto {

	private String email;
	private String nome;

	public UsuarioDto(Usuario usuario) {
		this.email = usuario.getEmail();
		this.nome = usuario.getNome();
	}

	public String getEmail() {
		return email;
	}
	public String getNome() {
		return nome;
	}
	
}
