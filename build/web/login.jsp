<%-- 
    Document   : login
    Created on : Sep 26, 2020, 7:38:09 PM
    Author     : HoangPhuc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <link rel="stylesheet" href="https://code.jquery.com/jquery-3.5.1.min.js"> 
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
        .form{
            width: 40%;
            margin: 5% auto; 
            background: #fff;
        }
        .login{
            margin-top: 1%;
            text-align: center;
            padding: 0px 0px 5% 0px;
        }
        .body{
            margin-top: 10px;
        }
        .loginhead{
            text-align: left;
            color: #007bff;
            font-weight: 500;
        }
    </style>
    <body>
        <%
            String userLogin = "";
            //get fail login
            String fail = null;
            if (request.getSession().getAttribute("fail") != null) {
                fail = request.getSession().getAttribute("fail").toString();
            }
            //get username to show below
            if (request.getSession().getAttribute("user") != null) {
                userLogin = request.getSession().getAttribute("user").toString();
            } 
        %>
        <div class="form" style="border-radius: 20px">
            <%@include file="header.jsp" %>
            <c:if test="<%=userLogin.isEmpty()%>"> 
                <div class="login">
                    <h1>Login</h1>
                    <br>
                    <form action="loginController" method="post" id="formInput">
                        Username: <Input type="text" name="txtUsername" autofocus  ><br><br>
                        Password: <Input type="password" name="txtPassword" ><br><br>
                        <c:if test="<%=fail != null%>">
                            <p style="color:red">Login fail! Wrong Username or Password</p>
                        </c:if>
                        <input type="submit" class="btn btn-sm btn-primary" name="btnSubmit" value="Login">
                        <input type="submit" style="border: none; background: #fff;color: #0069d9" name="btnRe" value="Register"> 
                    </form>
                </div>
            </c:if>
            <c:if test="<%=!userLogin.isEmpty()%>">
                <div class="login" style="height:250px;">
                    <div >
                        <h5 style="text-align: center;">
                            Welcome <p style="color:#007bff; display: inline"><%=username%></p> 
                        </h5> 
                    </div>
                </div> 
            </c:if>
        </div>
    </body> 
</html>
