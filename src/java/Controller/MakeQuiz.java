/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.QuestionDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HoangPhuc
 */
public class MakeQuiz extends HttpServlet {

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
        String question = request.getParameter("txtQuestion");
        String option = request.getParameter("radOption"); //index cau dung
        String op1 = request.getParameter("txtOp1");
        String op2 = request.getParameter("txtOp2");
        String op3 = request.getParameter("txtOp3");
        String op4 = request.getParameter("txtOp4");
        String username = request.getSession().getAttribute("user").toString();
        String ans = "";
        //only correct answer have [ans] before it
        switch (Integer.parseInt(option)) {
            case 1:
                op1 = "[ans]" + op1;
                break;
            case 2:
                op2 = "[ans]" + op2;
                break;
            case 3:
                op3 = "[ans]" + op3;
                break;
            case 4:
                op4 = "[ans]" + op4;
                break;
        }
        //add answer following string split by <br>
        ans = op1 + "<br>" + op2 + "<br>" + op3 + "<br>" + op4;
        QuestionDAO qDAO = new QuestionDAO();
        Date date = new Date(); 
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        boolean flag = qDAO.addQuiz(question, ans, sqlDate, username);
        request.getSession().setAttribute("addQuiz", flag);
        request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
        

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
        request.getRequestDispatcher("MakeQuiz.jsp").forward(request, response);
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
