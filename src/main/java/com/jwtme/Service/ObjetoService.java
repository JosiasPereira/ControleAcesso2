package com.jwtme.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtme.Model.Objeto;
import com.jwtme.Repository.ObjetoRepository;

@Service
public class ObjetoService {
	
	@Autowired
	ObjetoRepository objetoRepository;
	
	public boolean save(Objeto objeto) {
		try {
			objetoRepository.save(objeto);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean update(Objeto objeto) {
		try {
			objetoRepository.save(objeto); 
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean delete(Objeto objeto) {
		try {
			objetoRepository.deleteById(objeto.getId());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Objeto findById(Integer id) {
		return objetoRepository.findById(id).orElse(null);
	}
	
	public List<Objeto> findAll() {
		return objetoRepository.findAll();
	}

}
