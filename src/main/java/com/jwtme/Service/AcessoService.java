package com.jwtme.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtme.Dao.AcessoDao;
import com.jwtme.Model.Acesso;
import com.jwtme.Repository.AcessoRepository;

@Service
public class AcessoService {
	
	@Autowired
	AcessoRepository acessoRepository;
	
	@Autowired
	AcessoDao acessoDao;
	
	public boolean save(Acesso acesso) {
		try {
			acessoRepository.save(acesso);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean update(Acesso acesso) {
		try {
			acessoRepository.save(acesso);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean delete(Acesso acesso) {
		try {
			acessoRepository.delete(acesso);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Acesso findById(Integer id) {
		return acessoRepository.findById(id).orElse(null);
	}
	
	public List<Acesso> findAll() {
		return acessoRepository.findAll();
	}
	
	public List<Acesso> findByIdUsuario(Integer id) {
		return acessoDao.findAcessosByIdusuario(id);
	}
	
	
	
	

}
