package com.jwtme.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwtme.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
