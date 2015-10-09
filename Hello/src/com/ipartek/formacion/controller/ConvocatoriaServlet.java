package com.ipartek.formacion.controller;

import com.ipartek.formacion.bean.Convocatoria;
import com.ipartek.formacion.bean.excepciones.ConvocatoriaException;
import com.ipartek.formacion.service.ConvocatoriaService;
import com.ipartek.formacion.service.interfaces.IConvocatoriaService;
import com.ipartek.formacion.util.Constantes;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

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
  private static final Logger LOG = Logger.getLogger(ConvocatoriaServlet.class);

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
      // operacion de listar todos las convocatorias
      listarTodasConvocatorias(request);
    } else {
      // obtener los datos de una convocatoria
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
    List<Convocatoria> convocatorias = null;
    IConvocatoriaService cons = new ConvocatoriaService();
    dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_CURSO_LISTADO);
    convocatorias = cons.getAll();
    request.setAttribute(Constantes.ATT_LISTADO_CONVOCATORIAS, convocatorias);

  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response).
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // controlar update, delete, create
    int operacion = -1;
    IConvocatoriaService cons = null;
    Convocatoria convocatoria = null;
    try {
      operacion = Integer.parseInt(request.getParameter(Constantes.OP_KEY));
    } catch (Exception e) {
      operacion = -1;
      ConvocatoriaServlet.LOG.debug(e.getMessage());

    }

    switch (operacion) {
      case Constantes.OP_CREATE:
        cons = new ConvocatoriaService();
        convocatoria = obtenerParametrosConvocatoria(request);
        try {
          cons.create(convocatoria);
        } catch (ConvocatoriaException e) {
          e.printStackTrace();
        }
        break;
      case Constantes.OP_DELETE:
        cons = new ConvocatoriaService();

        cons.delete(codigoConvocatoria);

        break;
      case Constantes.OP_UPDATE:
        cons = new ConvocatoriaService();
        convocatoria = obtenerParametrosConvocatoria(request);

        cons.update(convocatoria);

        break;
      default:

        break;
    }
    dispatcher = request.getRequestDispatcher(Constantes.JSP_BACK_CURSO_LISTADO);
    dispatcher.forward(request, response);
  }

  private Convocatoria obtenerParametrosConvocatoria(HttpServletRequest request) {
    Convocatoria convocatoria = null;

    try {
      convocatoria = new Convocatoria();
      convocatoria.setCodigo(codigoConvocatoria);
      convocatoria.setNombre(request.getParameter(Constantes.PAR_NOMBRE_CONVOCATORIA));
    } catch (ConvocatoriaException e) {
      e.printStackTrace();
    }
    return convocatoria;
  }

}
