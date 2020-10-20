/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HoangPhuc
 */
public class UserDAO {

    public Connection conn;

    public UserDAO() {
        conn = new DBConnection().getConnection();
    }

    public ArrayList<Users> getAll() throws SQLException {
        ArrayList<Users> listUser = new ArrayList<>();
        String query = "SELECT * FROM `users` WHERE 1";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            Users u = new Users(rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("role"),
                    rs.getString("email"));
            listUser.add(u);
        }
        return listUser;
    }

    public Users checkLogin(String username, String pass) throws SQLException {
        Users u = null;
        String query = "SELECT * FROM `users` WHERE `username` = ? AND `password` = MD5(?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, pass);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            u = new Users(rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("role"),
                    rs.getString("email"));
        }
        return u;
    }

    public boolean register(String username, String pass, int role, String email) throws SQLException { 
        if(getUserByUsername(username) != null){//check duplicate
            return false;
        }
        String query = "INSERT INTO `users`(`username`, `password`, `role`, `email`) VALUES (? , MD5(?), ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, username);
        pst.setString(2, pass);
        pst.setInt(3, role);
        pst.setString(4, email);
        if (pst.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Users getUserByUsername(String username) throws SQLException {
        for (Users users : getAll()) {
            if (users.getUsername().equals(username)) {
                return users;
            }
        }
        return null;
    }

}
