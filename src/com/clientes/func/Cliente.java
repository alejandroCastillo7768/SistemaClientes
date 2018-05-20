package com.clientes.func;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L; // esto es para que el eclipse no joda

	private int numCliente;
	private String nombre;
	private int telefono;
	
	public Cliente(int numCliente, String nombre, int telefono) {
		
		this.numCliente = numCliente;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public int numCliente() {
		return numCliente;
	}
	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}