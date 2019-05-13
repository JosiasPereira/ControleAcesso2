package com.jwtme.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwtme.Dao.UsuarioDao;
import com.jwtme.Model.Usuario;



@Service
public class MyUserDetails implements UserDetailsService {


  @Autowired
  private UsuarioDao usuarioDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    final Usuario user = usuarioDao.findUsuarioByUserName(username);

    if (user == null) {
      throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password("{noop}"+user.getSenha())//
        .authorities("ADMIN")//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)// 
        .build();
  }

}