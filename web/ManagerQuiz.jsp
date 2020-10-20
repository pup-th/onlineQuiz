<%-- 
    Document   : ManagerQuiz
    Created on : Sep 27, 2020, 1:46:06 PM
    Author     : HoangPhuc
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%> 
<%@page import="Models.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.QuestionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <title>JSP Page</title>
    </head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <style>
        body{
            height: 100%;
            background-image: url("images/bg.jpg");
            text-align: center;
            color: #2A577E;
            font-family: sans-serif;
        } 
        .bodyMana{
            margin: 5% auto;
            width: 40%;
            background: #fff; 
            border-radius: 20px;  
        }  
    </style>
    <body> 
        <div class="bodyMana"> 
            <%
                //get all quiz in database
                //then display below
                QuestionDAO qDAO = new QuestionDAO();
                ArrayList<Question> listQuestion = new ArrayList<Question>();
                listQuestion = qDAO.getAll(); 
            %>
            <%@include file="header.jsp" %>
            <div class="mana" style="margin: 30px;">
                <div>
                    <h3>Number of question:  <p style="color: #007bff;display: inline-block"><%=qDAO.getAll().size()%></p></h3>
                </div>
                <div>
                    <div class="row" style="color: #007bff">
                        <div class="col-6"> 
                            <p style="float: left">Question</p>
                        </div>
                        <div class="col-6"> 
                            <p style="float: right">Date Create</p>                          
                        </div>
                    </div> 
                    <c:forEach var="q" items="<%=listQuestion%>">
                        <div class="row">
                            <div class="col-6">
                                <p style="float: left">${q.getContent()}</p>
                            </div>
                            <div class="col-6"> 
                                <p style="float: right">${q.getDate()}</p>                            
                            </div>
                        </div> 
                    </c:forEach>
                </div>
            </div>
        </div> 
    </body>
</html>
