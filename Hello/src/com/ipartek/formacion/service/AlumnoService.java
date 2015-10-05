package com.ipartek.formacion.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;

import com.ipartek.formacion.bean.Alumno;
import com.ipartek.formacion.exceptions.AlumnoException;

public class AlumnoService implements IAlumnoService{

	private ArrayList<Alumno> alumnos = null;
	
	public AlumnoService() {
		init();
	}
	public ArrayList<Alumno> getAll(){
		return alumnos;
	}
	public Alumno getById(int codigo){
		//alumno que vamos a devolver
		Alumno alumno = null;
		//Alumno[] alum = null;
	
		for(int i = 0;i < alumnos.size();i++){
			//alumno con codigo a comparar
			Alumno al = alumnos.get(i);
			
			if(al.getCodigoAlumno()==codigo){
				alumno = al;
			}
		}
		
		return alumno;
	}
	public boolean delete(int id){
		int i = 0, longitud = alumnos.size();
		boolean encontrado = false;
		// || --> OR
		// && --> AND
		
		while (i<longitud&&encontrado==false){
			if(alumnos.get(i).getCodigoAlumno()==id){
				alumnos.remove(i);
				encontrado = true;
			}
			
			i++;
		}	
		return encontrado;
	}
	public Alumno create(Alumno alumno){
		int i = Alumno.CODIGOALUMNO;
		
		alumnos.add(alumno);
		//se captura el código de la base de datos
		i = alumno.getCodigoAlumno();
		
		return alumno;
	}
	public int update(Alumno alumno){
		
		for(Alumno al: alumnos){
			//encontrar por id
			if(al.getCodigoAlumno()==alumno.getCodigoAlumno()){
				//capturar la posicon
				int i = alumnos.indexOf(al);
				//lo vamos machacar
				//alumnos[i] = alumno;
				alumnos.add(i, alumno);
			}
		}
		return alumno.getCodigoAlumno();
	}
	private void init(){
		alumnos = new ArrayList<Alumno>();
		Alumno alumno = null;
		
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	//	GregorianCalendar calendar = new GregorianCalendar();
		
		try {
			alumno = new Alumno();
			alumno.setCodigoAlumno(0);
			alumno.setNombre("David");
			alumno.setApellidos("Aranzadi");
			alumno.setnHermanos(0);
			alumno.setfNacimiento(fmt.parse("12/09/1990"));
			//calendar.setTime(fmt.parse("12/09/1990"));
			
			alumnos.add(alumno);
		} catch (AlumnoException e) {
			//TODO Realizar logs
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			alumno = new Alumno();
			alumno.setCodigoAlumno(1);
			alumno.setNombre("Maria");
			alumno.setApellidos("Gonzalez");
			alumnos.add(alumno);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch(Exception e){
			e.getMessage();
		}

		try {
			alumno =  new Alumno();
			alumno.setCodigoAlumno(2);
			alumno.setNombre("Alexander");
			alumno.setApellidos("Revuelta");
			alumnos.add(alumno);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alumno al;
		try {
			al = new Alumno();
			if(alumno.equals(al)){
				
			}
		} catch (AlumnoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			alumno =  new Alumno();
			alumno.setCodigoAlumno(3);
			alumno.setNombre("Alain");
			alumno.setApellidos("Revuelta");
			alumnos.add(alumno);
			
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			alumno = new Alumno();
			alumno.setCodigoAlumno(4);
			alumno.setNombre("Carlos");
			alumno.setApellidos("Mateo");
			alumnos.add(alumno);
		} catch (AlumnoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Collections.sort(alumnos);
	}
}
