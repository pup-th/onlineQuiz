package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.time.LocalTime;
import java.util.Date;
import java.text.DecimalFormat;
import DAO.QuestionDAO;
import java.util.ArrayList;
import Models.Question;
import DAO.UserDAO;

public final class TakeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_choose;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_when_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_choose = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_when_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_choose.release();
    _jspx_tagPool_c_when_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");

        ArrayList<Question> listQuestion = new ArrayList<Question>();
        if (request.getSession().getAttribute("user") == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        int count = -1;
        int numberQuiz = -1;
        double correct = -1;
        String cString = "";
        String currentTime = "";
        String usernameTakeQuiz = "";
        DecimalFormat df = new DecimalFormat("#.##");

        int totalTime = -1;
        int finishMin = -1;
        int finishSec = -1;
        String showTime = "";
        if (request.getSession().getAttribute("numberQuiz") != null) {
            numberQuiz = Integer.parseInt(request.getSession().getAttribute("numberQuiz").toString());
            if (numberQuiz != -1) {
                if(request.getParameter("timeout") != null){
                    request.getSession().setAttribute("index", -1);
                }
                count = Integer.parseInt(request.getSession().getAttribute("index").toString());
                QuestionDAO qDAO = new QuestionDAO();
                listQuestion = qDAO.getAll();
                correct = Double.parseDouble(request.getSession().getAttribute("correct").toString()) / numberQuiz * 10;
                cString = (df.format(correct)) + " (" + (int) (correct * 10) + "%)";
                cString += (correct * 10 >= 50) ? " - Passed" : " - Fail";
                usernameTakeQuiz = request.getSession().getAttribute("user").toString();

                totalTime = Integer.parseInt(request.getSession().getAttribute("totalTime").toString());

                if (totalTime < 0) {
                    request.getRequestDispatcher("?timeout=1").forward(request, response);
                }
                finishMin = Integer.parseInt(request.getSession().getAttribute("finishMin").toString());
                finishSec = Integer.parseInt(request.getSession().getAttribute("finishSec").toString());

                int minutes = (int) Math.floor((totalTime % (60 * 60)) / 60);
                int seconds = (int) Math.floor(totalTime % 60);

                showTime = minutes + ":" + seconds;
            }
        }
        String fail = "";
        if (request.getSession().getAttribute("numberQuizFail") != null) {
            fail = request.getSession().getAttribute("numberQuizFail").toString();
        }

    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script>\n");
      out.write("            function validate()\n");
      out.write("            {\n");
      out.write("                var number = document.forms[\"inputNumberQuiz\"][\"txtNumberQuiz\"];\n");
      out.write("                var reg = /\\D+/;\n");
      out.write("\n");
      out.write("                if (reg.test(number.value) == true) {\n");
      out.write("                    document.getElementById(\"number_error\").innerHTML = \"Please input positive number and number must greater than 0!\";\n");
      out.write("                    document.getElementById(\"checkDB\").innerHTML = \"\";\n");
      out.write("                    return false;\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"number_error\").innerHTML = \"\";\n");
      out.write("                }\n");
      out.write("                return true;\n");
      out.write("            }\n");
      out.write("        </script>  \n");
      out.write("        <script>\n");
      out.write("            var t = ");
      out.print(totalTime);
      out.write(";\n");
      out.write("            var x = setInterval(function () {\n");
      out.write("                t = t - 1;\n");
      out.write("                var minutes = Math.floor((t % (60 * 60)) / 60);\n");
      out.write("                var seconds = Math.floor(t % 60);\n");
      out.write("                document.getElementById(\"timing\").innerHTML = minutes + \":\" + seconds;\n");
      out.write("                if (t <= 0) {\n");
      out.write("                    clearInterval(x);\n");
      out.write("                    window.location.href = \"?timeout=1\";\n");
      out.write("                }\n");
      out.write("            }, 1000);\n");
      out.write("        </script> \n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            height: 100%;\n");
      out.write("            background-image: url(\"images/bg.jpg\");\n");
      out.write("            text-align: center;\n");
      out.write("            color: #2A577E;\n");
      out.write("            font-family: sans-serif;\n");
      out.write("        }\n");
      out.write("        .all{\n");
      out.write("            padding: 10px 10% 0px 10%;\n");
      out.write("        }\n");
      out.write("        .content{ \n");
      out.write("            margin-bottom: 20px;\n");
      out.write("        } \n");
      out.write("        .answer{\n");
      out.write("            margin: 5px 5px 10px 50px ;\n");
      out.write("            text-align: left;\n");
      out.write("            padding: 0px 0px 0px 10%;\n");
      out.write("        }\n");
      out.write("        .date{\n");
      out.write("            float: right;\n");
      out.write("        }\n");
      out.write("        .form{\n");
      out.write("            width: 40%;\n");
      out.write("            margin: 5% auto;\n");
      out.write("            background: #fff;\n");
      out.write("            border-radius: 20px;\n");
      out.write("        }\n");
      out.write("        .takequiz{\n");
      out.write("            margin: 5% auto;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 0px 0px 5% 0px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body> \n");
      out.write("        <div class=\"form\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    ");

        String username = null; 
        int role = -1; 
        try {
            if (request.getSession().getAttribute("user") != null) {
                username = request.getSession().getAttribute("user").toString();
                role = new UserDAO().getUserByUsername(username).getRole();
            } 
 
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    
      out.write("\n");
      out.write("     \n");
      out.write("    <style>\n");
      out.write("        .body{\n");
      out.write("            background-image: url(\"images/menu_bg.gif\");\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: 95%;\n");
      out.write("            padding: 1px;;\n");
      out.write("            background-position: center;\n");
      out.write("        }\n");
      out.write("        .top{\n");
      out.write("            background-image: url(\"images/top_box.gif\");\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            background-size: 100%; \n");
      out.write("        }\n");
      out.write("        .nav-link{\n");
      out.write("            color: #856404;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body> \n");
      out.write("\n");
      out.write("        <div class=\"top\" ></div>\n");
      out.write("        <div class=\"body\" >\n");
      out.write("            <nav class=\"navbar navbar-expand-sm  \"> \n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("                    <ul class=\"navbar-nav\" >\n");
      out.write("                        <li class=\"nav-item\"> \n");
      out.write("                            <a class=\"nav-link\" id=\"homepageNav\" href=\"login.jsp\" >Home</a> \n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" id=\"takequizNav\" href=\"TakeQuiz.jsp\">Take quiz</a>\n");
      out.write("                        </li> \n");
      out.write("                        ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_0.setPageContext(_jspx_page_context);
      _jspx_th_c_if_0.setParent(null);
      _jspx_th_c_if_0.setTest(role == 0);
      int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
      if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" <!--0 la giao vien-->\n");
          out.write("                            <li class=\"nav-item\">\n");
          out.write("                                <a class=\"nav-link\" id=\"makequizNav\" href=\"MakeQuiz.jsp\">Make quiz</a>\n");
          out.write("                            </li>  \n");
          out.write("                            <li class=\"nav-item\">\n");
          out.write("                                <a class=\"nav-link\" id=\"managequizNav\" href=\"ManagerQuiz.jsp\">Manager quiz</a>\n");
          out.write("                            </li> \n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      out.write("\n");
      out.write("                        ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(username != null);
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <li class=\"nav-item\">\n");
          out.write("                                <form action=\"loginController\" method=\"POST\">\n");
          out.write("                                    <style>\n");
          out.write("                                        .logout{\n");
          out.write("                                            border: none;\n");
          out.write("                                            color: #856404;\n");
          out.write("                                            background: none;\n");
          out.write("                                            padding-top: 9px;\n");
          out.write("                                        }\n");
          out.write("                                    </style>\n");
          out.write("                                    <input type=\"submit\" class=\"logout\" value=\"Logout\" name=\"btnLogout\">\n");
          out.write("                                </form>\n");
          out.write("                            </li>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>  \n");
      out.write("            </nav>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("            <div class=\"takequiz\">\n");
      out.write("                ");
      //  c:choose
      org.apache.taglibs.standard.tag.common.core.ChooseTag _jspx_th_c_choose_0 = (org.apache.taglibs.standard.tag.common.core.ChooseTag) _jspx_tagPool_c_choose.get(org.apache.taglibs.standard.tag.common.core.ChooseTag.class);
      _jspx_th_c_choose_0.setPageContext(_jspx_page_context);
      _jspx_th_c_choose_0.setParent(null);
      int _jspx_eval_c_choose_0 = _jspx_th_c_choose_0.doStartTag();
      if (_jspx_eval_c_choose_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                    ");
          //  c:when
          org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_0 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
          _jspx_th_c_when_0.setPageContext(_jspx_page_context);
          _jspx_th_c_when_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
          _jspx_th_c_when_0.setTest(numberQuiz == -1);
          int _jspx_eval_c_when_0 = _jspx_th_c_when_0.doStartTag();
          if (_jspx_eval_c_when_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write(" \n");
              out.write("                        <form onsubmit=\"return validate()\" action=\"TakeQuizController\" method=\"POST\" id=\"inputNumberQuiz\" name=\"inputNumberQuiz\" >\n");
              out.write("                            <p>Welcome ");
              out.print(usernameTakeQuiz);
              out.write("</p><br>\n");
              out.write("                            <p>Enter number of question:</p>\n");
              out.write("                            <input type=\"text\" id=\"txtNumberQuiz\" name=\"txtNumberQuiz\" autofocus required><br>\n");
              out.write("                            <span id=\"number_error\" style=\"color: red\"></span> \n");
              out.write("                            <p id=\"checkDB\" style=\"color: red\">");
              out.print(fail);
              out.write(" </p>  \n");
              out.write("                            <input type=\"submit\" class=\"btn btn-sm btn-primary\"  name=\"btnNumberQuiz\" value=\"Start\">\n");
              out.write("                        </form>\n");
              out.write("                    ");
              int evalDoAfterBody = _jspx_th_c_when_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_when_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
            return;
          }
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_0);
          out.write("\n");
          out.write("                    ");
          //  c:when
          org.apache.taglibs.standard.tag.rt.core.WhenTag _jspx_th_c_when_1 = (org.apache.taglibs.standard.tag.rt.core.WhenTag) _jspx_tagPool_c_when_test.get(org.apache.taglibs.standard.tag.rt.core.WhenTag.class);
          _jspx_th_c_when_1.setPageContext(_jspx_page_context);
          _jspx_th_c_when_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_choose_0);
          _jspx_th_c_when_1.setTest(numberQuiz != -1);
          int _jspx_eval_c_when_1 = _jspx_th_c_when_1.doStartTag();
          if (_jspx_eval_c_when_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\n");
              out.write("                        <div class=\"all\"> \n");
              out.write("                            <div class=\"con\"> \n");
              out.write("                                <div class=\"content\">\n");
              out.write("                                    ");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_2.setPageContext(_jspx_page_context);
              _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
              _jspx_th_c_if_2.setTest(count != -1);
              int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
              if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("                                        <form action=\"TakeQuizController\" method=\"POST\" >\n");
                  out.write("                                            <div style=\"float:left\">\n");
                  out.write("                                                <h5>\n");
                  out.write("                                                    Welcome <p style=\"color:#007bff; display: inline\">");
                  out.print(usernameTakeQuiz);
                  out.write("</p>\n");
                  out.write("                                                </h5>  \n");
                  out.write("                                            </div> \n");
                  out.write("                                            <div style=\"float: right;\">\n");
                  out.write("                                                <p style=\"display: inline\">Time remaining:</p><br>\n");
                  out.write("                                                <p id=\"timing\"></p>\n");
                  out.write("                                            </div>  \n");
                  out.write("                                            <br>\n");
                  out.write("                                            <div>\n");
                  out.write("                                                <input type=\"text\" style=\"border: none; float:left\" value=\"");
                  out.print(listQuestion.get(count).getContent());
                  out.write("\" name=\"txtContent\"><br>                                                \n");
                  out.write("                                            </div>  \n");
                  out.write("                                            <br>\n");
                  out.write("                                            ");

                                                int c = 0;
                                            
                  out.write("\n");
                  out.write("                                            <div class=\"answer\" >\n");
                  out.write("                                                ");
                  //  c:forEach
                  org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
                  _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
                  _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
                  _jspx_th_c_forEach_0.setVar("ans");
                  _jspx_th_c_forEach_0.setItems(listQuestion.get(count).getListAnswer().keySet());
                  int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
                  try {
                    int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
                    if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                      do {
                        out.write("\n");
                        out.write("                                                    <input type=\"radio\" id=\"");
                        out.print(c);
                        out.write("\" style=\"float:left\" name=\"txta\" value=\"");
                        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ans}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                        out.write("\" required>  \n");
                        out.write("                                                    <label for=\"");
                        out.print(c);
                        out.write('"');
                        out.write('>');
                        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ans}", java.lang.String.class, (PageContext)_jspx_page_context, null));
                        out.write("</label><br>\n");
                        out.write("                                                    ");

                                                        c += 1;
                                                    
                        out.write("\n");
                        out.write("                                                ");
                        int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
                        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                          break;
                      } while (true);
                    }
                    if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                      return;
                    }
                  } catch (Throwable _jspx_exception) {
                    while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
                      out = _jspx_page_context.popBody();
                    _jspx_th_c_forEach_0.doCatch(_jspx_exception);
                  } finally {
                    _jspx_th_c_forEach_0.doFinally();
                    _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
                  }
                  out.write("\n");
                  out.write("                                            </div>  \n");
                  out.write("                                            <input style=\"float:right\" class=\"btn btn-sm btn-primary\"  type=\"submit\" value=\"Next\" name=\"btnNext\">\n");
                  out.write("                                        </form>\n");
                  out.write("                                    ");
                  int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
              out.write("\n");
              out.write("                                    ");
              //  c:if
              org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
              _jspx_th_c_if_3.setPageContext(_jspx_page_context);
              _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_when_1);
              _jspx_th_c_if_3.setTest(count == -1);
              int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
              if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\n");
                  out.write("                                        <form action=\"TakeQuizController\" method=\"POST\">\n");
                  out.write("                                            <h3>Result</h3> \n");
                  out.write("                                            ");
                  //  c:if
                  org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
                  _jspx_th_c_if_4.setPageContext(_jspx_page_context);
                  _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
                  _jspx_th_c_if_4.setTest(correct * 10 >= 50);
                  int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
                  if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\n");
                      out.write("                                                Your core: <p style=\"color: #007bff\">");
                      out.print(cString);
                      out.write("</p>\n");
                      out.write("                                            ");
                      int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
                    return;
                  }
                  _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
                  out.write("\n");
                  out.write("                                            ");
                  //  c:if
                  org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_5 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
                  _jspx_th_c_if_5.setPageContext(_jspx_page_context);
                  _jspx_th_c_if_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_3);
                  _jspx_th_c_if_5.setTest(correct * 10 < 50);
                  int _jspx_eval_c_if_5 = _jspx_th_c_if_5.doStartTag();
                  if (_jspx_eval_c_if_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    do {
                      out.write("\n");
                      out.write("                                                Your core: <p style=\"color: red\">");
                      out.print(cString);
                      out.write("</p>\n");
                      out.write("                                            ");
                      int evalDoAfterBody = _jspx_th_c_if_5.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                  }
                  if (_jspx_th_c_if_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
                    return;
                  }
                  _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_5);
                  out.write(" \n");
                  out.write("                                            <p>Take another test?</p>\n");
                  out.write("                                            <input type=\"submit\" class=\"btn btn-sm btn-primary\"  name=\"btnStartAnother\" value=\"Start\">\n");
                  out.write("                                        </form>\n");
                  out.write("                                    ");
                  int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
                return;
              }
              _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
              out.write("\n");
              out.write("                                </div>  \n");
              out.write("                            </div> \n");
              out.write("                        </div>\n");
              out.write("                    ");
              int evalDoAfterBody = _jspx_th_c_when_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_when_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
            return;
          }
          _jspx_tagPool_c_when_test.reuse(_jspx_th_c_when_1);
          out.write("\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_choose_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_choose_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
        return;
      }
      _jspx_tagPool_c_choose.reuse(_jspx_th_c_choose_0);
      out.write(" \n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
