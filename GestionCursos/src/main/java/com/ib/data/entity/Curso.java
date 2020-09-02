/**
 * Entidad curso
 */
package com.ib.data.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Daniel E. Dalmagro
 *
 */
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty    
    private String nombre;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechainicio;
    
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechafin;
    
    private Integer cupos;
    
    private Integer estado;

    /**
     * Accesibilidad protected, sololo usa JPA
     */
    public Curso() {
        super();
    }

    
  

    public Curso(Long id, String nombre, Integer estado) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
    } 
    
    
    @Override
    public String toString() {        
        return String.format(
                "Customer[id=%d, nombre='%s', estado='%s']",
                id, nombre, estado);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }
    
    
}
