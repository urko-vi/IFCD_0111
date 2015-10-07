package com.ipartek.formacion.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.bean.interfaces.IMatriculable;
import com.ipartek.formacion.service.CursoService;

/**
 * @author Administrador
 */
public class Alumno extends Persona implements IMatriculable,
Comparable<Alumno> {
	/**
	 *
	 */
	public static final int CODIGOALUMNO = -1;
	public static final int NHERMANOS = 0;

	private int codigoAlumno;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private int nHermanos;

	public Alumno() throws AlumnoException {
		setCodigoAlumno(0);
		setNombre("");
		setApellidos("");
		setfNacimiento(Calendar.getInstance().getTime());
		setnHermanos(0);
		setDni("");
	}

	/**
	 * Es el constructor con paremetros de la clase Alumno
	 *
	 * @param codigoAlumno
	 *            es el codigo del alumno
	 * @param nombre
	 * @param apellidos
	 * @param fNacimiento
	 * @param nHermanos
	 * @param dni
	 * @throws AlumnoException
	 */
	public Alumno(final int codigoAlumno, final String nombre,
			final String apellidos, final Date fNacimiento,
			final int nHermanos, final String dni) throws AlumnoException {
		super();
		setCodigoAlumno(codigoAlumno);
		setNombre(nombre);
		setApellidos(apellidos);
		setfNacimiento(fNacimiento);
		setnHermanos(nHermanos);
		setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(final String dni) {
		this.dni = dni;
	}

	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(final int codigoAlumno) throws AlumnoException {
		if (codigoAlumno > Alumno.CODIGOALUMNO) {
			this.codigoAlumno = codigoAlumno;
		} else {
			throw new AlumnoException(AlumnoException.MSG_CODIGO_NO_VALIDO,
					AlumnoException.COD_CODIGO_NO_VALIDO);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(final Date fNacimiento) throws AlumnoException {

		Calendar cal = Calendar.getInstance();
		// fecha actual menos 18 años
		// GregorianCalendar cal2 = new GregorianCalendar();
		// cal2.add(Calendar.YEAR, -18);

		Date ahora = cal.getTime();
		// Date fechaMayoria = cal2.getTime();
		// compareTo
		// -1 ---> fNacimiento < ahora
		// 0 ---> fNacimiento == ahora
		// 1 ---> fNacimiento > ahora
		if (fNacimiento.compareTo(ahora) <= 0) {
			this.fNacimiento = fNacimiento;
		} else {
			throw new AlumnoException(
					AlumnoException.MSG_FECHANACIMIENTO_NO_VALIDA,
					AlumnoException.COD_FECHANACIMIENTO_NO_VALIDA);
		}

		this.fNacimiento = fNacimiento;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(final int nHermanos) throws AlumnoException {
		if (nHermanos >= Alumno.NHERMANOS) {
			this.nHermanos = nHermanos;
		} else {
			throw new AlumnoException(AlumnoException.MSG_NHERMANOS_NO_VALIDO,
					AlumnoException.COD_NHERMANOS_NO_VALIDO);
		}
	}

	@Override
	public void matricularCurso(final int codigoCurso) {
		CursoService cs = new CursoService();
		Curso c = cs.getById(codigoCurso);
		Map<Integer, Alumno> listadoAlumnos = c.getListadoAlumnos();
		listadoAlumnos.put(codigoAlumno, this);
		c.setListadoAlumnos(listadoAlumnos);
		cs.update(c);
	}

	@Override
	public void desmatricularCurso(final int codigoCurso) {
		CursoService cs = new CursoService();
		Curso c = cs.getById(codigoCurso);
		Map<Integer, Alumno> listadoAlumnos = c.getListadoAlumnos();
		listadoAlumnos.remove(codigoAlumno);
		c.setListadoAlumnos(listadoAlumnos);
		cs.update(c);

	}

	public class CursoMatriculado extends Curso {
		Date fechaMatriculacion;
		Alumno alumno;

		public CursoMatriculado(final Alumno alumno,
				final Date fechaMatriculacion) throws CursoException {
			super();
			this.alumno = alumno;
			this.fechaMatriculacion = fechaMatriculacion;
		}

	}

	@Override
	public int compareTo(final Alumno o) {
		int resultado = 1;
		String apellido1 = o.getApellidos();
		String apellido2 = apellidos;

		resultado = apellido1.compareToIgnoreCase(apellido2);

		if (resultado != 0) {
			return resultado;
		} else {
			String nombre1 = o.getNombre();
			String nombre2 = getNombre();
			return nombre1.compareTo(nombre2);

		}
	}

	@Override
	public boolean equals(final Object obj) {
		Alumno al = null;
		boolean igual = false;
		if (obj instanceof Alumno) {
			al = (Alumno) obj;
			if (al.getCodigoAlumno() == codigoAlumno) {
				igual = true;
			}

		} else {
			throw new UnsupportedOperationException();
		}
		return igual;
	}

}
