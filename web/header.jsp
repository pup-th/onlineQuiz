<%-- 
    Document   : header
    Created on : Sep 27, 2020, 1:40:10 PM
    Author     : HoangPhuc
--%>

<%@page import="DAO.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%
        String username = null;
        //get role from username to display each navigation bar
        int role = -1;
        try {
            if (request.getSession().getAttribute("user") != null) {
                username = request.getSession().getAttribute("user").toString();
                role = new UserDAO().getUserByUsername(username).getRole();
            }

        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    %>

    <style>
        .body{
            background-image: url("images/menu_bg.gif");
            background-repeat: no-repeat;
            background-size: 95%;
            padding: 1px;;
            background-position: center;
        }
        .top{
            background-image: url("images/top_box.gif");
            background-repeat: no-repeat;
            background-size: 100%; 
        }
        .nav-link{
            color: #856404;
        }
    </style>
    <script>
        //check click another navbar when in test
        function checkLoadAnotherNav() {
            if (<%=request.getSession().getAttribute("numberQuiz") != null%>) {
                if (confirm("Do you want to exit this test?")) {
                    return true;
                }
                return false;
            }
        }
        //dont load again takequiz page when in test
        function checkTakeQuiz() {
            if (<%=request.getSession().getAttribute("numberQuiz") != null%>) {
                return false;
            }
        }
        
    </script>
    <body> 

        <div class="top" ></div>
        <div class="body" >
            <nav class="navbar navbar-expand-sm  "> 
                <div class="collapse navbar-collapse" id="collapsibleNavbar">
                    <ul class="navbar-nav" >
                        <li class="nav-item"> 
                            <a onclick="return checkLoadAnotherNav()" class="nav-link" id="homepageNav" href="loginController" >Home</a> 
                        </li>
                        <li class="nav-item">
                            <a onclick="return checkTakeQuiz()"  class="nav-link" id="takequizNav" href="TakeQuizController">Take quiz</a>
                        </li> 
                        <c:if test="<%=role == 0%>"> <!--0 la giao vien-->
                            <li class="nav-item">
                                <a onclick="return checkLoadAnotherNav()" class="nav-link" id="makequizNav" href="MakeQuiz">Make quiz</a>
                            </li>  
                            <li class="nav-item">
                                <a onclick="return checkLoadAnotherNav()" class="nav-link" id="managequizNav" href="ManageQuizController">Manager quiz</a>
                            </li> 
                        </c:if>
                        <c:if test="<%=username != null%>">
                            <li class="nav-item">
                                <form action="loginController" method="POST">
                                    <style>
                                        .logout{
                                            border: none;
                                            color: #856404;
                                            background: none;
                                            padding-top: 9px;
                                        }
                                    </style>
                                    <input onclick="return checkLoadAnotherNav()" type="submit" class="logout" value="Logout" name="btnLogout">
                                </form>
                            </li>
                        </c:if>
                    </ul>
                </div>  
            </nav>
        </div>
    </body>
</html>
