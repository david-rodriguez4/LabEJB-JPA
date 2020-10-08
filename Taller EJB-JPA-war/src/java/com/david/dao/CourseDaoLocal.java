/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.dao;

import com.david.model.Course;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author david
 */
@Local
public interface CourseDaoLocal {

    void addCourse(Course course);

    void editCourse(Course course);

    void deleteCourse(int courseId);

    Course getCourse(int courseId);

    List<Course> getAllCourses();
    
}
