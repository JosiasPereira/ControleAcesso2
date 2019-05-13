package com.jwtme.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwtme.Dao.UsuarioDao;
import com.jwtme.Exception.GeralException;
import com.jwtme.Model.Usuario;
import com.jwtme.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public boolean save(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean update(Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean delete(Usuario usuario) {
		try {
			usuarioRepository.deleteById(usuario.getId());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public Usuario findById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}
	
	public Usuario findByUserName(String username) {
		return usuarioDao.findUsuarioByUserName(username);		
	}
	
	public Usuario authenticate(Usuario usuario) {
		Usuario user = null;
		
		user = this.findByUserName(usuario.getUsuario());
		if (user==null) {
			throw new GeralException("Usuário ou senha incorretos ou não cadastrados no sistema.");
			
		}
		
		if (user.getSenha().equals(usuario.getSenha()) && user.getUsuario().equals(usuario.getUsuario())){
			return user;
		}else {
			throw new GeralException("Usuário ou senha incorretos ou não cadastrados no sistema.");
			
		}
		
		
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	

}
