package com.ipartek.formacion.bean;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.ipartek.formacion.bean.excepciones.AlumnoException;
import com.ipartek.formacion.bean.excepciones.CursoException;
import com.ipartek.formacion.bean.interfaces.IMatriculable;
import com.ipartek.formacion.service.CursoService;

/**
 * Clase de alumno que es la que puede asistir a los cursos.
 *
 * @author Administrador.
 */
public class Alumno extends Usuario implements IMatriculable, Comparable<Alumno> {
  /**
   * Constante para código de alumno invalido.
   */
  public static final int CODIGOALUMNO = -1;
  /**
   * Constante para numero de hermanos validos.
   */
  public static final int NHERMANOS = 0;

  private String dni;
  private String nombre;
  private String apellidos;
  private Date fnacimiento;
  private int nhermanos;

  /**
   * Constructor en blanco de la clase Alumno.
   *
   * <code>@throws</code> una <code>Exception</code> de tipo <code>AlumnoException</code>
   */
  public Alumno() throws AlumnoException {
    setCodigoUsuario(Alumno.CODIGOALUMNO);
    setNombre("");
    setApellidos("");
    setfnacimiento(Calendar.getInstance().getTime());
    setnhermanos(0);
    setDni("");
  }

  /**
   * Es el constructor con paremetros de la clase Alumno.
   *
   * <code>int</code> @param codigoAlumno es el codigo del alumno.
   *
   * <code>String</code> @param nombre es el nombre del alumno. <code>String</code> @param apellidos
   * es los apellidos del alumno. <code>Date</code>@param fNacimiento es la fecha de nacimiento del
   * alumnos. <code>int</code> @param nHermanos son el numero de hermanos del alumno.
   *
   * @param dni
   *          <code>@throws</code> una <code>Exception</code> de tipo <code>AlumnoException</code>
   */
  public Alumno(final int codigoAlumno, final String nombre, final String apellidos,
      final Date fnacimiento, final int nhermanos, final String dni) throws AlumnoException {
    super();
    setCodigoUsuario(codigoAlumno);
    setNombre(nombre);
    setApellidos(apellidos);
    setfnacimiento(fnacimiento);
    setnhermanos(nhermanos);
    setDni(dni);
  }

  public String getDni() {
    return dni;
  }

  public void setDni(final String dni) {
    this.dni = dni;
  }

  /**
   *
   * @return <code>String</code> devuelve el nombre.
   */
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

  public Date getfnacimiento() {
    return fnacimiento;
  }

  /**
   *
   * @param fnacimiento
   * @throws AlumnoException
   */
  public void setfnacimiento(final Date fnacimiento) throws AlumnoException {

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
    if (fnacimiento.compareTo(ahora) <= 0) {
      this.fnacimiento = fnacimiento;
    } else {
      throw new AlumnoException(AlumnoException.MSG_FECHANACIMIENTO_NO_VALIDA,
          AlumnoException.COD_FECHANACIMIENTO_NO_VALIDA);
    }
  }

  public int getnhermanos() {
    return nhermanos;
  }

  public void setnhermanos(final int nhermanos) throws AlumnoException {
    if (nhermanos >= Alumno.NHERMANOS) {
      this.nhermanos = nhermanos;
    } else {
      throw new AlumnoException(AlumnoException.MSG_NHERMANOS_NO_VALIDO,
          AlumnoException.COD_NHERMANOS_NO_VALIDO);
    }
  }

  /**
   *
   */
  @Override
  public void matricularCurso(final int codigoCurso) {
    CursoService cs = new CursoService();
    Curso c = cs.getById(codigoCurso);
    Map<Integer, Alumno> listadoAlumnos = c.getListadoAlumnos();
    listadoAlumnos.put(getCodigoUsuario(), this);
    c.setListadoAlumnos(listadoAlumnos);
    cs.update(c);
  }

  /**
   *
   */
  @Override
  public void desmatricularCurso(final int codigoCurso) {
    CursoService cs = new CursoService();
    Curso c = cs.getById(codigoCurso);
    Map<Integer, Alumno> listadoAlumnos = c.getListadoAlumnos();
    listadoAlumnos.remove(getCodigoUsuario());
    c.setListadoAlumnos(listadoAlumnos);
    cs.update(c);

  }

  /**
   *
   * @author va00
   *
   */
  public class CursoMatriculado extends Curso {
    Date fechaMatriculacion;
    Alumno alumno;

    public CursoMatriculado(final Alumno alumno, final Date fechaMatriculacion)
        throws CursoException {
      super();
      this.alumno = alumno;
      this.fechaMatriculacion = fechaMatriculacion;
    }

  }

  /**
   *
   */
  @Override
  public int compareTo(final Alumno alumno) {
    int resultado = 1;
    String apellido1 = alumno.getApellidos();
    String apellido2 = apellidos;

    resultado = apellido1.compareToIgnoreCase(apellido2);

    if (resultado != 0) {
      return resultado;
    } else {
      String nombre1 = alumno.getNombre();
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
      if (al.getCodigoUsuario() == getCodigoUsuario()) {
        igual = true;
      }

    } else {
      throw new UnsupportedOperationException();
    }
    return igual;
  }

}
