package com.ib.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ib.data.entity.Usuario;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario =  usuarioService.obtenerUsuarioByUsername(username);
        
        if (usuario == null) {
            throw  new UsernameNotFoundException(
                    String.format("EL NOMBRE DE USUARIO %s NO EXISTE!", username));
        }        
        return usuario;
    }
}
