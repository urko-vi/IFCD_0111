package com.ipartek.formacion.util;
/**
 * 
 * @author Administrador
 * Aqui se guardan las constantes a nivel de proyecto
 */
public class Constantes {
	
	//ATRIBUTOS
	/**
	 * 
	 */
	public static final String ATT_OPERACION_ALUMNOS = "operacion";
	public static final String ATT_NOMBRE = "nombre";
	public static final String ATT_APELLIDOS = "apellidos";
	public static final String ATT_DNI = "dni";
	public static final String ATT_FNACIMIENTO ="fnacimiento";
	public static final String ATT_LISTADO_CURSOS = "listado_cursos";
	public static final String ATT_NHERMANOS = "numero_hermanos";
	
	public static final String ATT_LISTADO_ALUMNOS = "alumnos";
	public static final String ATT_MENSAJE ="mensaje";
	public static final String ATT_USUARIO ="usuario";
	public static final String ATT_ALUMNO ="alumno";
	//PARAMETROS
	public static final String PAR_USUARIO = "user";
	public static final String PAR_PASSWORD= "pass";
	
	//URLS O DIRECCIONES WEB
	public static final String PAGINA_LOGIN ="login.jsp";
	public static final String PAGINA_INICIAL ="backup/index.jsp";
	
	public static final String SERVLET_LOGIN ="login.do";
	public static final String SERVLET_LOGOUT = "logout.do";
	public static final String SERVLET_ALUMNOS = "alumnos.do";
	
	public static final String RUTA_BACKUP = "backup/";
	public static final String JSP_BACK_INDEX = RUTA_BACKUP + "index.jsp";
	public static final String JSP_BACK_ALUMNO_FORM = RUTA_BACKUP
			+ "persona/form.jsp";
	public static final String JSP_BACK_INDEX_ALUMNO = RUTA_BACKUP
			+ "persona/alumnos.jsp";
	
	//OPERACIONES 
	public static final String OP_KEY = "operation";
	public static final String OP_UPDATE = "0"; // Actualizar Registro
	public static final String OP_DELETE = "1"; // Eliminar Registro
	public static final String OP_LIST = "2"; // Listar todos los Regsitros
	public static final String OP_DETAIL = "3"; // Mostrar Detalle Registro
	public static final String OP_CREATE = "4"; // Crear o insertar Registro
}
