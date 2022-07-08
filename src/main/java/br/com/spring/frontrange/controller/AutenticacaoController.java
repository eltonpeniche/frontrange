package br.com.spring.frontrange.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.spring.frontrange.config.security.TokenService;
import br.com.spring.frontrange.dto.TokenDto;
import br.com.spring.frontrange.dto.UsuarioDto;
import br.com.spring.frontrange.form.LoginForm;
import br.com.spring.frontrange.modelo.Usuario;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/auth")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		System.out.println("Login : "+ form.getEmail() + "| senha: " + form.getSenha());
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter(); 
		try {
			Authentication authenticate = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authenticate);
			System.out.println("token "+ token);
			
			
			return ResponseEntity.ok( new TokenDto(token, "Bearer", 
										new UsuarioDto((Usuario) authenticate.getPrincipal())));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		} 
	}
}
