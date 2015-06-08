/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bbu.bibliospring.web.servlet;

import edu.bbu.bibliospring.backend.model.User;
import edu.bbu.bibliospring.backend.service.UserService;
import edu.bbu.bibliospring.backend.service.exception.ServiceException;
import java.io.IOException;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zsvitalyos
 */
public class ExampleServlet extends HttpServlet {
    
    @EJB
    private UserService uservice;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            final String command = request.getParameter("action");
            if ("insert".equals(command)) {
                User u = new User();
                u.setUserName(request.getParameter("userName"));
                u.setFirstName(request.getParameter("firstName"));
                u.setLastName(request.getParameter("lastName"));
                u.setPassword(request.getParameter("password"));
                uservice.insertUser(u);
            } else if ("delete".equals(command)){
                User u = new User();
                u.setId(Long.parseLong(request.getParameter("id")));
                u.setFirstName("");
                u.setLastName("");
                u.setUserName("");
                u.setPassword("");
                u.getUuid();
                uservice.deleteUser(u);
            }
            Collection<User> users = uservice.getAllUsers();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } catch (ServiceException serviceException) {
            System.out.println(serviceException.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
