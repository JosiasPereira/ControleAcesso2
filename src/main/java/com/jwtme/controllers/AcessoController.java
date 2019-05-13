package com.jwtme.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwtme.Model.Acesso;
import com.jwtme.Service.AcessoService;

@RestController
@RequestMapping(
		value="/acesso")
@ResponseBody
public class AcessoController {
	
    @Autowired
	AcessoService acessoService;
    
    @GetMapping(value="/usuario/{id}")
	private ResponseEntity<?> listarAcessosByUsuario(@PathVariable Integer id){
    	List<Acesso> acessos = new ArrayList<>();
		acessos = acessoService.findByIdUsuario(id);
	
		return ResponseEntity.ok(acessos);
		
	}
    
	

}
