/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Question;
import Models.Users;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoangPhuc
 */
public class QuestionDAO {

    public Connection conn;

    public QuestionDAO() {
        conn = new DBConnection().getConnection();
    }

    public ArrayList<Question> getAll() throws SQLException {
        ArrayList<Question> listQuestion = new ArrayList<>();
        String query = "SELECT * FROM `question` WHERE 1";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Question q = new Question(rs.getInt("id"),
                    rs.getString("content"),
                    rs.getString("ans"),
                    rs.getDate("date"),
                    rs.getString("username"));
            listQuestion.add(q);
        }
        return listQuestion;
    }
    public Question getAll(String content) throws SQLException { 
        String query = "SELECT * FROM `question` WHERE `content`= ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, content);
        ResultSet rs = pst.executeQuery();
        Question q = null;
        while (rs.next()) {
            q = new Question(rs.getInt("id"),
                    rs.getString("content"),
                    rs.getString("ans"),
                    rs.getDate("date"),
                    rs.getString("username")); 
        }
        return q;
    } 
    
    public ArrayList<Question> getRandomQuiz() throws SQLException{
        ArrayList<Question> allQuestion = new ArrayList<>();
        for (Question q : getAll()) {
            allQuestion.add(q);
        }
        Collections.shuffle(allQuestion);
        return allQuestion;
    }
    public ArrayList<Question> getNumberQuiz(String numberQuiz) throws SQLException{ 
        ArrayList<Question> listQuestion = new ArrayList<>();
        ArrayList<Question> allQuestion = new ArrayList<>();
        
        for (Question q : getAll()) {
            allQuestion.add(q);
        }
        
        if(Integer.parseInt(numberQuiz) > allQuestion.size() || Integer.parseInt(numberQuiz)<= 0){
            return null;
        }else{
            Collections.shuffle(allQuestion);
            int i = 0;
            for (Question q : allQuestion) {
                listQuestion.add(q);
                i++;
                if(Integer.parseInt(numberQuiz) == i){
                    break;
                }
            }
        } 
        return listQuestion;
    }
    
    public boolean addQuiz(String content, String anw, Date date, String username){
        try {
            String query = "INSERT INTO `question`(`content`, `ans`, `date`, `username`) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, content);
            pst.setString(2, anw);
            pst.setDate(3, date);
            pst.setString(4, username);
            if (pst.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuestionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
