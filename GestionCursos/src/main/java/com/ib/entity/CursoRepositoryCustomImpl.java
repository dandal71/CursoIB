/**
 * 
 */
package com.ib.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que implmenta la interface para extender el CRUD Repository
 * 
 * @author Daniel E. Dalmagro
 *
 */
public class CursoRepositoryCustomImpl implements CursoRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public List<Curso> obtenerCursosActivos() {
        String hql = "SELECT e FROM Curso e WHERE e.estado > :estado";
        TypedQuery<Curso> query = entityManager.createQuery(hql, Curso.class);
        query.setParameter("estado", 0);
        return query.getResultList();
    }

}
