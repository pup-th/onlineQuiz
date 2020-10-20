<%-- 
    Document   : MakeQuiz
    Created on : Sep 28, 2020, 8:00:22 PM
    Author     : HoangPhuc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <script>
            //check duplicate option in database
            //check in pare
            function checkDuplicate() {
                var option = [];
                option.push("empty");
                option.push(document.forms["inputQuiz"]["txtOp1"].value);
                option.push(document.forms["inputQuiz"]["txtOp2"].value);
                option.push(document.forms["inputQuiz"]["txtOp3"].value);
                option.push(document.forms["inputQuiz"]["txtOp4"].value);
                var i;
                var j;
                for (i = 1; i < 5; i++) {
                    for (j = i + 1; j < 5; j++) {
                        if (option[i] == option[j]) {
                            document.getElementById("dup").innerHTML = "Duplicate in option " + i + " and " + j;
                            return false;
                        }
                    }
                }
                return true;
            }

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
        .form{
            text-align: center;
            width: 40%;
            margin: 5% auto; 
            background: #fff;
            border-radius: 20px;
        }  
    </style>
    <body> 
        <div class="form">
            <%@include file="header.jsp" %>
            <div>
                <div class="input"> 
                    <div>
                        <h3 style=" display: inline-block">Make Quiz</h3>
                    </div>
                    <form action="MakeQuiz" method="post" name="inputQuiz" onsubmit="return checkDuplicate();">
                        <div style= "padding: 20px;">
                            <table>
                                <tr>
                                    <td>Question:</td>
                                    <td><input type="text" class="question" name="txtQuestion" required></td>
                                </tr>
                                <tr>
                                    <td>Option 1</td>
                                    <td><input type="text" class="option" name="txtOp1" required></td>
                                </tr>
                                <tr>
                                    <td>Option 2</td>
                                    <td><input type="text" class="option" name="txtOp2" required></td>
                                </tr>
                                <tr>
                                    <td>Option 3</td>
                                    <td><input type="text" class="option" name="txtOp3" required></td>
                                </tr>
                                <tr>
                                    <td>Option 4</td>
                                    <td><input type="text" class="option" name="txtOp4" required></td>
                                </tr> 
                                <tr>
                                    <td>Answer: </td>
                                    <td><input type="radio" name="radOption" value="1" required> Option 1
                                        <input type="radio" name="radOption" value="2" required> Option 2
                                        <input type="radio" name="radOption" value="3" required> Option 3
                                        <input type="radio" name="radOption" value="4" required> Option 4  
                                    </td>
                                </tr> 
                            </table> 
                        </div> 
                        <%                  
                            //show that quiz is added success or not
                            String addQuiz = "";
                            if (request.getSession().getAttribute("addQuiz") != null) {
                                addQuiz = request.getSession().getAttribute("addQuiz").toString();
                                if (addQuiz.equals("true")) {
                                    addQuiz = "<p style='color:#007bff;'>Add quiz successfully</p>";
                                } else {
                                    addQuiz = "<p style='color:red;'>Add quiz fail</p>";
                                }
                                request.getSession().removeAttribute("addQuiz");
                            }
                        %>
                        <%=addQuiz%>
                        <p id="dup" style="color:red"></p>

                        <input style="margin-bottom:10px" type="submit" value="Save" class="btn btn-sm btn-primary" name="btnSave">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
