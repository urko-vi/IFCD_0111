package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Curso;
import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.service.CursoService;
import com.ipartek.formacion.util.Constantes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CursoServlet
 */
public class CursoServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private int codigoCurso = Curso.CODIGO_CURSO;
  private RequestDispatcher distpacher = null;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CursoServlet() {
    super();
  }

  /**
   * @see Servlet#init(ServletConfig)
   */
  @Override
  public void init(final ServletConfig config) throws ServletException {

  }

  /**
   * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void service(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    try {
      codigoCurso = Integer.parseInt(request.getParameter(Constantes.PAR_CODIGO_CURSO));
    } catch (Exception e) {
      codigoCurso = Curso.CODIGO_CURSO;
    }
    super.service(request, response);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {

    // controlar cuando es getById(codigoCurso) o
    // getAll()
    if (codigoCurso == Curso.CODIGO_CURSO) {
      // operacion de listar todos los cursos
      listarTodosCursos(request);
    } else {
      // obtener los datos de un curso
      obtenerDatosCurso(request);
    }
    // redireccionamos
    distpacher.forward(request, response);
  }

  private void obtenerDatosCurso(final HttpServletRequest request) {
    Curso curso = null;
    // obtenener datos de un curso
    CursoService cs = new CursoService();
    curso = cs.getById(codigoCurso);
    // cargar el distpacher
    distpacher = request.getRequestDispatcher(Constantes.JSP_BACK_CURSO_FORM);
    // guardar datos del curso en la request
    request.setAttribute(Constantes.ATT_CURSO, curso);
  }

  private void listarTodosCursos(final HttpServletRequest request) {
    List<Curso> cursos = null;
    CursoService cs = new CursoService();
    distpacher = request.getRequestDispatcher(Constantes.JSP_BACK_CURSO_LISTADO);
    cursos = cs.getAll();
    request.setAttribute(Constantes.ATT_LISTADO_CURSOS, cursos);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    // controlar update, delete, create
    int operacion = -1;
    CursoService cs = null;
    Curso curso = null;
    try {
      operacion = Integer.parseInt(request.getParameter(Constantes.OP_KEY));
    } catch (Exception e) {
      operacion = -1;
    }

    switch (operacion) {
      case Constantes.OP_CREATE:
        cs = new CursoService();
        curso = obtenerParametrosCurso(request);
        cs.create(curso);
        break;
      case Constantes.OP_DELETE:
        cs = new CursoService();
        cs.delete(codigoCurso);
        break;
      case Constantes.OP_UPDATE:
        cs = new CursoService();
        curso = obtenerParametrosCurso(request);
        cs.update(curso);
        break;
      default:

        break;
    }
    distpacher = request.getRequestDispatcher(Constantes.JSP_BACK_CURSO_LISTADO);
    distpacher.forward(request, response);
  }

  private Curso obtenerParametrosCurso(final HttpServletRequest request) {
    Curso curso = null;

    try {
      curso = new Curso();
      curso.setCodigo(codigoCurso);
      curso.setNombre(request.getParameter(""));
      // recogemos datos del resto de parametros
    } catch (CursoException e) {
      e.printStackTrace();
    }

    return curso;
  }
}
