package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.service.AlumnoService;
import com.ipartek.formacion.service.interfaces.IAlumnoService;
import com.ipartek.formacion.util.Constantes;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlumnoServlet.
 */
public class AlumnoServlet extends HttpServlet {
  /**
   * <code>long</code> consante que serializa la clase.
   */
  private static final long serialVersionUID = 1L;
  /**
   * <code>RequestDispatcher</code> para redigir el trafico.
   */
  private RequestDispatcher dispatcher = null;
  /**
   * <code>int</code> el codigo de <code>Alumno</code>.
   */
  private transient int codigoAlumno = Alumno.CODIGOALUMNO;

  @Override
  protected void service(final HttpServletRequest req, final HttpServletResponse resp)
      throws ServletException, IOException {

    // TODO comprobar Autorizacion del usuario

    // recoger paramtro identificador Persona
    try {
      codigoAlumno = Integer.parseInt(req.getParameter(Constantes.PAR_CODIGO));
    } catch (Exception e) {
      codigoAlumno = Alumno.CODIGOALUMNO;
    }

    super.service(req, resp);
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    // la existencia de la ID de Alumno es lo que
    // diferencia si
    // es un getAll o un getById

    // comprobar si es getAll o getById
    if (codigoAlumno == Alumno.CODIGOALUMNO) {
      getAll(request);
      request.getAttribute("");
    } else {
      getById(request);
    }
    // redirige
    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    int opcion = -1;
    try {
      opcion = Integer.parseInt((String) request.getAttribute(Constantes.OP_KEY));
    } catch (Exception e) {
      getAll(request);
      dispatcher.forward(request, response);
    }
    IAlumnoService as = new AlumnoService();
    switch (opcion) {
      case Constantes.OP_DELETE:
        as.delete(codigoAlumno);
        break;
      case Constantes.OP_UPDATE: {
        Alumno al = getDatosAlumno(request);
        as.update(al);
      }
      break;
      case Constantes.OP_CREATE: {
        Alumno al = getDatosAlumno(request);
        as.create(al);
      }
      break;
      case Constantes.OP_LIST:
        as.getAll();
        break;
      case Constantes.OP_DETAIL:
        as.getById(codigoAlumno);
        break;
      default:
        break;
    }

  }

  private Alumno getDatosAlumno(final HttpServletRequest request) {
    Alumno alum = null;
    try {
      alum = new Alumno();

      alum.setCodigoUsuario(codigoAlumno);
      alum.setNombre(request.getParameter(Constantes.PAR_NOMBRE));
      alum.setApellidos(request.getParameter(Constantes.PAR_APELLIDOS));
    } catch (AlumnoException e) {
      e.printStackTrace();
    }

    return alum;
  }

  private void getById(final HttpServletRequest request) {

    Alumno al = null;
    IAlumnoService as = new AlumnoService();
    al = as.getById(codigoAlumno);
    request.setAttribute(Constantes.ATT_USUARIO, al);

    dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_ALUMNO_FORM);

  }

  private void getAll(final HttpServletRequest request) {

    List<Alumno> alumnos = null;
    IAlumnoService as = new AlumnoService();
    alumnos = as.getAll();
    request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
    // forward a la vista
    dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_INDEX_ALUMNO);

  }
}
