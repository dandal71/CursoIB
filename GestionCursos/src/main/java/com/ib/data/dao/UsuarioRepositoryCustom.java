/**
 * 
 */
package com.ib.data.dao;

import com.ib.data.entity.Usuario;

/**
 * Interface para extender la funcionalidad del CRUD Repository
 * 
 * @author Daniel E. Dalmagro
 *
 */
public interface UsuarioRepositoryCustom {

    /**
     * Obtiene unusuario por su username
     * 
     * @return Usuario
     */
    Usuario obtenerUsuarioByUsername(String username);
}
