package br.com.spring.frontrange.dto;

import br.com.spring.frontrange.modelo.Usuario;

public class TokenDto {

	private UsuarioDto user; 
	private String token;
	private String tipoAuth;
	
	public TokenDto(String token, String tipoAuth, UsuarioDto user){
		this.user = user;
		this.token = token;
		this.tipoAuth = tipoAuth;
		
	}

	public UsuarioDto getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}

	public String getTipoAuth() {
		return tipoAuth;
	}

	

}
