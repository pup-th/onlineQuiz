<%-- 
    Document   : register
    Created on : Oct 5, 2020, 11:07:07 PM
    Author     : HoangPhuc
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css"> 
        <title>JSP Page</title> 
        <script>
            function validate()
            {
                var name = document.forms["formRegister"]["txtUsernameRe"];
                var password = document.forms["formRegister"]["txtPasswordRe"];
                var email = document.forms["formRegister"]["txtEmailRe"];
                var flag = false;
                //check username empty
                if (name.value.trim() == "") {
                    
                    document.getElementById("username_error").innerHTML = "Please input username here!";
                    flag = true;
                } else {
                    document.getElementById("username_error").innerHTML = "";
                    flag = false;
                }
                //check strong pass
                var regpass = /^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$/;
                if (password.value != "" && regpass.test(password.value.trim()) == false) {
                    document.getElementById("password_error").innerHTML = "Password must have uppercase,<br> lowercase, number, special character<br> and min lenght is 8 characters";
                    flag = true;
                }
                else if(password.value == ""){
                    document.getElementById("password_error").innerHTML = "Please enter password here!";
                    flag = true;   
                }else {
                    document.getElementById("password_error").innerHTML = "";
                    flag = false;
                }
                //check validate email
                var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
                if (reg.test(email.value.trim()) == false || email.value.trim() == "") {
                    document.getElementById("email_error").innerHTML = "Please input email here!<br>Ex:a@gmail.com";
                    flag = true;
                } else {
                    document.getElementById("email_error").innerHTML = "";
                    flag = false;
                }
                if (flag == true) {
                    return false;
                } else {
                    return true;
                }
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
            width: 40%;
            margin: 5% auto; 
            background: #fff;
            padding-bottom: 5%;
            border-radius: 20px;
        } 
        table{
            margin: auto; 
        }
        h1{
            text-align: center;
        }
        .username_error, .email_error, .password_error{
            font-style: 10px;
        }
    </style>
    <body>
        <%
            //get fail register
            boolean flag = false;
            if (request.getSession().getAttribute("registerFail") != null) {
                flag = true;
            }
        %>
        <div class="form" >
            <%@include file="header.jsp" %> 
            <div class="login">
                <h1>Register</h1>
                <form action="loginController" method="post" id="formRegister" name="formRegister" onsubmit="return validate()">
                    <div class="register">
                        <div class="fill">
                            <table>
                                <tr>
                                    <td> Username: </td>
                                    <td> 
                                        <Input type="text" name="txtUsernameRe" autofocus><br>
                                    </td>
                                </tr> 
                                <tr>
                                    <td></td>
                                    <td><p style="color:red;font-size: 14px" id="username_error"></p></td>
                                </tr>
                                <tr>
                                    <td> Password: </td>
                                    <td> 
                                        <Input type="password" name="txtPasswordRe" > <br> 
                                    </td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td><p style="color:red;font-size: 14px" id="password_error"></p></td> 
                                </tr>
                                <tr>
                                    <td> Role: </td>
                                    <td> <select name="txtRoleRe">
                                            <option value="0">Teacher</option>
                                            <option value="1">Student</option>
                                        </select> </td>
                                </tr>
                                <tr>
                                    <td></td> 
                                    <td> <p style="color:red;font-size: 14px" id=""></p></td> 
                                </tr>
                                <tr>
                                    <td> Email: </td>
                                    <td> 
                                        <Input type="text" name="txtEmailRe" > <br>
                                    </td>
                                </tr>
                                <tr>
                                    <td></td> 
                                    <td><p style="color:red;font-size: 14px" id="email_error"></p></td> 
                                </tr>
                                <tr>
                                    <td>  </td>
                                    <td> <input type="submit" class="btn btn-sm btn-primary" name="btnRegister" value="Register"></td>
                                </tr>
                            </table> 
                            <c:if test="<%=flag%>">
                                <p style="color:red">Register fail!</p>
                            </c:if>
                        </div>
                    </div>
                </form> 
            </div>  
        </div>
    </body>

</html>

