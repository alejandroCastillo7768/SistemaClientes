package com.clientes.func;

import java.io.BufferedWriter; 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Archivador {

	private Integer sufijo = 1;
	private String rutaSalida = "D:\\Pablo\\Workspace eclipse\\SistemaClientes\\DatosClientes";
	private String nombreSalida = null;
	private File archivoCliente;
	private FileOutputStream salidaArchivo;
	private ObjectOutputStream salidaObjeto;
	private FileInputStream entradaArchivo;
	private ObjectInputStream entradaObjeto;

	public void guardarCliente(Cliente cliente) {

		try {
			
			List<Cliente> listaClientes = new ArrayList<Cliente>();
			listaClientes.add(cliente);
			if (archivoCliente.exists()) sufijo += 1;
			nombreSalida = ("cliente" + sufijo + ".ser");
			archivoCliente = new File(rutaSalida, nombreSalida);
			
			
			System.out.println(archivoCliente);
			
			salidaArchivo = new FileOutputStream(archivoCliente);
			salidaObjeto = new ObjectOutputStream(salidaArchivo);
			salidaObjeto.writeObject(cliente);
			salidaObjeto.close();
			salidaArchivo.close();

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Excepción de E/S");
		} 	
	}

	public void recuperarCliente(Cliente cliente) {

		try {

			archivoCliente = new File("D:\\Pablo\\Workspace eclipse\\SistemaClientes\\tmp", "cliente.ser");
			entradaArchivo = new FileInputStream(archivoCliente);
			entradaObjeto = new ObjectInputStream(entradaArchivo);
			cliente = (Cliente) entradaObjeto.readObject();
			entradaObjeto.close();
			entradaArchivo.close();

		} catch (IOException e) {

			e.printStackTrace();
			System.out.println("Excepción de E/S");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("No se encontró el cliente");
		}
	}

}