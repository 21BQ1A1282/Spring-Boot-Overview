package com.sai.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sai.cruddemo.entity.Instructor;
import com.sai.cruddemo.entity.InstructorDetail;

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

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {
        
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

}
