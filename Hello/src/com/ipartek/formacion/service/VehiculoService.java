package com.ipartek.formacion.service;

import java.util.ArrayList;

import com.ipartek.formacion.bean.Vehiculo;

public class VehiculoService {

	private ArrayList<Vehiculo> vehiculos = null;
	
	public VehiculoService(){
		init();
	}
	public ArrayList<Vehiculo> getAll(){
		return vehiculos;
	}
	public int create(Vehiculo vehiculo){
		int codigo = Vehiculo.CODIGOVEHICULO;
		vehiculos.add(vehiculo);
		codigo = vehiculo.getCodigo();
		
		return codigo;
	}
	public Vehiculo getById(int codigo){
		Vehiculo vehiculo =  null;
		int i = 0, longitud = vehiculos.size();
		boolean encontrado = false;
		
		while(i < longitud && encontrado==false){
			Vehiculo v = vehiculos.get(i);
			if(codigo==v.getCodigo()){
				vehiculo = v;
				encontrado = true;
			}
			i++;
		}
		
		return vehiculo;
	}
	public void update(Vehiculo vehiculo){
		int i = 0, longitud = vehiculos.size();
		boolean encontrado = false;
		
		while (i < longitud && encontrado==false){
			
			if(vehiculos.get(i).getCodigo()==vehiculo.getCodigo()){
				vehiculos.add(i, vehiculo);
				encontrado = true;
			}
			
			i++;
		}
	}
	public void delete(int codigo){
		int i = 0, longitud = vehiculos.size();
		boolean encontrado = false;

		while (i < longitud && encontrado==false){
			
			if(vehiculos.get(i).getCodigo()==codigo){
				vehiculos.remove(i);
				encontrado = true;
			}
			
			i++;
		}

	}
	private void init(){
		vehiculos = new ArrayList<Vehiculo>();
		Vehiculo v1 =  new Vehiculo();
		Vehiculo v = new Vehiculo(1,"Seat","Leon");
		vehiculos.add(v);
		/*
		if(v.equals(v1)){
			System.out.println("Es igual");
		}else{
			System.out.println("no es igual");
		}
		*/
		v = new Vehiculo();
		v.setCodigo(2);
		v.setMarca("Renault");
		v.setModelo("Megane");
		vehiculos.add(v);
		v = new Vehiculo(3, "VolksWagen", "Polo");
		vehiculos.add(v);
		
		v = new Vehiculo(4, "Toyota", "Prius");
		vehiculos.add(v);
	}
}
