/**
 * 
 */
package com.ib.form;

import javax.validation.Valid;

import com.ib.data.entity.Curso;

/**
 * Clase formulario para cursos
 * 
 * @author Daniel E. Dalmagro
 *
 */
public class CursoForm {

    @Valid
    private Curso curso = new Curso();

       
    public CursoForm() {
        super();
    }
    

    public CursoForm(Curso curso) {
        super();
        this.curso = curso;
    }


    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public Curso getCurso() {
        return curso;
    }
    
}
