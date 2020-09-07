/**
 * 
 */
package com.ib.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ib.data.entity.Curso;
import com.ib.service.CursoService;

/**
 * Servicio rest de prueba para se llamado desde un cliente angular
 * 
 * @author Daniel E. Dalmagro
 *
 */
@RestController
@RequestMapping("/api/v1")
public class RestCtrl {
    
    @Autowired private CursoService cursoService;
    
    
    @GetMapping("/cursos")
    public List<Curso> getAllCursos() {
        return cursoService.obtenerCursosActivos();
    }

}
