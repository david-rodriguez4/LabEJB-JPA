/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author david
 */
@Entity
@Table
@NamedQueries(@NamedQuery(name = "Course.getAll", query = "SELECT e FROM Course e"))
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int courseId;
    @Column
    private String coursename;
    @Column
    private int credits;
    @Column
    private int semester;
    @Column
    private int numberstudents;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getNumberstudents() {
        return numberstudents;
    }

    public void setNumberstudents(int numberstudents) {
        this.numberstudents = numberstudents;
    }

    public Course(int courseId, String coursename, int credits, int semester, int numberstudents) {
        this.courseId = courseId;
        this.coursename = coursename;
        this.credits = credits;
        this.semester = semester;
        this.numberstudents = numberstudents;
    }

    public Course() {
        
    }

}
