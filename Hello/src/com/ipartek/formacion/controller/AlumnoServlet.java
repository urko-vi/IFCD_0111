package com.ipartek.formacion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.util.Constantes;

/**
 * Servlet implementation class AlumnoServlet
 */
public class AlumnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;
	RequestDispatcher dispatcher = null;
	int id = Alumno.CODIGOALUMNO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlumnoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		super.init(config);
	}

	@Override
	protected void service(final HttpServletRequest req,
			final HttpServletResponse resp) throws ServletException,
			IOException {

		// TODO comprobar Autorizacion del usuario

		// recoger paramtro identificador Persona
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (Exception e) {
			id = Alumno.CODIGOALUMNO;
		}

		super.service(req, resp);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// comprobar si es getAll o getById
		if (id == Alumno.CODIGOALUMNO) {
			getAll(request);
		} else {
			getById(request);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	private void getById(final HttpServletRequest request) {
		// Persona p = model.getById(id);
		Alumno al = null;
		//Alumno al = .getById(id);
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_USUARIO, al);
		// forward a la vista del formulario
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_ALUMNO_FORM);

	}

	private void getAll(final HttpServletRequest request) {

		List<Alumno> alumnos = null;
		// pasamos los atributos
		request.setAttribute(Constantes.ATT_LISTADO_ALUMNOS, alumnos);
		// forward a la vista
		dispatcher = request
				.getRequestDispatcher(Constantes.JSP_BACK_INDEX_ALUMNO);

		//log.debug(alumnos.size() + " recuperadas");
	}
}
