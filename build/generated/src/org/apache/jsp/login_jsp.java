package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import DAO.UserDAO;
import DAO.UserDAO;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"> \n");
      out.write("        <link rel=\"stylesheet\" href=\"https://code.jquery.com/jquery-3.5.1.min.js\"> \n");
      out.write("        <title>JSP Page</title>\n");
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
      out.write("        .form{\n");
      out.write("            width: 40%;\n");
      out.write("            margin: 5% auto; \n");
      out.write("            background: #fff;\n");
      out.write("        }\n");
      out.write("        .login{\n");
      out.write("            margin-top: 1%;\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 0px 0px 5% 0px;\n");
      out.write("        }\n");
      out.write("        .body{\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("        .loginhead{\n");
      out.write("            text-align: left;\n");
      out.write("            color: #007bff;\n");
      out.write("            font-weight: 500;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        <div class=\"form\" style=\"border-radius: 20px\">\n");
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
    
      out.write("\n");
      out.write("\n");
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
      out.write("    <script>\n");
      out.write("        //check click another navbar when in test\n");
      out.write("        function checkLoadAnotherNav() {\n");
      out.write("            if (");
      out.print(request.getSession().getAttribute("numberQuiz") != null);
      out.write(") {\n");
      out.write("                if (confirm(\"Do you want to exit this test?\")) {\n");
      out.write("                    return true;\n");
      out.write("                }\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        //dont load again takequiz page when in test\n");
      out.write("        function checkTakeQuiz() {\n");
      out.write("            if (");
      out.print(request.getSession().getAttribute("numberQuiz") != null);
      out.write(") {\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("    </script>\n");
      out.write("    <body> \n");
      out.write("\n");
      out.write("        <div class=\"top\" ></div>\n");
      out.write("        <div class=\"body\" >\n");
      out.write("            <nav class=\"navbar navbar-expand-sm  \"> \n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("                    <ul class=\"navbar-nav\" >\n");
      out.write("                        <li class=\"nav-item\"> \n");
      out.write("                            <a onclick=\"return checkLoadAnotherNav()\" class=\"nav-link\" id=\"homepageNav\" href=\"loginController\" >Home</a> \n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a onclick=\"return checkTakeQuiz()\"  class=\"nav-link\" id=\"takequizNav\" href=\"TakeQuizController\">Take quiz</a>\n");
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
          out.write("                                <a onclick=\"return checkLoadAnotherNav()\" class=\"nav-link\" id=\"makequizNav\" href=\"MakeQuiz\">Make quiz</a>\n");
          out.write("                            </li>  \n");
          out.write("                            <li class=\"nav-item\">\n");
          out.write("                                <a onclick=\"return checkLoadAnotherNav()\" class=\"nav-link\" id=\"managequizNav\" href=\"ManageQuizController\">Manager quiz</a>\n");
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
          out.write("                                    <input onclick=\"return checkLoadAnotherNav()\" type=\"submit\" class=\"logout\" value=\"Logout\" name=\"btnLogout\">\n");
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
      out.write("            ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_2.setPageContext(_jspx_page_context);
      _jspx_th_c_if_2.setParent(null);
      _jspx_th_c_if_2.setTest(userLogin.isEmpty());
      int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
      if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \n");
          out.write("                <div class=\"login\">\n");
          out.write("                    <h1>Login</h1>\n");
          out.write("                    <br>\n");
          out.write("                    <form action=\"loginController\" method=\"post\" id=\"formInput\">\n");
          out.write("                        Username: <Input type=\"text\" name=\"txtUsername\" autofocus  ><br><br>\n");
          out.write("                        Password: <Input type=\"password\" name=\"txtPassword\" ><br><br>\n");
          out.write("                        ");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_if_3.setPageContext(_jspx_page_context);
          _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_2);
          _jspx_th_c_if_3.setTest(fail != null);
          int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
          if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\n");
              out.write("                            <p style=\"color:red\">Login fail! Wrong Username or Password</p>\n");
              out.write("                        ");
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
          out.write("                        <input type=\"submit\" class=\"btn btn-sm btn-primary\" name=\"btnSubmit\" value=\"Login\">\n");
          out.write("                        <input type=\"submit\" style=\"border: none; background: #fff;color: #0069d9\" name=\"btnRe\" value=\"Register\"> \n");
          out.write("                    </form>\n");
          out.write("                </div>\n");
          out.write("            ");
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
      out.write("            ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_4.setPageContext(_jspx_page_context);
      _jspx_th_c_if_4.setParent(null);
      _jspx_th_c_if_4.setTest(!userLogin.isEmpty());
      int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
      if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                <div class=\"login\" style=\"height:250px;\">\n");
          out.write("                    <div >\n");
          out.write("                        <h5 style=\"text-align: center;\">\n");
          out.write("                            Welcome <p style=\"color:#007bff; display: inline\">");
          out.print(username);
          out.write("</p> \n");
          out.write("                        </h5> \n");
          out.write("                    </div>\n");
          out.write("                </div> \n");
          out.write("            ");
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
      out.write("        </div>\n");
      out.write("    </body> \n");
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
