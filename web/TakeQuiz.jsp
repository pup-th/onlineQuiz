<%-- 
    Document   : TakeQuiz
    Created on : Sep 27, 2020, 1:47:01 PM
    Author     : HoangPhuc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.LocalTime"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="DAO.QuestionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        //check login before take quiz
        ArrayList<Question> listQuestion = new ArrayList<Question>();
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        int count = -1;         //quiz index in list question
        int numberQuiz = -1;    //number question user input
        double correct = -1;    //number correct answer
        String cString = "";    //show final result after testing
        String currentTime = "";//get current time to show below
        String usernameTakeQuiz = "";                   //get username to display in screen
        DecimalFormat df = new DecimalFormat("#.##");   //format current date then parse to sqlDate

        int totalTime = -1; //total second to do test

        String showTime = "";
        if (request.getSession().getAttribute("numberQuiz") != null) {
            numberQuiz = Integer.parseInt(request.getSession().getAttribute("numberQuiz").toString());
            //during test
            if (numberQuiz != -1) {
                //time over
                if (request.getParameter("timeout") != null) {
                    request.getSession().setAttribute("index", -1);
                }
                //question indes
                count = Integer.parseInt(request.getSession().getAttribute("index").toString());
                //final quiz
                if (count == -1) { 
                    request.getSession().removeAttribute("numberQuiz");
                    request.getSession().removeAttribute("numberQuizFail");
                }
                //get all quiz in database
                QuestionDAO qDAO = new QuestionDAO();
                listQuestion = qDAO.getAll();
                //calculate correct answer
                correct = Double.parseDouble(request.getSession().getAttribute("correct").toString()) / numberQuiz * 10;
                cString = (df.format(correct)) + " (" + (int) (correct * 10) + "%)";
                cString += (correct * 10 >= 50) ? " - Passed" : " - Fail";
                usernameTakeQuiz = request.getSession().getAttribute("user").toString();
                //get test time
                totalTime = Integer.parseInt(request.getSession().getAttribute("totalTime").toString());
                //time over
                if (totalTime < 0) {
                    request.getRequestDispatcher("?timeout=1").forward(request, response);
                }
                //calculate time for display
                int minutes = (int) Math.floor((totalTime % (60 * 60)) / 60);
                int seconds = (int) Math.floor(totalTime % 60);
                showTime = minutes + ":" + seconds;
            }
        }
        //input number question over number quiz in database
        String fail = "";
        if (request.getSession().getAttribute("numberQuizFail") != null) {
            fail = request.getSession().getAttribute("numberQuizFail").toString();
        }

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            //valid input number quiz
            function validate()
            {
                var number = document.forms["inputNumberQuiz"]["txtNumberQuiz"];
                var reg = /\D+/;

                if (reg.test(number.value) == true) {
                    document.getElementById("number_error").innerHTML = "Please input positive number and number must greater than 0!";
                    document.getElementById("checkDB").innerHTML = "";
                    return false;
                } else {
                    document.getElementById("number_error").innerHTML = "";
                }
                return true;
            }
        </script>  
        <script>
            //loop to dispaly time in screen(cant manipulate with this number)
            var t = <%=totalTime%>;
            var x = setInterval(function () {
                t = t - 1;
                var minutes = Math.floor((t % (60 * 60)) / 60);
                var seconds = Math.floor(t % 60);
                document.getElementById("timing").innerHTML = minutes + ":" + seconds;
                if (t <= 0) {
                    clearInterval(x);
                    window.location.href = "?timeout=1";
                }
            }, 1000);
        </script> 
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
        .all{
            padding: 10px 10% 0px 10%;
        }
        .content{ 
            margin-bottom: 20px;
        } 
        .answer{
            margin: 5px 5px 10px 50px ;
            text-align: left;
            padding: 0px 0px 0px 10%;
        }
        .date{
            float: right;
        }
        .form{
            width: 40%;
            margin: 5% auto;
            background: #fff;
            border-radius: 20px;
        }
        .takequiz{
            margin: 5% auto;
            text-align: center;
            padding: 0px 0px 5% 0px;
        }
    </style>
    <body> 
        <div class="form">
            <%@include file="header.jsp" %>
            <div class="takequiz">
                <c:choose>
                    <c:when test="<%=numberQuiz == -1%>"> 
                        <form onsubmit="return validate()" action="TakeQuizController" method="POST" id="inputNumberQuiz" name="inputNumberQuiz" >
                            <p>Welcome <%=usernameTakeQuiz%></p><br>
                            <p>Enter number of question:</p>
                            <input type="text" id="txtNumberQuiz" name="txtNumberQuiz" autofocus required><br>
                            <span id="number_error" style="color: red"></span> 
                            <p id="checkDB" style="color: red"><%=fail%> </p>  
                            <input type="submit" class="btn btn-sm btn-primary"  name="btnNumberQuiz" value="Start">
                        </form>
                    </c:when>
                    <c:when test="<%=numberQuiz != -1%>">
                        <div class="all"> 
                            <div class="con"> 
                                <div class="content">
                                    <!--still have question-->
                                    <c:if test="<%=count != -1%>">
                                        <form action="TakeQuizController" method="POST" >
                                            <div style="float:left">
                                                <h5>
                                                    Welcome <p style="color:#007bff; display: inline"><%=usernameTakeQuiz%></p>
                                                </h5>  
                                            </div> 
                                            <div style="float: right;">
                                                <p style="display: inline">Time remaining:</p><br>
                                                <p id="timing"></p>
                                            </div>  
                                            <br>
                                            <div>
                                                <input type="text" style="border: none; float:left" value="<%=listQuestion.get(count).getContent()%>" name="txtContent"><br>                                                
                                            </div>  
                                            <br>
                                            <%
                                                int c = 0;
                                            %>
                                            <div class="answer" >
                                                <c:forEach var="ans" items="<%=listQuestion.get(count).getListAnswer().keySet()%>">
                                                    <input type="radio" id="<%=c%>" style="float:left" name="txta" value="${ans}" required>  
                                                    <label for="<%=c%>">${ans}</label><br>
                                                    <%
                                                        c += 1;
                                                    %>
                                                </c:forEach>
                                            </div>  
                                            <input style="float:right" class="btn btn-sm btn-primary"  type="submit" value="Next" name="btnNext">
                                        </form>
                                    </c:if>
                                    <c:if test="<%=count == -1%>">
                                        <form action="TakeQuizController" method="POST">
                                            <h3>Result</h3> 
                                            <c:if test="<%=correct * 10 >= 50%>">
                                                Your core: <p style="color: #007bff"><%=cString%></p>
                                            </c:if>
                                            <c:if test="<%=correct * 10 < 50%>">
                                                Your core: <p style="color: red"><%=cString%></p>
                                            </c:if>
                                            <p>Take another test?</p>
                                            <input type="submit" class="btn btn-sm btn-primary"  name="btnStartAnother" value="Start">
                                        </form>
                                    </c:if>
                                </div>  
                            </div> 
                        </div>
                    </c:when>
                </c:choose> 
            </div>
        </div> 
    </body>
</html>
