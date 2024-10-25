package com.sai.cruddemo.dao;

import com.sai.cruddemo.entity.Instructor;
import com.sai.cruddemo.entity.InstructorDetail;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

}
