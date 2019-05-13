package com.jwtme.Dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.jwtme.Exception.GeralException;
import com.jwtme.Model.Usuario;

@Service
public class UsuarioDao {
	
	@PersistenceContext
	EntityManager eManager ;
	
	public Usuario findUsuarioByUserName(String username) {
		System.out.println("findUserByName: "+username);
		try {
			
			TypedQuery<Usuario> query = eManager.createQuery(
					"select U from Usuario U  WHERE U.usuario ='"+username+"'",Usuario.class);			
			
			return  query.getSingleResult();
		}
		catch (NoResultException e) {
			throw new GeralException("Usuário não encontrado no sistema!");
		}
		catch(Exception e) {
			
			throw new RuntimeException(e.getMessage());
		}
	}
	

}
