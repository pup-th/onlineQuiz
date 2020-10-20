/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author HoangPhuc
 */
public class Question {
    private int id;
    private String content;
    private String ans;
    private Date date;
    private String username;
    private HashMap<String, Boolean> an;

    public HashMap<String, Boolean> getListAnswer (){
        HashMap<String, Boolean> listAn = new HashMap<String, Boolean>();
        
        for (String i : this.ans.split("<br>")) {
            if(i.startsWith("[ans]")){
                listAn.put(i.substring(5), true);
            }else{
                listAn.put(i, false);
            }    
        }
        return listAn;
    }
    public Question() {
    }

    public Question(int id, String content, String ans, Date date, String username) {
        this.id = id;
        this.content = content;
        this.ans = ans;
        this.date = date;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

      
}
