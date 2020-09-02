/**
 * 
 */
package com.ib.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ib.data.dao.CursoRepository;
import com.ib.data.entity.Curso;

/**
 * Clase de servicio para Cursos
 * 
 * @author Daniel E. Dalmagro
 *
 */
@Service
public class CursoService {

    @Autowired private CursoRepository cursoRepository;
    
    
    /**
     * Obtiene un curso por su id
     * 
     * @param id Id del curso
     * @return Curso
     */
    public Curso obtenerCursoPorID(Long id) {
        if (id != null) {
            Optional<Curso> curso = this.cursoRepository.findById(id);         
            if (curso.isPresent()) {
                return (Curso)curso.get();
            
            }
        }
        return new Curso();
    }
    
    /**
     * Obtiene todos los curso, incluso los que fueron dados de baja
     * 
     * @return Lista de todos los cursos
     */
    public List<Curso> obtenerTodosLosCursos(){
        return this.cursoRepository.findAll();
    }
    
    /**
     * Obtiene solo los cursos que no fueron dados de baja
     * 
     * @return Lista de cursos activos
     */
    public List<Curso> obtenerCursosActivos(){
        return this.cursoRepository.obtenerCursosActivos();
    }
    
    public List<Curso> obtenerCursosActivosJPL() {
        return this.cursoRepository.obtenerCursosActivosJPL();
    }
    
    public void saveCurso(Curso curso) {
        //Si es un nuevo curso su estado es uno
        if (curso.getId() == null) {
            curso.setEstado(Integer.valueOf(1));
        }
        this.cursoRepository.save(curso);
    }
}
