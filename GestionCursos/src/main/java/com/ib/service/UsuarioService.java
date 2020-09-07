/**
 * 
 */
package com.ib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ib.data.dao.UsuarioRepository;
import com.ib.data.entity.Usuario;

/**
 * Clase de servicio para Usuario
 * 
 * @author Daniel E. Dalmagro
 *
 */
@Service
public class UsuarioService {

    @Autowired private UsuarioRepository usuarioRepository;
    
    
    /**
     * Obtiene un usuario por su id
     * 
     * @param id Id del usuario
     * @return Usuario
     */
    public Usuario obtenerUsuarioPorID(Long id) {
        if (id != null) {
            Optional<Usuario> usuario = this.usuarioRepository.findById(id);         
            if (usuario.isPresent()) {
                return (Usuario)usuario.get();
            
            }
        }
        return new Usuario();
    }
    
    /**
     * Obtiene todos los usuario, incluso los que fueron dados de baja
     * 
     * @return Lista de todos los usuarios
     */
    public List<Usuario> obtenerTodosLoUsuario(){
       return this.usuarioRepository.findAll();
    }
    

    /**
     * Obtiene un usuario por su username
     * 
     * @param username Nombre de usuario
     * @return Usuario
     */
    public Usuario obtenerUsuarioByUsername(String username) {
        return this.usuarioRepository.obtenerUsuarioByUsername(username); 
    }
}
