<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script>
            function validate()
            {
                var name = document.forms["inputNumberQuiz"]["txtNumberQuiz"];
                var reg = /\D+/;
                if (reg.test(name.value) == true) {
                    document.getElementById("number_error").innerHTML = "Please input number here!";
                    return false;
                } else {
                    document.getElementById("number_error").innerHTML = "";
                }
                return true;
            }
        </script>  
        <style>
            form{
                text-align: center;
                margin: 5% auto;
            }
        </style>
    </head> 
    <body > 
        <form action="#" method="post" id="inputNumberQuiz" name="inputNumberQuiz" onsubmit="return validate()" >
            <p>Welcome </p><br>
            <p>Enter number of question:</p>
            <input type="text" name="txtNumberQuiz" autofocus required><br>
            <span id="number_error" style="color: red"></span> 
            <br><br>
            <input type="submit" class="btn btn-sm btn-primary"  name="btnNumberQuiz" value="Start">
        </form> 
    </body> 
</html> 
