package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Convocatoria;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConvocatoriaServlet.
 *
 */
public class ConvocatoriaServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private RequestDispatcher dispatcher = null;

  private int id = Convocatoria.CODIGO_CONVOCATORIA;

  /**
   * @see HttpServlet#HttpServlet().
   */
  public ConvocatoriaServlet() {
    super();
  }

  /**
   * @see Servlet#init(ServletConfig).
   */
  @Override
  public void init(ServletConfig config) throws ServletException {
  }

  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      id = Integer.parseInt(request.getParameter(""));
    } catch (Exception e) {
      id = Convocatoria.CODIGO_CONVOCATORIA;
    }
    super.service(request, response);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

}
