/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.50
 * Generated at: 2014-11-11 06:07:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.jsp.errorpage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class methodnotallowed_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/errorpage/../includes/admin-menu.jsp", Long.valueOf(1410310552000L));
    _jspx_dependants.put("/jsp/errorpage/../includes/footer.jsp", Long.valueOf(1410310552000L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    ");

HttpSession httpSession = request.getSession(false);
if(httpSession.getAttribute("email") == null || httpSession.getAttribute("email").toString() == null) { 
      out.write('\n');
      out.write('	');
      out.write('	');
      if (true) {
        _jspx_page_context.forward("/sessionexpired.htm");
        return;
      }
      out.write('\n');
	} else { 
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"./jsp/images/iitb.jpg\" />\n");
      out.write("<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\" />\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\tfunction redirect(path) {\n");
      out.write("\t\tdocument.menuForm.action = path;\n");
      out.write("\t\t//document.menuForm.method=\"POST\";\n");
      out.write("\t\tdocument.menuForm.submit();\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("\tfunction showDefaultImage(img) {\n");
      out.write("\t\timg.src=\"user_images/default.png\";\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<!--[if lt IE 9]>\n");
      out.write("      <script src=\"./jsp/js/html5shiv.js\"></script>\n");
      out.write("    <![endif]-->\n");
      out.write("<script src=\"./jsp/js/html5shiv.js\"></script>\n");
      out.write("<script src=\"./jsp/js/respond.js\" type=\"text/javascipt\"> </script>\n");
      out.write("\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"./jsp/css/bootstrap3.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("<!-- Add custom CSS here -->\n");
      out.write("<link href=\"./jsp/css/font-awesome.css\" rel=\"stylesheet\" />\n");
      out.write("<style type=\"text/css\">\n");
      out.write("body {\n");
      out.write("\tmargin-top: 5%;\n");
      out.write("\twidth: 100%;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".dropdown-menu li>a:hover {\n");
      out.write("\tcolor: #ffffff;\n");
      out.write("\ttext-decoration: none;\n");
      out.write("\tbackground-color: #0077b3;\n");
      out.write("}\n");
      out.write("\n");
      out.write("li ul .dropdown-menu {\n");
      out.write("\t-webkit-transition: width 15s; /* For Safari 3.1 to 6.0 */\n");
      out.write("\ttransition: width 15s;\n");
      out.write("\tbackground-color: #0077b3;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("</head>\n");
      out.write("\t<form method=\"post\" name=\"menuForm\">\n");
      out.write("\t\t<div class=\"navbar-inverse navbar-fixed-top navbar-inner\">\n");
      out.write("\t\t\t<div class=\"container\">\n");
      out.write("\t\t\t\t<!-- Brand and toggle get grouped for better mobile display -->\n");
      out.write("\t\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t\t<button type=\"button\" data-target=\"#navbarCollapse\" data-toggle=\"collapse\" class=\"navbar-toggle\">\n");
      out.write("\t\t\t\t\t\t<span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t</button>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<a href=\"#\" class=\"brand navbar-right\"> <img src=\"./jsp/images/iitb-logo.gif\" style=\"\" width=180px height=50px />\n");
      out.write("\t\t\t\t</a> <a class=\"brand\" href=\"http://mhrd.gov.in\" target=\"_blank\" style=\"float: left;\"> <img src=\"./jsp/images/MHRDsvg_logo_01.svg\" height=50px />\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t<div id=\"navbarCollapse\" class=\"collapse navbar-collapse\">\n");
      out.write("\t\t\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"#\" onclick=\"redirect('examhome.htm')\"><i class=\"fa fa-home fa-1x\"></i> Home</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\"><a data-toggle=\"dropdown\" href=\"#\"><i class=\"fa fa-tags fa-1x\"></i> Advertisements <span class=\"caret\"></span></a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"#\">Advt. 1</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"#\">Advt. 2</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\"><a data-toggle=\"dropdown\" href=\"#\"><i class=\"fa fa-gears fa-1x\"></i> Admin <span class=\"caret\"></span></a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"redirect('createexammanual.htm')\"> <span>Create Exam</span>\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"redirect('addquestion.htm')\"> <span>Add Questions</span>\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"redirect('displayallquestions.htm')\"> <span>View Questions</span>\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li><a data-toggle=\"dropdown\" href=\"#\" onclick=\"#\"><i class=\"fa fa-unlock fa-1x\"></i> Current Openings</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li><a onclick=\"#\"> <span><i class=\"fa fa-question fa-1x\" style=\"font-size: 16px;\"></i> Help</span>\n");
      out.write("\t\t\t\t\t\t</a></li>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\"> <img src=\"user_images/");
      out.print(session.getAttribute("userid"));
      out.write(".jpg\" onerror=\"showDefaultImage(this)\"\n");
      out.write("\t\t\t\t\t\t\t\twidth=20px /> ");
      out.print(session.getAttribute("userName"));
      out.write(" <span class=\"caret\"></span>\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"dropdown-menu\" style=\"width: auto;\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\"><i class=\"fa fa-envelope\"></i> ");
      out.print(session.getAttribute("email"));
      out.write("</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"#\"> <i class=\"fa fa-eye\"></i> View Profile\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"#\"> <i class=\"fa fa-edit fa-1g\"></i> Edit Profile\n");
      out.write("\t\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"#\" onclick=\"redirect('examlogout.htm');\"><i class=\"fa fa-sign-out fa-1x\"></i> Sign out </a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</form>\n");
      out.write("\t<!-- JavaScript -->");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<body><br /><br /><br /><br /><br />\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<form class=\"form-horizontal\" action=\"home.htm\" method=\"post\">\n");
      out.write("\t\t\t<div class=\"panel panel-danger\">\n");
      out.write("\t\t\t\t<div class=\"panel-heading\">\n");
      out.write("\t\t\t\t\t<h3 class=\"panel-title\"><i class=\"fa fa-user fa-1x\"></i> Method Not Allowed</h3>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t<span><i class=\"fa fa-cog fa-3x\"></i></span>\n");
      out.write("\t\t\t\t\t<span>Either of the GET / POST request not supported. Please <i class=\"fa fa-hand-o-right fa-1x\"></i> <a href=\"examhome.htm\">click here</a>to go to home.</span>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"panel-footer\"></div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\t\t\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"./jsp/css/social-buttons.css\" media=\"all\">\n");
      out.write("\n");
      out.write("<div class=\"navbar-inverse navbar-default\" style=\"bottom: 0; inherit; height: 6em; padding-top: 8px;\">\n");
      out.write("\t<button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-ex1-collapse\">\n");
      out.write("\t\t<span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span>\n");
      out.write("\t</button>\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t\t<div class=\"collapse navbar-collapse navbar-ex1-collapse navbar-nav\">\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\" style=\"float: left;\">\n");
      out.write("\t\t\t\t<li><a> Copyright &copy; 2013 - 2014, The T10KT Technical Team, MHRD Project, IIT Bombay. </a>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<!-- /.navbar-collapse  style=\"width: 5\"-->\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"collapse navbar-collapse navbar-ex1-collapse pull-right\" >\n");
      out.write("\n");
      out.write("\t\t\t<ul class=\"nav navbar-nav\">\n");
      out.write("\t\t\t\t<li><a href=\"#about\"><i class=\"fa fa-info-circle\"></i> About</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"#services\"><i class=\"fa fa-wrench\"></i> Services</a></li>\n");
      out.write("\t\t\t\t<li><a href=\"contactus.htm\"><i class=\"fa fa-mobile\"></i> Contact</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t<span class=\"fa-stack fa-lg\"> <a href=\"https://www.facebook.com/recruitment\" class=\"btn btn-social-icon btn-facebook\" target=\"_blank\"><i class=\"fa fa-facebook-square fa-stack-2x\"> </i></a> <a\n");
      out.write("\t\t\t\thref=\"http://www.linkedin.com/recruitment/\" class=\"btn btn-social-icon btn-linkedin\" target=\"_blank\"><i class=\"fa fa-linkedin-square fa-stack-2x\"> </i></a>\n");
      out.write("\t\t\t</span> <span class=\"fa-stack fa-lg\"> <a href=\"https://twitter.com/recruitment\" class=\"btn btn-social-icon btn-twitter\" target=\"_blank\"><i class=\"fa fa-twitter-square fa-stack-2x\"> </i></a> <a\n");
      out.write("\t\t\t\thref=\"https://plus.google.com/recruitment\" class=\"btn btn-social-icon btn-google-plus\" target=\"_blank\"><i class=\"fa fa-google-plus-square fa-stack-2x\"> </i></a>\n");
      out.write("\t\t\t</span>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write("<div id=\"fb-root\"></div>\n");
      out.write("<script>\n");
      out.write("\t(function(d, s, id) {\n");
      out.write("\t\tvar js, fjs = d.getElementsByTagName(s)[0];\n");
      out.write("\t\tif (d.getElementById(id))\n");
      out.write("\t\t\treturn;\n");
      out.write("\t\tjs = d.createElement(s);\n");
      out.write("\t\tjs.id = id;\n");
      out.write("\t\tjs.src = \"//connect.facebook.net/en_US/all.js#xfbml=1\";\n");
      out.write("\t\tfjs.parentNode.insertBefore(js, fjs);\n");
      out.write("\t}(document, 'script', 'facebook-jssdk'));\n");
      out.write("</script>\n");
      out.write("<script type=\"text/javascript\" src=\"./jsp/js/socialButtonScripts.js\"></script>");
      out.write('\n');
}
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}