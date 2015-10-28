package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.Usuario;
import com.ipartek.formacion.i18n.I18n;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.interfaces.IAlumnoService;
import com.ipartek.formacion.util.Constantes;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet.
 */

public class LoginServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  // private ServletConfig config;
  /**
   * @see HttpServlet#HttpServlet().
   */
  public LoginServlet() {
    super();
  }

  /**
   * @see Servlet#init(ServletConfig).
   */
  @Override
  public void init(final ServletConfig config) throws ServletException {
    // this.config = config;
    super.init(config);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    Locale locale = request.getLocale();
    HttpSession sesion = request.getSession(true);
    ResourceBundle messages = ResourceBundle.getBundle("com.ipartek.formacion.i18n.i18nmessages",
        locale);
    // es_ES
    String local = I18n.getBrowserLocale(locale);

    sesion.setAttribute("idioma", local);
    response.sendRedirect("login.jsp");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    String user = null;
    String password = null;
    // recogemos parametros

    user = request.getParameter(Constantes.PAR_USUARIO);
    password = request.getParameter(Constantes.PAR_PASSWORD);

    // validarlos
    if (validarUsuarios(user, password)) {
      // crearmos session
      HttpSession sesion = request.getSession(true);
      // redirigir
      Usuario usuario = new Usuario();
      usuario.setUserName(user);
      usuario.setPassword(password);
      sesion.setAttribute(Constantes.ATT_USUARIO, usuario);
      // mostar el total de los alumnos
      IAlumnoService as = new AlumnoService();
      List<Alumno> alumnos = as.getAll();
      RequestDispatcher dispatcher = null;
      dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX);
      request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
      // response.sendRedirect(Constantes.PAGINA_INICIAL);
      dispatcher.forward(request, response);
    } else {
      // redirigir
      RequestDispatcher dispatcher = null;
      dispatcher = request.getRequestDispatcher(Constantes.JSP_PAGINA_LOGIN);
      request.setAttribute(Constantes.ATT_MENSAJE, "usuario o contrase�a incorrectos");
      // redirecionamos
      dispatcher.forward(request, response);
    }

  }

  private boolean validarUsuarios(final String user, final String password) {
    boolean valido = false;
    // user.equals("urko");
    if (user != null && password != null && user.equals("urko") && password.equals("urko")) {
      valido = true;
    }

    return valido;
  }

}
