package com.ipartek.formacion.util;

public enum TipoCurso {
	/**
	 * Tipos de Curso
	 */
	PROGRACION("Cursos de progracion"), OFIMATICA("Cursos de ofimatica"), DESIGN(
			"Cursos de diseño grafico");
	private String descripcion;

	TipoCurso(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
