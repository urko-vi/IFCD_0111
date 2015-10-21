package com.ipartek.formacion.controller;

import com.ipartek.formacion.model.DAOFactory;
import com.ipartek.formacion.model.dbms.ConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.CursoDAO;
import com.ipartek.formacion.model.dbms.interfaces.IConvocatoriaDAO;
import com.ipartek.formacion.model.dbms.interfaces.ICursoDAO;
import com.ipartek.formacion.pojo.Candidato;
import com.ipartek.formacion.pojo.Convocatoria;
import com.ipartek.formacion.pojo.Curso;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private SessionFactory factoria = null;
  private Session sesion = null;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public Controller() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see Servlet#init(ServletConfig)
   */
  @Override
  public void init(ServletConfig config) throws ServletException {
    // factoria de conexiones
    factoria = new Configuration().configure().buildSessionFactory();
    // sesion es el equivalente a la conexion a BBDD openSession crea la conexion
    sesion = factoria.openSession();
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  private void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Candidato candidato = null;
    if (request.getParameter("candidato") != null) {
      Transaction transaccion = sesion.beginTransaction();
      candidato = new Candidato();

      candidato.setNombre("Alexander");
      candidato.setApellido1("Revuelta");
      candidato.setApellido2("Landaluce");
      sesion.saveOrUpdate(candidato);

      transaccion.commit();

    }
    String pagina = "backoffice/gestor-convocatoria.jsp";
    List<Convocatoria> listaConvocatorias = null;
    List<Curso> listaCursos = null;
    RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
    // carga de los datos
    IConvocatoriaDAO convdao = ConvocatoriaDAO.getInstance(DAOFactory.MYSQL_CONVOCATORIAS);
    ICursoDAO cursodao = CursoDAO.getInstance(DAOFactory.MYSQL_CURSOS);
    listaConvocatorias = convdao.getAll();
    listaCursos = cursodao.getAll();
    request.setAttribute("listaCursos", listaCursos);
    request.setAttribute("listaConvocatorias", listaConvocatorias);
    //

    dispatcher.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

}
