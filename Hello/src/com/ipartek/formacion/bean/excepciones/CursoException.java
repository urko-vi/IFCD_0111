package com.ipartek.formacion.bean.excepciones;

public class CursoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * {@code}int Código de la excepción.
	 */
	private transient int codigo;
	/**
	 * {@code}int Constante de código de error del código de curso.
	 */
	public static final int COD_ERROR_CURSO = 10;

	/**
	 * {@code}int Constante de código de error del precio del curso
	 */
	public static final int COD_ERROR_PRECIO = 20;
	/**
	 * {@code}String constante del texto del mensage del codigo de curso
	 */
	public static final String MSG_ERROR_CODIGO = "El código introducido no es correcto";
	/**
	 * {@code}String constante del texto del mensaje del precio del curso
	 */
	public static final String MSG_ERROR_PRECIO = "El precio introducido es incorrecto";

	public CursoException() {
		super();
	}

	public CursoException(String mensage, int pcodigo) {
		super(mensage);
		codigo = pcodigo;
	}

	public CursoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CursoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CursoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CursoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

}
