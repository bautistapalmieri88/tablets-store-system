package EjercicioTablets;

import java.util.ArrayList;

public class Clientes {
	
	protected String dni, nombre;
	protected int edad, id_cliente;
	protected ArrayList<Tablets> compras; //Incorporamos lista para gestionar la compra de tablets
	protected static int contador = 1; //"contador" global, cada objeto instanciado va comportarse sobre el mismo contador, es decir, nunca se va a repetir un numero de id
	
	
	
	protected Clientes(String dni, String nombre, int edad) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.id_cliente = contador++;
		this.compras = new ArrayList<>();
	}

	protected String getDni() {
		return dni;
	}



	protected void setDni(String dni) {
		this.dni = dni;
	}



	protected String getNombre() {
		return nombre;
	}



	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}



	protected int getEdad() {
		return edad;
	}



	protected void setEdad(int edad) {
		if (edad >= 12) {
			this.edad = edad;
		}
	}



	protected int getId_cliente() {
		return id_cliente;
	} 



	protected void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	protected ArrayList<Tablets> getCompras() {
		return compras;
	}

	protected void setCompras(ArrayList<Tablets> compras) {
		this.compras = compras;
	}

	@Override
	public String toString() {
		return "Cliente con id: "+id_cliente+" \n DNI=" + dni + "\n Nombre=" + nombre + "\n Edad=" + edad + "\n Tablet/s compradas=\n" + compras ;
	}

	protected void comprasTablets (Tablets t) {
		compras.add(t); //agregamos objeto tablet 
	}

}
