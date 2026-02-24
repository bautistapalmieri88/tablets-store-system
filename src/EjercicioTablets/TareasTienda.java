package EjercicioTablets;

import java.util.ArrayList;
import java.util.Scanner;

public class TareasTienda {
	
	//Gestion de las tareas relacionadas con el tipo de tienda y actividad
	
	ArrayList <Tablets> ListaTablets = new ArrayList <>();
	ArrayList <Clientes> ListaClientes = new ArrayList <>();
	
	protected void AltaTablet (Scanner sc) {
			
		System.out.println("Ingresa el número id de la tablet");	
		String id_tablet = sc.nextLine();
		
		if (BuscarTabletsId(id_tablet)!=null) {
			System.out.println("Esta tablet ya se ha registrado");
			return;
		}
		
		System.out.println("Ingresa el precio de compra");
		double precio = sc.nextInt();		
		sc.nextLine();	
		
		System.out.println("Ingresa el color");
		String color = sc.nextLine();
		
		System.out.println("Ingresa el tamaño");
		String tamaño = sc.nextLine();
		
		System.out.println("Ranura SIM");
		System.out.println("SI/NO");
		boolean sim;
		String respuesta1 = sc.nextLine();
		if (respuesta1.equalsIgnoreCase("si")) {
			sim = true;
		} else {
			sim = false;
		}
		
		System.out.println("Camara");
		System.out.println("SI/NO");
		boolean camara;
		String respuesta2 = sc.nextLine();
		if (respuesta2.equalsIgnoreCase("si")) {
			camara = true;
		} else {
			camara = false;
		}
		
		System.out.println("Ingresa la marca");
		String marca = sc.nextLine();
		  
		//Instanciamos el objeto TABLET
		Tablets t = new Tablets(color, marca, tamaño, id_tablet, sim, camara, precio); 
		//Añadimos en lista
		ListaTablets.add(t); 
		System.out.println("Tablet registrada correctamente " + t);
	}
	
	protected void AltaCliente (Scanner sc) {
		
		System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();
        System.out.println("DNI:");
        String dni = sc.nextLine();
        System.out.println("Edad:");
        int edad = sc.nextInt();
        sc.nextLine();
        
        Clientes c = BuscarClientesPorDni(dni); //metodos de busqueda en lista

        if (c!=null) {
        	System.out.println("Cliente ya registrado");
        	return;
        } 
        
      //Instanciamos el objeto CLIENTE
        c = new Clientes(dni, nombre, edad);
        ListaClientes.add(c);
        System.out.println("Cliente registrado con numero: " + c.getId_cliente());
	}
	
	 protected void VenderTablets(Scanner sc) {
		
	        System.out.println("Ingrese el ID del cliente:");
	        int id = sc.nextInt();
	        sc.nextLine();
	        
	        Clientes c = BuscarClientesPorId(id);    
	        if (c==null) {
	            System.out.println("Cliente no encontrado");
	            return;
	        }       

	        System.out.println("Ingrese ID de la tablet a comprar:");
	        String idTablet = sc.nextLine();
	        
	        Tablets t = BuscarTabletsId(idTablet);
	        if (t == null) {
	            System.out.println("Tablet no disponible");
	            return;
	        }

	        System.out.println("Solicitar pago");
	        System.out.println("Indicar si el pago fue aceptado");
	        System.out.println("1. Aceptado");
	        System.out.println("2. Rechazado");
	        int pago = sc.nextInt();
	        sc.nextLine();

	        if (pago == 1) {
	        	c.comprasTablets(t);
	        	ListaTablets.remove(t);   
	            System.out.println("Tablet "+t.getId_tablet()+ "comprada por "+c.getNombre()+" con código "+c.getId_cliente());
	        } else {
	            System.out.println("Venta cancelada");
	        }
	    }
	 
	 protected void MostrarStock (Scanner sc) {
		 //mostrar tablets de la lista de tablets asociada a la tienda
		 System.out.println("Stock disponible:");
	        for (Tablets t : ListaTablets) {
	            System.out.println(t.toString());
	        }
	       
	 }
	 
	 protected void MostrarClientes  (Scanner sc) {
		 //muestra clientes y en el metodo to string agregamos la lista de tablets asociada a clientes
		 System.out.println("Clientes registrados:");
	        for (Clientes c : ListaClientes) {
	            System.out.println(c.toString());
	        }
	 }
	 
	 //Metodos de tareas - evita repeticion de codigo
	 protected Clientes BuscarClientesPorDni (String dni) {
		 for (Clientes c : ListaClientes) {
	        if (c.getDni().equalsIgnoreCase(dni)) {
	        	return c;
	        }
	    }
	    return null;
	 }
	 
	 protected Clientes BuscarClientesPorId (int id) {
		 for (Clientes c : ListaClientes) {
	        if (c.getId_cliente()==id) {
	        	return c;
	        }
	    }
	    return null;
	 }
	 
	 protected Tablets BuscarTabletsId (String id) {
		 for (Tablets t : ListaTablets) {
	        if (t.getId_tablet().equalsIgnoreCase(id)) {
	            return t;
	        }
	    }
	    return null;
	}
 }





