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

public final class sessionexpired_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/jsp/errorpage/../includes/footer.jsp", Long.valueOf(1410310552000L));
    _jspx_dependants.put("/jsp/errorpage/../includes/header.jsp", Long.valueOf(1410310552000L));
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
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"true", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<!--[if IE 8]><html class=\"lt-ie10 ie8\" lang=\"en data-scribe-reduced-action-queue=\"true\"\"><![endif]-->\n");
      out.write("<!--[if IE 9]><html class=\"lt-ie10 ie9\" lang=\"en data-scribe-reduced-action-queue=\"true\"\"><![endif]-->\n");
      out.write("<!--[if gt IE 9]><!--><html lang=\"en\" data-scribe-reduced-action-queue=\"true\"><!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<script type=\"text/javascript\" src=\"./jsp/js/jquery-1.10.2.js\"></script>\n");
      out.write("<script type=\"text/javascript\" src=\"./jsp/js/bootstrap.js\"></script>\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"./jsp/css/bootstrap.css\">\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"./jsp/css/logo-nav.css\">\n");
      out.write("</head>\n");
      out.write("<body><br /><br /><br /><br /><br />\n");
      out.write("\t<div class=\"container\">\n");
      out.write("    \t");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("<meta name=\"description\" content=\"\">\n");
      out.write("<meta name=\"author\" content=\"\">\n");
      out.write("<link rel=\"icon\" type=\"image/png\" href=\"./jsp/images/HRMSlogo.png\" />\n");
      out.write("<!-- Add custom CSS here -->\n");
      out.write("<link href=\"./jsp/css/logo-nav.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("<nav class=\"navbar-inverse navbar-fixed-top\" role=\"navigation\" style=\"position: absolute;\">\n");
      out.write("\t<div class=\"container\">\n");
      out.write("\t<div class=\"navbar-header\" style=\"padding-left: 5%\">\n");
      out.write("\n");
      out.write("\t\t<!-- You'll want to use a responsive image option so this logo looks good on devices - I recommend using something like retina.js (do a quick Google search for it and you'll find it) -->\n");
      out.write("\t\t<a class=\"navbar-nav\" href=\"http://mhrd.gov.in\" target=\"_blank\"><img src=\"./jsp/images/MHRDsvg_logo_01.svg\" height=80px></a>\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t<a class=\"navbar-brand navbar-right\" href=\"http://www.iitb.ac.in\" target=\"_blank\" style=\"padding-right: 5%;\"><img src=\"./jsp/images/iitb-logo.gif\"></a>\n");
      out.write("\t<ul class=\"nav navbar-nav navbar-left\" style=\"margin-top: 0;\">\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t");
if(session.getAttribute("advtName") != null) { 
      out.write("\n");
      out.write("\t\t\t\t<a><h3>");
      out.print(session.getAttribute("advtName"));
      out.write(" Recruitment</h3></a>\n");
      out.write("\t\t\t");
}
      out.write("\n");
      out.write("\t\t</li>\n");
      out.write("\t</ul>\n");
      out.write("\t</div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\t\t<form class=\"form-horizontal\" action=\"home.htm\" method=\"post\">\n");
      out.write("\t\t\t<div class=\"panel panel-danger\">\n");
      out.write("\t\t\t\t<div class=\"panel-heading\">\n");
      out.write("\t\t\t\t\t<h3 class=\"panel-title\"><i class=\"fa fa-user fa-1x\"></i> Session Expired</h3>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"panel-body\">\n");
      out.write("\t\t\t\t\t<span><img src=\"./jsp/images/Exclamationred.png\" alt=\"Error\" class=\"img-circle\" height=\"140\" width=\"140\"></span>\n");
      out.write("\t\t\t\t\t<span>You have either timed out due to inactivity or you have already logged out and tried to come back. Please <i class=\"fa fa-hand-o-right fa-1x\"></i> <a href=\"predisplayeditadvertisementpage.htm\">click here to login</a> again.</span>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\t\t\n");
      out.write("\t\n");
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
