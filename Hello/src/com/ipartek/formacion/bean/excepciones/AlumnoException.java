/**
 *
 */
package com.ipartek.formacion.bean.excepciones;

/**
 * @author Administrador
 */
/**
 * AlumnoException es una {@code}Exception que se encarga de
 * gesionar los
 * errores de {@code}Alumno
 */
public class AlumnoException extends Exception {

	private transient int codigo;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@code int} Código de código de alumno no valido.
	 */
	public static final int COD_CODIGO_NO_VALIDO = 10;
	/**
	 * {@code int} Código de error número de hermanos no
	 * valido.
	 */
	public static final int COD_NHERMANOS_NO_VALIDO = 20;

	/**
	 * {@code int} codigo de error de fecha de nacimiento no
	 * valida
	 */
	public static final int COD_FECHANACIMIENTO_NO_VALIDA = 30;
	/**
	 * {@code String} Mensaje de texto para código de alumno
	 */
	public static final String MSG_CODIGO_NO_VALIDO = "El código de alumno introducido no es valido";
	/**
	 * {@code String Mensaje de texto para el numero de
	 * hermanos
	 */
	public static final String MSG_NHERMANOS_NO_VALIDO = "El número de hermnos introducido no es valido";
	/**
	 * {@code String Mensaje de texto para fecha de
	 * nacimiento no valida.
	 */
	public static final String MSG_FECHANACIMIENTO_NO_VALIDA = "La fecha de nacimiento introducida no es valida";

	public AlumnoException() {
		super();
	}

	public AlumnoException(final String mensage, final int pcodigo) {
		super(mensage);
		codigo = pcodigo;
	}

	public AlumnoException(final String arg0, final Throwable arg1,
			final boolean arg2, final boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

	public AlumnoException(final String arg0, final Throwable arg1) {
		super(arg0, arg1);

	}

	public AlumnoException(final String arg0) {
		super(arg0);
	}

	public AlumnoException(final Throwable arg0) {
		super(arg0);
	}

	public int getCodigo() {
		return codigo;
	}

}
