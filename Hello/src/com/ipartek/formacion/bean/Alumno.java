package com.ipartek.formacion.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.bean.interfaces.IInformable;
import com.ipartek.formacion.bean.interfaces.IMatriculable;
import com.ipartek.formacion.service.CursoService;
/**
 * 
 * @author Administrador
 *
 */
public class Alumno extends Persona implements IMatriculable, IInformable,Comparable<Alumno>{
/**
 * 
 */
	public static final int CODIGOALUMNO = -1;
	public static final int NHERMANOS  = 0;
	
	
	private int codigoAlumno;
	private String dni;
	private String nombre;
	private String apellidos;
	private Date fNacimiento;
	private int nHermanos;
	private List<CursoMatriculado> listadoCurso;
	public Alumno() throws AlumnoException{
		setCodigoAlumno(0);
		setNombre("");
		setApellidos("");
		setfNacimiento(Calendar.getInstance().getTime());
		setnHermanos(0);
		setDni("");
	}

	
	
/**
 * Es el constructor con paremetros de la clase Alumno
 * @param codigoAlumno es el codigo del alumno
 * @param nombre
 * @param apellidos
 * @param fNacimiento
 * @param nHermanos
 * @param dni
 * @throws AlumnoException 
 */
	public Alumno(int codigoAlumno,String nombre, String apellidos, Date fNacimiento,
			int nHermanos,String dni) throws AlumnoException {
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




	public void setDni(String dni) {
		this.dni = dni;
	}




	public int getCodigoAlumno() {
		return codigoAlumno;
	}

	public void setCodigoAlumno(int codigoAlumno) throws AlumnoException {
		if(codigoAlumno> CODIGOALUMNO){
			this.codigoAlumno = codigoAlumno;
		} else{
			throw new AlumnoException(
					AlumnoException.MSG_CODIGO_NO_VALIDO, 
					AlumnoException.COD_CODIGO_NO_VALIDO);
		}
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) throws AlumnoException {
		
		Calendar cal = Calendar.getInstance();
		//fecha actual menos 18 años
		GregorianCalendar cal2 =  new GregorianCalendar();
		cal2.add(GregorianCalendar.YEAR, -18);
		
		
		Date ahora = cal.getTime();
		Date fechaMayoria = cal2.getTime();
		//compareTo 
		//-1 ---> fNacimiento < ahora 
		// 0 ---> fNacimiento == ahora
		// 1 ---> fNacimiento > ahora 
		if(fNacimiento.compareTo(ahora)<=0){
			this.fNacimiento = fNacimiento;
		}else{
			throw new AlumnoException(AlumnoException.MSG_FECHANACIMIENTO_NO_VALIDA,
					AlumnoException.COD_FECHANACIMIENTO_NO_VALIDA);
		}
	
		this.fNacimiento = fNacimiento;
	}

	public int getnHermanos() {
		return nHermanos;
	}

	public void setnHermanos(int nHermanos) throws AlumnoException {
		if(nHermanos>= NHERMANOS){
			this.nHermanos = nHermanos;
		}else{
			throw new AlumnoException(AlumnoException.MSG_NHERMANOS_NO_VALIDO, 
					AlumnoException.COD_NHERMANOS_NO_VALIDO);
		}
	}

	@Override
	protected Curso solicitarInformacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void matricularCurso(int codigoCurso) {
		CursoService cs = new CursoService();
		Curso c = cs.getById(codigoCurso);
		Map<Integer,Alumno> listadoAlumnos = c.getListadoAlumnos();
		listadoAlumnos.put(this.codigoAlumno, this);
		c.setListadoAlumnos(listadoAlumnos);
		cs.update(c);
	}
	@Override
	public void desmatricularCurso(int codigoCurso) {
		CursoService cs = new CursoService();
		Curso c = cs.getById(codigoCurso);
		Map<Integer, Alumno> listadoAlumnos = c.getListadoAlumnos();
		listadoAlumnos.remove(this.codigoAlumno);
		c.setListadoAlumnos(listadoAlumnos);
		cs.update(c);
		
	}
	@Override
	public Curso solicitarInformacion(int codigoCurso) {
		CursoService cs = new CursoService();
		Curso c = cs.getById(codigoCurso);
		return c;
	}
	public class CursoMatriculado extends Curso{
		Date fechaMatriculacion;
		Alumno alumno;
		public CursoMatriculado(Alumno alumno,Date fechaMatriculacion) throws CursoException {
			super();
			this.alumno = alumno;
			this.fechaMatriculacion = fechaMatriculacion;
		}
		
		
		
	}
	@Override
	public int compareTo(Alumno o) {
		int resultado = 1;
		String apellido1 = o.getApellidos();
		String apellido2 = this.apellidos;
		
		resultado = apellido1.compareToIgnoreCase(apellido2);
		
		if(resultado!=0){
			return resultado;
		}else{
			 String nombre1 = o.getNombre();
			 String nombre2 = this.getNombre();
             return nombre1.compareTo(nombre2);
          
		}
	}



	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
}
