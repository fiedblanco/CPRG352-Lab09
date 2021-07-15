/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Role;
import models.User;
import services.RoleService;
import services.UserServices;

/**
 *
 * @author 854276
 */
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RoleService rs = new RoleService();
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");

            
            List<User> users = rs.getAll(email);
            request.setAttribute("userAdded", true);
            request.setAttribute("usersInList", users);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RoleService rs = new RoleService();
        try {
            HttpSession session = request.getSession();
            String email = (String) session.getAttribute("email");

            List<User> users = rs.getAll(email);
            request.setAttribute("userAdded", true);
            request.setAttribute("usersInList", users);

        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        UserServices us = new UserServices();
        String action = request.getParameter("action");

        String email = request.getParameter("email");
        String firstname = request.getParameter("fname");
        String lastname = request.getParameter("lname");
        String password = request.getParameter("pass");
        String roles = request.getParameter("roles");
        Boolean active = true;

        String emailE = request.getParameter("emailE");
        String firstnameE = request.getParameter("fnameE");
        String lastnameE = request.getParameter("lnameE");
        String passwordE = request.getParameter("passwordE");
        String rolesE = request.getParameter("rolesE");

        int roleNum = Integer.parseInt(roles);

        try {
            switch (action) {
                case "Add":
                    
                 // User u = new User();
                 
                  
                  
                  
                  
                 //  User user = new User(email, firstname, lastname, password, active, roleNum);
                    
                    us.insert(email, active, firstname, lastname, password, roleNum);

                    try {
                        HttpSession session = request.getSession();

                        List<User> users = rs.getAll(email);
                        request.setAttribute("userAdded", true);
                        request.setAttribute("usersInList", users);

                    } catch (Exception ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("message", "error");
                    }

                    break;
                case "Edit":
                    us.update(emailE, active, firstnameE, lastnameE, passwordE,  roleNum);
                   
                    try {
                        HttpSession session = request.getSession();

                        List<User> users = rs.getAll(email);
                        request.setAttribute("userAdded", true);
                        request.setAttribute("usersInList", users);

                    } catch (Exception ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("message", "error");
                    }
                    
                    break;
                case "Delete":
                    us.delete(emailE);
                     try {
                      HttpSession session = request.getSession();

                        List<User> users = rs.getAll(email);
                        request.setAttribute("userAdded", true);
                        request.setAttribute("usersInList", users);

                    } catch (Exception ex) {
                        Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
                        request.setAttribute("message", "error");
                    }

            }
            request.setAttribute("message", action);
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "error");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
