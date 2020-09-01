/**
 * 
 */
package com.ib.ctrl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ib.data.Curso;
import com.ib.service.CursoService;

/**
 * Controlador de registro de usuario
 * 
 * @author Daniel E. Dalmagro
 *
 */
@Controller
public class CursoCtrl {
    
    @Autowired private CursoService cursoService;
    
    @GetMapping("/admin/cursos")
    public String procesarCurso(@RequestParam(name = "id", required = false) Long id, Model model) {
                        
        if (id == null) {            
            List<Curso> cursos = cursoService.obtenerCursosActivosJPL();        
            model.addAttribute("cursos", cursos);    
            return "/admin/curso-lista";    
        } else {            
            model.addAttribute("curso", cursoService.obtenerCursoPorID(id));
            return "/admin/curso-form";
        }
        
    }
    
    @PostMapping("/admin/cursos")
    public String procesarFormCurso(Model model,  Curso curso, BindingResult resultadoForm) {
                
        //Si el form no tiene errores
        if (!resultadoForm.hasErrors()) {
            cursoService.saveCurso(curso);               
            List<Curso> cursos = cursoService.obtenerCursosActivosJPL();        
            model.addAttribute("cursos", cursos);    
            return "/admin/curso-lista";  
        } else {
            return "/admin/curso-form";
        }
        
    }

}
