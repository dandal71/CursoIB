/**
 * 
 */
package com.ib.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ib.data.entity.Curso;

/**
 * @author Compumar
 *
 */
public interface CursoRepository extends CrudRepository<Curso, Long>, CursoRepositoryCustom {
    
    /**
     * Devuelve la entidad por si Id
     * 
     * @param id Id de laentidad
     * @return Curso
     */
    Curso findById(long id);
    
    /**
     * Obtiene Todos los cursos
     */
    List<Curso> findAll();
    
    
    /**
     * Obtiene la lista de cursos que están activos, es decir estado > 0
     * 
     * @return Lista de cursos activos
     */
    List<Curso> obtenerCursosActivos();
    
    
    @Query("SELECT c FROM Curso c WHERE c.estado > 0")
    List<Curso> obtenerCursosActivosJPL();
    
  

}
