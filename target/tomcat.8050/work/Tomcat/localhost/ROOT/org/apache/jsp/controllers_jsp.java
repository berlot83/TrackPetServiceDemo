/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.11
 * Generated at: 2018-09-28 11:20:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class controllers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"src/css/controllers\" >\r\n");
      out.write("<script type=\"text/javascript\" src=\"src/js/ajaxCalls.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"src/js/various.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"src/css/index.css\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css?family=Pacifico\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("window.onbeforeunload = function(e) {\r\n");
      out.write("    return 'Please press the Logout button to logout.';\r\n");
      out.write("};\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<title>Track Pet services Controller Page</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"advice()\" style=\"background-image: url('src/img/pawbackground.png'); background-repeat:'no-repeat'; background-attachment: fixed;\" >\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Star menu bar -->\r\n");
      out.write("\t<ul>\r\n");
      out.write("\t  <li><a href=\"index.jsp\">Inicio</a></li>\r\n");
      out.write("\t  <li><a href=\"controllers.jsp\">Veterinarias/revendedores</a></li>\r\n");
      out.write("\t  <li><a href=\"#\" onclick=\"contact()\" >Contacto</a></li>\r\n");
      out.write("\t  <li><a href=\"#\" onclick=\"about()\" >Sobre Nosotros</a></li>\r\n");
      out.write("\t  <li><a href=\"#\" onclick=\"about()\" >MolokoAccess</a></li>\r\n");
      out.write("\t    <li><a href=\"#\" onclick=\"reportPet()\" >Reportar una mascota</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<!-- End menu bar -->\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"divContent\" style=\"padding-left:50px; padding-right:50px;\">\r\n");
      out.write("\t<div class=\"row\" style=\"padding: 5%; font-family: 'Pacifico', cursive;\">\r\n");
      out.write("\t\t<div class=\"col-6\" style=\"color:Turquoise; text-shadow: 0px 0px 8px rgba(0, 0, 0, 1);\">\r\n");
      out.write("\t\t<h2 style=\"font-family: 'Pacifico', cursive; color:'Orchid'; text-align:center;\">Servicio de información de mascotas</h2>\r\n");
      out.write("\t\t<h4 style=\"color:Turquoise; text-align:center;\">\"Alta de Mascota\"</h4>\r\n");
      out.write("\t\t\t<div class=\"form-group\" style=\"color:Turquoise;\">\r\n");
      out.write("\t\t\t\t<label for=\"raze\">Raza</label> <input type=\"text\" id=\"raze\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"raze\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\" style=\"color:Turquoise;\">\r\n");
      out.write("\t\t\t\t<label for=\"name\">Nombre</label> <input type=\"text\" id=\"name\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"name\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"age\">Edad</label> <input type=\"number\" id=\"age\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"age\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"street1\">Dirección principal (Altura incluida)</label> <input\r\n");
      out.write("\t\t\t\t\ttype=\"text\" id=\"street1\" placeholder=\"street1\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"street2\">Corta con Calle</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tid=\"street2\" placeholder=\"street2\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"city\">Ciudad</label> <input type=\"text\" id=\"city\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"city\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"phone1\">Teléfono</label> <input type=\"text\" id=\"phone1\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"phone1\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"phone2\">Teléfono</label> <input type=\"text\" id=\"phone2\"\r\n");
      out.write("\t\t\t\t\tplaceholder=\"phone2\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\"> \r\n");
      out.write("\t\t\t\t<label for=\"illness\">Sufre alguna efermedad</label> <input\r\n");
      out.write("\t\t\t\t\ttype=\"text\" id=\"illness\" placeholder=\"illness\" class=\"form-control\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<button id=\"send\" class=\"btn btn-primary\" onclick=\"insertPet()\" >Enviar y crear Código QR</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"col-6\">\r\n");
      out.write("\t\t<br>\r\n");
      out.write("\t\t<h4 style=\"color:Plum; text-shadow: 0px 0px 4px rgba(0, 0, 0, 1);\">Etiqueta QR:</h4>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t<div id=\"qrResult\" style=\"text-align:center;\">\r\n");
      out.write("\t\t<!-- Ajax call response from endpoint with qrCodeImages -->\r\n");
      out.write("\t\t<div id=\"downloadButtonDiv\" ></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t\t<img alt=\"\" src=\"src/img/pet1.jpg\" class=\"img-fluid w-100, rounded\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<strong>Powered by</strong>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<img alt=\"Molokotech\" src=\"src/img/molokoalternativo.png\"\r\n");
      out.write("\t\t\t\tclass=\"img-fluid\" onclick=\"redirectTo()\" >\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\"\r\n");
      out.write("\tintegrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"\r\n");
      out.write("\tintegrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n");
      out.write("\tcrossorigin=\"anonymous\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<link charset=\"utf-8\" rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.css\">\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.0/jquery-confirm.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}