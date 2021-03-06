package com.ipartek.formacion.controller;

import com.ipartek.formacion.util.Constantes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet.
 */
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet().
   */
  public LogoutServlet() {
    super();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession sesion = request.getSession();
    // se destruye la session
    sesion.invalidate();

    // session fantasma
    sesion = request.getSession(true);
    sesion.setAttribute(Constantes.ATT_USUARIO, null);
    sesion.setAttribute(Constantes.ATT_MENSAJE, "Se ha salido con exito");
    // se redirecciona
    response.sendRedirect(Constantes.JSP_PAGINA_LOGIN);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
