package com.sai.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sai.cruddemo.entity.Instructor;

import jakarta.persistence.EntityManager;

@Repository
public class AppDAOImpl implements AppDAO {
    
    private EntityManager entityManager;

    public AppDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

}
