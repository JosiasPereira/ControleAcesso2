package com.jwtme.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.jwtme.Exception.GeralException;
import com.jwtme.Model.Acesso;

@Service
public class AcessoDao {
	
	@PersistenceContext
	EntityManager eManager ;
	
	public List<Acesso> findAcessosByIdusuario(Integer idUsuario) {
		
		try {
			
			TypedQuery<Acesso> query = eManager.createQuery(
					"select A from Acesso as A join A.usuario as U where U.id="+idUsuario.toString()+
					" and (A.ler is true or A.escrever is true or A.executar is true)",Acesso.class);			
			//query.setParameter("ativo", true);
			return  query.getResultList();
		}
		catch (NoResultException e) {
			throw new GeralException("Nenhum acesso foi encontrado para o usuario!");
		}
		catch(Exception e) {
			
			throw new RuntimeException(e.getMessage());
		}
	}

}
