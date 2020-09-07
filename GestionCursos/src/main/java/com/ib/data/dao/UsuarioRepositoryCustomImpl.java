package com.ib.data.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import com.ib.data.entity.Usuario;

public class UsuarioRepositoryCustomImpl implements UsuarioRepositoryCustom {

    public UsuarioRepositoryCustomImpl() {
        super();
    }

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Usuario obtenerUsuarioByUsername(String username) {
        String hql = "SELECT u FROM Usuario u WHERE u.username = :username AND u.estado > :estado";
        TypedQuery<Usuario> query = entityManager.createQuery(hql, Usuario.class);
        query.setParameter("useraname", username);
        query.setParameter("estado", 0);
        return query.getSingleResult();
    }

}
