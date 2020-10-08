/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.controller;

import com.david.dao.CourseDaoLocal;
import com.david.dao.StudentDaoLocal;
import com.david.model.Course;
import com.david.model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {
    @EJB
    private CourseDaoLocal courseDao;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String courseIdStr = request.getParameter("courseId");
        int courseId = 0;
        if (courseIdStr != null && !courseIdStr.equals("")) {
            courseId = Integer.parseInt(courseIdStr);
        }
        String coursename = request.getParameter("coursename");
        String creditsStr = request.getParameter("credits");
        int credits = 0;
        if (creditsStr != null && !creditsStr.equals("")) {
            credits = Integer.parseInt(creditsStr);
        }
        String semesterStr = request.getParameter("semester");
        int semester = 0;
        if (semesterStr != null && !semesterStr.equals("")) {
            semester = Integer.parseInt(semesterStr);
        }
        String numberstudentsStr = request.getParameter("semester");
        int numberstudents = 0;
        if (numberstudentsStr != null && !numberstudentsStr.equals("")) {
            numberstudents = Integer.parseInt(numberstudentsStr);
        }
        
        Course course = new Course(courseId, coursename, credits, semester, numberstudents);
        
        if ("Add".equalsIgnoreCase(action)) {
            courseDao.addCourse(course);
        }
        else if ("Edit".equalsIgnoreCase(action)) {
            courseDao.editCourse(course);
        }
        else if ("Delete".equalsIgnoreCase(action)) {
            courseDao.deleteCourse(courseId);
        }
        else if ("Search".equalsIgnoreCase(action)) {
            course = courseDao.getCourse(courseId);
        }
        request.setAttribute("student", course);
        request.setAttribute("allStudent", courseDao.getAllCourses());
        request.getRequestDispatcher("studentinfo.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
