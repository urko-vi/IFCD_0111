package com.ipartek.formacion.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.bean.Curso;
import com.ipartek.formacion.exceptions.CursoException;
import com.ipartek.formacion.util.TipoCurso;

public class CursoService {
	
	private List<Curso> cursos = null;
	
	public CursoService(){
		init();
	}
	public void addAlumno(Alumno alumno){
		Curso c = cursos.get(0);
		Map<Integer, Alumno>listado = c.getListadoAlumnos();
		listado.put(alumno.getCodigoAlumno(), alumno);
		
	}
	public Curso getById(int codigo){
		Curso curso = null;
		int i = 0, longitud = cursos.size();
		boolean encontrado = false;
		do{
			Curso c = cursos.get(i);
			if(codigo==c.getCodigo()){
				curso = c;
			}
			i++;
		}while(encontrado==false&&i<longitud);
		
		
		return curso;
	}
	public void update(Curso curso){
		int i = 0, longitud = cursos.size();
		boolean encontrado = false;
		
		do{
			if(cursos.get(i).getCodigo()==curso.getCodigo()){
				cursos.add(i, curso);
				encontrado = true;
				//aa
			}
			i++;
		}while(i<longitud&&encontrado==false);	
	}
	public Map<Integer, Alumno> readAlumnos(int codigoCurso){
		Curso c = getById(codigoCurso);
		Map<Integer, Alumno>listado = c.getListadoAlumnos();
		
		/*
		for(Map.Entry<Integer, Alumno> entry: listado.entrySet()){
			Integer codigo = entry.getKey();
			Alumno alum = entry.getValue();
		}
		
		Iterator it = listado.keySet().iterator();
		while(it.hasNext()){
			Map.Entry<Integer, Alumno> entry = (Map.Entry<Integer, Alumno>)it.next();
			Integer codigo = entry.getKey();
			Alumno alum = entry.getValue();
		}
		*/
		return listado;
	}
	public void init(){
		//creamos el objeto de listado de cursos
		cursos = new ArrayList<Curso>();
		//creamos un curso
		Curso c = null;
		
		try {
			c = new Curso();
			c.setCodigo(0);
			c.setNombre("Java");
			c.setTipoCurso(TipoCurso.PROGRACION);
			//creamos el listado de alumnos
			HashMap<Integer, Alumno> listadoAlumnos = null;
			//creamos un objeto de tipo servicio 
			//que nos carga la lista completa de alumnos
			AlumnoService as = new AlumnoService();
			//obtenemos el listado completo de alumnos
			ArrayList<Alumno> alumnos = as.getAll();
			
			listadoAlumnos = new HashMap<Integer, Alumno>();
			for(Alumno al: alumnos){
				listadoAlumnos.put(al.getCodigoAlumno(), al);
			}
			
			cursos.add(c);
		} catch (CursoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public void incrementarPrecio(){
		for(int i = 0; i<cursos.size();i++){
			Curso c = cursos.get(i);
			switch(c.getTipoCurso()){
				case PROGRACION:
				try {
					c.setPrecio(c.getPrecio()+50.0);
				} catch (CursoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				case DESIGN:
				try {
					c.setPrecio(c.getPrecio()+70.0);
				} catch (CursoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				case OFIMATICA:
				try {
					c.setPrecio(c.getPrecio()+150.0);
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
}
