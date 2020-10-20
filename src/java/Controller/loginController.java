/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HoangPhuc
 */
public class loginController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        if (request.getParameter("btnLogout") != null) {//button logout in navbar
            request.getSession().removeAttribute("user");
            request.getSession().removeAttribute("numberQuiz");
            request.getSession().removeAttribute("fail");
            request.getSession().removeAttribute("numberQuizFail");
            request.getSession().removeAttribute("index");
            RequestDispatcher re = request.getRequestDispatcher("login.jsp");
            re.forward(request, response);
        }
        if (request.getParameter("btnRegister") != null) {//button register in form register
            String username = request.getParameter("txtUsernameRe");
            String pass = request.getParameter("txtPasswordRe");
            int role = Integer.parseInt(request.getParameter("txtRoleRe"));
            String email = request.getParameter("txtEmailRe");
            boolean fla = new UserDAO().register(username, pass, role, email);
            //check insert success or not
            if (fla == false) {
                request.getSession().setAttribute("registerFail", -1);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
        //button register in logion form
        if (request.getParameter("btnRe") != null) {
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        //button login in login form
        if (request.getParameter("btnSubmit") != null) {
            try {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                Users u = new UserDAO().checkLogin(username, password);
                //check that get user object or not
                if (u != null) {
                    request.getSession().setAttribute("index", 0);
                    request.getSession().setAttribute("user", username);
                    request.getSession().setAttribute("correct", 0);

                    request.getRequestDispatcher("TakeQuizController").forward(request, response);
                } else {
                    request.getSession().setAttribute("fail", "fail");
                    RequestDispatcher re = request.getRequestDispatcher("login.jsp");
                    re.forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        request.getSession().removeAttribute("numberQuiz"); 
        request.getSession().removeAttribute("numberQuizFail");
        request.getSession().removeAttribute("index");
        request.getRequestDispatcher("login.jsp").forward(request, response);
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
