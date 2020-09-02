/**
 * 
 */
package com.ib.ctrl;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ib.form.CursoForm;
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
    
    /**
     * Procesa el listado de cursos
     */
    @GetMapping(value = {"/admin/cursos", "/admin/cursos/{id}"})
    public String procesarCurso( @PathVariable(required = false) Long id
                            , @ModelAttribute CursoForm cursoForm, Model model) {

        //Si el id es nulo muestra todos los usuarios activos (estado > 0)                
        if (id == null) {                 
            model.addAttribute("cursos", cursoService.obtenerCursosActivosJPL());    
            return "/admin/curso-lista";    
        } else { //Si el id no es nulo, carga el form con esa entidad
            cursoForm.setCurso(cursoService.obtenerCursoPorID(id));            
            return "/admin/curso-form";
            
            //Esto sería lo idea, es decir llamar al otro método, para que cargue el form
            //pero por algún motivo el @NotEmpty me limpia el field en el formulario
            //return "redirect:/admin/cursos/form/" + id;  
        }        
    }
    
    /**
     * Procesa el fomulario de cursos 
     */
    @RequestMapping(value = {"/admin/cursos/form", "/admin/cursos/form/{id}"})
    public String procesarFormCurso(@PathVariable(required = false) Long id
            , @Valid  @ModelAttribute CursoForm cursoForm,  BindingResult resultadoValidacion) {
        
        //Si el id no es nulo cargo el form con los datos del curso
        if (id != null) {            
            cursoForm.setCurso(cursoService.obtenerCursoPorID(id));   
            return "/admin/curso-form";
        } 
        
        //Si el form no tiene errores
        if (!resultadoValidacion.hasErrors()) {
            cursoService.saveCurso(cursoForm.getCurso());                 
            return "redirect:/admin/cursos";  
        } else {
            return "/admin/curso-form"; //Si tiene error el formulario
        }       
    }

}
