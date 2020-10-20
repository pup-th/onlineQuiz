package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.UserDAO;

public final class MakeQuiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
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
      out.write("            text-align: center;\n");
      out.write("            width: 40%;\n");
      out.write("            margin: 5% auto; \n");
      out.write("            background: #fff;\n");
      out.write("            border-radius: 20px;\n");
      out.write("        }  \n");
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
      out.write("        ");

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
      out.write("        <div class=\"top\" ></div>\n");
      out.write("        <div class=\"body\" >\n");
      out.write("            <nav class=\"navbar navbar-expand-sm  \"> \n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\n");
      out.write("                    <ul class=\"navbar-nav\" >\n");
      out.write("                        <li class=\"nav-item\"> \n");
      out.write("                            <a class=\"nav-link\" href=\"login.jsp\">Home</a> \n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"TakeQuiz.jsp\">Take quiz</a>\n");
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
          out.write("                                <a class=\"nav-link\" href=\"MakeQuiz.jsp\">Make quiz</a>\n");
          out.write("                            </li>  \n");
          out.write("                            <li class=\"nav-item\">\n");
          out.write("                                <a class=\"nav-link\" href=\"ManagerQuiz.jsp\">Manager quiz</a>\n");
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
      out.write("            <div>\n");
      out.write("                <div class=\"input\"> \n");
      out.write("                    <div>\n");
      out.write("                        <h3 style=\" display: inline-block\">Make Quiz</h3>\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"MakeQuiz\" method=\"post\">\n");
      out.write("                        <div style= \"padding: 20px;\">\n");
      out.write("                            <table>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Question:</td>\n");
      out.write("                                    <td><input type=\"text\" class=\"question\" name=\"txtQuestion\" required></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Option 1</td>\n");
      out.write("                                    <td><input type=\"text\" class=\"option\" name=\"txtOp1\" required></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Option 2</td>\n");
      out.write("                                    <td><input type=\"text\" class=\"option\" name=\"txtOp2\" required></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Option 3</td>\n");
      out.write("                                    <td><input type=\"text\" class=\"option\" name=\"txtOp3\" required></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Option 4</td>\n");
      out.write("                                    <td><input type=\"text\" class=\"option\" name=\"txtOp4\" required></td>\n");
      out.write("                                </tr> \n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Answer: </td>\n");
      out.write("                                    <td><input type=\"radio\" name=\"radOption\" value=\"1\" required> Option 1\n");
      out.write("                                        <input type=\"radio\" name=\"radOption\" value=\"2\" required> Option 2\n");
      out.write("                                        <input type=\"radio\" name=\"radOption\" value=\"3\" required> Option 3\n");
      out.write("                                        <input type=\"radio\" name=\"radOption\" value=\"4\" required> Option 4  \n");
      out.write("                                    </td>\n");
      out.write("                                </tr> \n");
      out.write("                            </table> \n");
      out.write("                        </div> \n");
      out.write("                        <input type=\"submit\" value=\"Save\" name=\"btnSave\">\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
