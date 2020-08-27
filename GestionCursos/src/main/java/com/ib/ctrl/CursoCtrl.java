/**
 * 
 */
package com.ib.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador de registro de usuario
 * 
 * @author Daniel E. Dalmagro
 *
 */
@Controller
public class CursoCtrl {
    
    @GetMapping("/admin/cursos")
    public String home(@RequestParam(name = "id", required = false) Integer id, Model model) {
        //model.addAttribute("nombre", nombre);
        return "/admin/curso-lista";
    }

}
