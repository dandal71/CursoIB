/**
 * 
 */
package com.ib.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.ib.data.entity.Usuario;

/**
 * @author Daniel E. Dalmagro
 *
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long>, UsuarioRepositoryCustom {
    
    /**
     * Devuelve la entidad por si Id
     * 
     * @param id Id de laentidad
     * @return Curso
     */
    Usuario findById(long id);
    
    /**
     * Obtiene Todos los cursos
     */
    List<Usuario> findAll();
            
    
    /**
     * Obtiene los usuario con estado > 0
     * @return
     */
    @Query("SELECT u FROM Usuario u WHERE u.estado > 0")
    List<Usuario> obtenerUsuariosActivos();
    
    
    @Query("SELECT u FROM Usuario u WHERE u.username = :username AND u.estado > 0")
    Usuario obtenerUsuarioByUsername(@Param("username") String username);
  

}
