package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.Curso;
import com.ipartek.formacion.exceptions.CursoException;
import com.ipartek.formacion.util.TipoCurso;

public class CursoService implements ICursoService {

	private List<Curso> cursos = null;

	public CursoService() {
		init();
	}

	public void addAlumno(Alumno alumno) {
		Curso c = cursos.get(0);
		Map<Integer, Alumno> listado = c.getListadoAlumnos();
		listado.put(alumno.getCodigoAlumno(), alumno);

	}

	@Override
	public Curso getById(int codigo) {
		Curso curso = null;
		int posicion = Curso.CODIGO_CURSO;

		posicion = encontrarCurso(codigo);
		// TODO controlar en el caso de que la posición devuelta sea -1
		curso = cursos.get(posicion);

		return curso;
	}

	@Override
	public int update(Curso curso) {
		int posicion = -1, codigo = Curso.CODIGO_CURSO;
		// TODO controlar en el caso de que la posición devuelta sea -1
		posicion = encontrarCurso(curso.getCodigo());

		cursos.add(posicion, curso);

		return codigo;
	}

	private int encontrarCurso(int codigoCurso) {
		int i = 0, longitud = cursos.size(), posicion = -1;
		boolean encontrado = false;
		do {
			if (cursos.get(i).getCodigo() == codigoCurso) {
				encontrado = true;
				posicion = i;
			}
			i++;
		} while (i < longitud && encontrado == false);
		return posicion;
	}

	public Map<Integer, Alumno> readAlumnos(int codigoCurso) {
		Curso c = getById(codigoCurso);
		Map<Integer, Alumno> listado = c.getListadoAlumnos();

		/*
		 * for(Map.Entry<Integer, Alumno> entry: listado.entrySet()){ Integer
		 * codigo = entry.getKey(); Alumno alum = entry.getValue(); }
		 * 
		 * Iterator it = listado.keySet().iterator(); while(it.hasNext()){
		 * Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer,
		 * Alumno>)it.next(); Integer codigo = entry.getKey(); Alumno alum =
		 * entry.getValue(); }
		 */
		return listado;
	}

	public void init() {
		// creamos el objeto de listado de cursos
		cursos = new ArrayList<Curso>();
		// creamos un curso
		Curso c = null;

		try {
			c = new Curso();
			c.setCodigo(0);
			c.setNombre("Java");
			c.setTipoCurso(TipoCurso.PROGRACION);
			// creamos el listado de alumnos
			HashMap<Integer, Alumno> listadoAlumnos = null;
			// creamos un objeto de tipo servicio
			// que nos carga la lista completa de alumnos
			AlumnoService as = new AlumnoService();
			// obtenemos el listado completo de alumnos
			ArrayList<Alumno> alumnos = as.getAll();

			listadoAlumnos = new HashMap<Integer, Alumno>();
			for (Alumno al : alumnos) {
				listadoAlumnos.put(al.getCodigoAlumno(), al);
			}

			cursos.add(c);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void incrementarPrecio() {
		for (int i = 0; i < cursos.size(); i++) {
			Curso c = cursos.get(i);
			switch (c.getTipoCurso()) {
				case PROGRACION:
					try {
						c.setPrecio(c.getPrecio() + 50.0);
					} catch (CursoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case DESIGN:
					try {
						c.setPrecio(c.getPrecio() + 70.0);
					} catch (CursoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case OFIMATICA:
					try {
						c.setPrecio(c.getPrecio() + 150.0);
					} catch (CursoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:

					break;
			}
		}
	}

	@Override
	public List<Curso> getAll() {

		return cursos;
	}

	@Override
	public boolean delete(int codigoCurso) {
		boolean exito = false;
		int posicion = encontrarCurso(codigoCurso);

		if (posicion != Curso.CODIGO_CURSO) {
			cursos.remove(posicion);
			exito = true;
		}
		return exito;
	}

	@Override
	public int create(Curso curso) {
		int posicion = Curso.CODIGO_CURSO;
		cursos.add(curso);

		posicion = encontrarCurso(curso.getCodigo());

		return posicion;
	}
}
