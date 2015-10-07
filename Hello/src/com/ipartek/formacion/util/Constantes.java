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
   * Atributo que sirve para especificar el nombre.
   */
  public static final String ATT_DNI = "dni";
  /**
   * 
   */
  public static final String ATT_FNACIMIENTO = "fnacimiento";
  /**
   * 
   */
  public static final String ATT_LISTADO_CURSOS = "listado_cursos";
  /**
   * 
   */
  public static final String ATT_NHERMANOS = "numero_hermanos";
  /**
   * 
   */
  public static final String ATT_LISTADO_ALUMNOS = "alumnos";
  /**
   * 
   */
  public static final String ATT_MENSAJE = "mensaje";
  /**
   * 
   */
  public static final String ATT_USUARIO = "usuario";
  /**
   * 
   */
  public static final String ATT_ALUMNO = "alumno";
  /**
   * 
   */
  public static final String ATT_CURSO = "curso";
  // PARAMETROS
  /**
   * 
   */
  public static final String PAR_USUARIO = "user";
  /**
   * 
   */
  public static final String PAR_PASSWORD = "pass";
  /**
   * 
   */
  public static final String PAR_CODIGO_CURSO = "id";
  /**
   * Parametro que sirve para especificar el nombre.
   */
  public static final String PAR_NOMBRE = "nombre";
  /**
   * Parametro que sirve para especificar el apellidos.
   */
  public static final String PAR_APELLIDOS = "apellidos";

  // URLS O DIRECCIONES WEB
  /**
   * 
   */
  public static final String PAGINA_LOGIN = "login.jsp";
  /**
   * 
   */
  public static final String PAGINA_INICIAL = "backup/index.jsp";
  /**
   * 
   */
  public static final String SERVLET_LOGIN = "login.do";
  /**
   * 
   */
  public static final String SERVLET_LOGOUT = "logout.do";
  /**
   * 
   */
  public static final String SERVLET_ALUMNOS = "alumnos.do";
  /**
   * 
   */
  public static final String SERVLET_CURSOS = "cursos.do";
  /**
   * 
   */
  public static final String RUTA_BACKUP = "backup/";
  /**
   * 
   */
  public static final String JSP_BACK_INDEX = Constantes.RUTA_BACKUP + "index.jsp";
  /**
   * 
   */
  public static final String JSP_BACK_ALUMNO_FORM = Constantes.RUTA_BACKUP + "alumnos/form.jsp";
  /**
   * 
   */
  public static final String JSP_BACK_INDEX_ALUMNO = Constantes.RUTA_BACKUP + "alumnos/alumnos.jsp";
  /**
   * 
   */
  public static final String JSP_BACK_CURSO_FORM = Constantes.RUTA_BACKUP + "cursos/formulario.jsp";
  /**
   * 
   */
  public static final String JSP_BACK_CURSO_LISTADO = Constantes.RUTA_BACKUP + "cursos/listado.jsp";

  // OPERACIONES
  /**
   * 
   */
  public static final String OP_KEY = "operation";
  /**
   * 
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
