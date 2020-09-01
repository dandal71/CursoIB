/**
 * 
 */
package com.ib.entity;

import java.util.List;

/**
 * Interface para extender la funcionalidad del CRUD Repository
 * 
 * @author Daniel E. Dalmagro
 *
 */
public interface CursoRepositoryCustom {

    /**
     * Obtiene la lista de cursos que están activos, es decir estado > 0
     * 
     * @return Lista de cursos activos
     */
    List<Curso> obtenerCursosActivos();
}
