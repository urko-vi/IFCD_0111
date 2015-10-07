package com.ipartek.formacion.util;

/**
 * Clase que sirve para almacenar las constantes del proyecto.
 *
 * @author Administrador Aqui se guardan las constantes a nivel de proyecto
 */
public final class Constantes {

  private Constantes() {
  }

  // ATRIBUTOS

  /**
   * Atributo que sirve para especificar el dni.
   */
  public static final String ATT_DNI = "dni";
  /**
   * Atributo que sirve para especificar la fecha de nacimiento.
   */
  public static final String ATT_FNACIMIENTO = "fnacimiento";
  /**
   * Atributo que sirve para especificar una <code>List</code> de <code>Curso</code>.
   */
  public static final String ATT_LISTADO_CURSOS = "listado_cursos";
  /**
   * Atributo que sirve para especificar una <code>List</code> de <code>Alumno</code>.
   */
  public static final String ATT_LISTADO_ALUMNOS = "listado_alumnos";
  /**
   * Atributo que sirve para especificar una <code>List</code> de <code>Convocatoria</code>.
   */
  public static final String ATT_LISTADO_CONVOCATORIAS = "listado_convocatoria";
  /**
   * Atributo que sirve para especificar un objeto <code>Mensaje</code>.
   */
  public static final String ATT_MENSAJE = "mensaje";
  /**
   * Atributo que sirve para especificar un objeto <code>Usuario</code>.
   */
  public static final String ATT_USUARIO = "usuario";
  /**
   * Atributo que sirve para especificar un objeto <code>Alumno</code>.
   */
  public static final String ATT_ALUMNO = "alumno";
  /**
   * Atributo que sirve para especificar un objeto <code>Curso</code>.
   */
  public static final String ATT_CURSO = "curso";
  /**
   * Atributo que sirve para especificar un objeto <code>Convocatoria</code>.
   */
  public static final String ATT_CONVOCATORIA = "convocatoria";
  // PARAMETROS
  /**
   * Parametro que sirve para especificar el campo user.
   */
  public static final String PAR_USUARIO = "user";
  /**
   * Parametro que sirve para especificar el campo password.
   */
  public static final String PAR_PASSWORD = "pass";
  /**
   * Parametro que sirve para especificar el campo clave.
   */
  public static final String PAR_CODIGO = "id";
  /**
   * Parametro que sirve para especificar el nombre.
   */
  public static final String PAR_NOMBRE = "nombre";
  /**
   * Parametro que sirve para especificar el apellidos.
   */
  public static final String PAR_APELLIDOS = "apellidos";
  /**
   * Parametro que sirve para especificar el numero de hermanos.
   */
  public static final String PAR_NHERMANOS = "numero_hermanos";
  // URLS O DIRECCIONES WEB
  /**
   * Dirección de la página de login.
   */
  public static final String PAGINA_LOGIN = "login.jsp";
  /**
   * Dirección del Servlet que hace login.
   */
  public static final String SERVLET_LOGIN = "login.do";
  /**
   * Dirección del Servlet que hace logout.
   */
  public static final String SERVLET_LOGOUT = "logout.do";
  /**
   * Dirección del Servlet de <code>Alumno</code>.
   */
  public static final String SERVLET_ALUMNOS = "alumnos.do";
  /**
   * Dirección del Servlet de <code>Curso</code>.
   */
  public static final String SERVLET_CURSOS = "cursos.do";
  /**
   * Dirección del Servlet de <code>Convocatoria</code>.
   */
  public static final String SERVLET_CONVOCATORIAS = "convocatorias.do";
  /**
   * Dirección de la carpeta del backoffice.
   */
  public static final String RUTA_BACKUP = "backup/";
  /**
   * Dirección de la página principal del back.
   */
  public static final String JSP_BACK_INDEX = Constantes.RUTA_BACKUP + "index.jsp";
  /**
   * Dirección del formulario de alumnos.
   */
  public static final String JSP_BACK_ALUMNO_FORM = Constantes.RUTA_BACKUP + "alumnos/form.jsp";
  /**
   * Dirección del listado de alumnos.
   */
  public static final String JSP_BACK_INDEX_ALUMNO = Constantes.RUTA_BACKUP + "alumnos/alumnos.jsp";
  /**
   * Dirección del formulario de cursos.
   */
  public static final String JSP_BACK_CURSO_FORM = Constantes.RUTA_BACKUP + "cursos/formulario.jsp";
  /**
   * Dirección del listado de cursos.
   */
  public static final String JSP_BACK_CURSO_LISTADO = Constantes.RUTA_BACKUP + "cursos/listado.jsp";
  /**
   * Dirección del listado de convocatorias.
   */
  public static final String JSP_BACK_CONVOCATORIA_LISTADO = Constantes.RUTA_BACKUP
      + "convocatorias/listado.jsp";
  /**
   * Dirección del formulario de convocatorias.
   */
  public static final String JSP_BACK_CONVOCATORIA_FORM = Constantes.RUTA_BACKUP
      + "convocatorias/form.jsp";

  // OPERACIONES
  /**
   * Atributo o parametro para que indica el nombre del valor operacion.
   */
  public static final String OP_KEY = "operation";
  /**
   * Operación de actualizar todos los registros.
   */
  public static final int OP_UPDATE = 0; // Actualizar Registro
  /**
   * Operación de eliminar todos los registros.
   */
  public static final int OP_DELETE = 1; // Eliminar Registro
  /**
   * Operación de crear todos los registros.
   */
  public static final int OP_LIST = 2; // Listar todos los Regsitros
  /**
   * Operacion de vista de detalle por id.
   */
  public static final int OP_DETAIL = 3; // Mostrar Detalle Registro
  /**
   * Operacion de vista de crear un nuevo registro.
   */
  public static final int OP_CREATE = 4; // Crear o insertar Registro

}
