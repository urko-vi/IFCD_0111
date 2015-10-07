package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.service.ConvocatoriaService;
import com.ipartek.formacion.service.interfaces.IConvocatoriaService;
import com.ipartek.formacion.util.Constantes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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

  private int codigoConvocatoria = Convocatoria.CODIGO_CONVOCATORIA;

  /**
   * @see HttpServlet#HttpServlet().
   */
  public ConvocatoriaServlet() {
    super();
  }

  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      codigoConvocatoria = Integer.parseInt(request.getParameter(""));
    } catch (Exception e) {
      codigoConvocatoria = Convocatoria.CODIGO_CONVOCATORIA;
    }
    super.service(request, response);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // controlar cuando es getById(codigoCurso) o
    // getAll()
    if (codigoConvocatoria == Convocatoria.CODIGO_CONVOCATORIA) {
      // operacion de listar todos los cursos
      listarTodasConvocatorias(request);
    } else {
      // obtener los datos de un curso
      obtenerDatosConvocatoria(request);
    }
    // redireccionamos
    dispatcher.forward(request, response);
  }

  private void obtenerDatosConvocatoria(HttpServletRequest request) {
    Convocatoria convocatoria = null;
    // obtenener datos de un curso
    IConvocatoriaService cs = new ConvocatoriaService();

    convocatoria = cs.getById(codigoConvocatoria);

    // cargar el distpacher
    dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_CONVOCATORIA_FORM);
    // guardar datos del curso en la request
    request.setAttribute(Constantes.ATT_CONVOCATORIA, convocatoria);
  }

  private void listarTodasConvocatorias(HttpServletRequest request) {

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  }

}
