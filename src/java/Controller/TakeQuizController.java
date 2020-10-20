/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.QuestionDAO;
import Models.Question;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class TakeQuizController extends HttpServlet {

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
        //button after done test and show result, then ask for continue
        if (request.getParameter("btnStartAnother") != null) {
            request.getSession().setAttribute("numberQuiz", -1);
            request.getSession().setAttribute("index", 0);
            request.getSession().setAttribute("correct", 0);
            request.getSession().removeAttribute("numberQuizFail");
        } else if (request.getParameter("btnNext") != null) {//next question in test
            request.getSession().removeAttribute("numberQuizFail");
            request.getSession().setAttribute("index", String.valueOf(Integer.parseInt(request.getSession().getAttribute("index").toString()) + 1));
            String content = request.getParameter("txtContent");
            //get question by content then get its answer
            Question q = new QuestionDAO().getAll(content);
            boolean fla = q.getListAnswer().get(request.getParameter("txta"));
            //if answer is correct then add 1 to correct answer
            if (fla == true) {
                request.getSession().setAttribute("correct", String.valueOf(Integer.parseInt(request.getSession().getAttribute("correct").toString()) + 1));
            }
            
            //get current time follow form mm:ss
            
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String a = sdf.format(d);
            String min = a.split(":")[1];
            String sec = a.split(":")[2];
            int currentMin = Integer.parseInt(min) - Integer.parseInt(request.getSession().getAttribute("startMin").toString());
            int currentSec = Integer.parseInt(sec) - Integer.parseInt(request.getSession().getAttribute("startSec").toString());

            int numberQuiz = Integer.parseInt(request.getSession().getAttribute("numberQuiz").toString());
            int totalTime = numberQuiz * 5 - (currentMin * 60 + currentSec);
            //calculate total time by number quiz then set attribute for this
            request.getSession().setAttribute("totalTime", totalTime);//so giay
            //check current quiz is lasr quiz or not
            if (new QuestionDAO().getAll().size() == Integer.parseInt(request.getSession().getAttribute("index").toString())
                    || Integer.parseInt(request.getSession().getAttribute("index").toString()) == Integer.parseInt(request.getSession().getAttribute("numberQuiz").toString())) {
                request.getSession().setAttribute("index", -1); //set cau cuoi 
            }
        } else if (request.getParameter("btnNumberQuiz") != null) {//button input number quiz after login or start another quiz 
            int size = new QuestionDAO().getAll().size();
            int numberQuiz = Integer.parseInt(request.getParameter("txtNumberQuiz"));
            if (numberQuiz > 0 && numberQuiz <= size) {//check number quiz in database is enought or not
                request.getSession().setAttribute("numberQuiz", numberQuiz);
                request.getSession().removeAttribute("numberQuizFail");
                request.getSession().setAttribute("index", 0);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String a = sdf.format(d);
                String min = a.split(":")[1];
                String sec = a.split(":")[2];

                request.getSession().setAttribute("startMin", min);
                request.getSession().setAttribute("startSec", sec);

                int totalTime = numberQuiz * 5;
                int minutes = (int) Math.floor((totalTime % (60 * 60)) / 60);
                int seconds = (int) Math.floor(totalTime % 60);

                request.getSession().setAttribute("totalTime", totalTime);//so giay
                request.getSession().setAttribute("finishMin", min + minutes);// min ket thuc
                request.getSession().setAttribute("finishSec", sec + seconds);// sec ket thuc

            } else {
                String numberQuizFail = "Number quiz in database is only " + size + "!";
                request.getSession().setAttribute("numberQuizFail", numberQuizFail);
                request.getSession().setAttribute("numberQuiz", -1);
                request.getSession().setAttribute("index", 0);
            }

        }
        if (request.getParameter("timeout") != null) {
            request.getSession().setAttribute("index", -1);
        }
        request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
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
        request.getRequestDispatcher("TakeQuiz.jsp").forward(request, response);
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TakeQuizController.class.getName()).log(Level.SEVERE, null, ex);
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
