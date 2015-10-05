package com.ipartek.formacion.bean;

import java.util.Calendar;
import java.util.Date;

public class Vehiculo {

	public static final int CODIGOVEHICULO = -1;
	public static final String MSGERROR_CODIGO="Codigo Incorrecto";
	public static final double PRECIO_VALIDO = 0.0;
	public static final String MSGERROR_PRECIO = "Precio introducido Erroneo";
	
	private int codigo;
	private String marca;
	private String modelo;
	private int nPlazas;
	private Date fechaCompra;
	private double precio;
	
	
	
	public Vehiculo() {
		super();
		setCodigo(0);
		setMarca("");
		setModelo("");
		setnPlazas(1);
		setFechaCompra(Calendar.getInstance().getTime());
		setPrecio(0.0);
	}
	public Vehiculo(int codigo, String marca, String modelo) {
		super();
		setCodigo(codigo);
		setMarca(marca);
		setModelo(modelo);
		setnPlazas(1);
		setFechaCompra(Calendar.getInstance().getTime());
		setPrecio(0.0);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if(codigo>CODIGOVEHICULO)
			this.codigo = codigo;
		else
			System.out.println(MSGERROR_CODIGO);
			
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getnPlazas() {
		return nPlazas;
	}
	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}
	public Date getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		if(precio>=PRECIO_VALIDO)
			this.precio = precio;
		else
			System.out.println(MSGERROR_PRECIO);
	}
	@Override
	public boolean equals(Object obj) {
		boolean igual = false;
		//comprobar que obj es una instancia de vehiculo
		if(obj instanceof Vehiculo){
			//realizamos el casting
			Vehiculo v = (Vehiculo) obj;
		//((Vehiculo)obj).getCodigo();	
			if(this.codigo == v.getCodigo()){
				igual = true;
			}
		}else{
			System.out.println("Sólo se pueden comparar vehiculos");
		}
		return igual;
	}
	
	
	
	
	
}
