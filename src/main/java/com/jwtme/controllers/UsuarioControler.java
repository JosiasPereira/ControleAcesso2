package com.jwtme.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtme.Model.Usuario;
import com.jwtme.Service.UsuarioService;
import com.jwtme.View.UsuarioView;
import com.jwtme.security.AccountCredentials;

@RestController
@ResponseBody
@RequestMapping(
		value="/usuario",
		consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
		produces=MediaType.APPLICATION_JSON_UTF8_VALUE
		)
public class UsuarioControler {
	
	@Autowired
	UsuarioService usuarioService;
	   
	
	@PostMapping(value="/authenticate")
	private ResponseEntity<Usuario> JWTAutenticar(@RequestBody Usuario usuario){
		System.out.println("findUserByName: "+usuario.getNome());
		Usuario user = usuarioService.authenticate(usuario);
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value="/pessoa")
	private ResponseEntity<Usuario> retornaLoginCompleto(@RequestBody UsuarioView usuario){
		//System.out.println("findUserByName: "+usuario.getUsuario());
		Usuario user = usuarioService.findByUserName(usuario.getUsuario());
		
		return ResponseEntity.ok(user);
	}
	 
	//@RequestMapping("/users")
	@PostMapping("/users")
	public String getUsers(@RequestBody AccountCredentials dados) {
		System.out.println(dados.getUsername());
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"}," +
		           "{\"name\":\"Jackie\",\"country\":\"China\"}]}";
	}
	

}
