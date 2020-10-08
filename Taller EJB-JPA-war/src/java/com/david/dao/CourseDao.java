/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.dao;

import com.david.model.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author david
 */
@Stateless
public class CourseDao implements CourseDaoLocal {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addCourse(Course course) {
        em.persist(course);
    }

    @Override
    public void editCourse(Course course) {
        em.merge(course);
    }

    @Override
    public void deleteCourse(int courseId) {
        em.remove(getCourse(courseId));
    }

    @Override
    public Course getCourse(int courseId) {
        return em.find(Course.class, courseId);
    }

    @Override
    public List<Course> getAllCourses() {
        return em.createNamedQuery("Course.getAll").getResultList();
    }

    
}
