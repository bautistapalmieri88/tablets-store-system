package EjercicioTablets;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//Inicia el programa en main - Organiza y delega tareas en la clase TareasTienda
				
		Scanner sc = new Scanner (System.in);
		
		TareasTienda Gestion = new TareasTienda();
		int opcion;
		
		System.out.println("App MitadMark");
		
		do {
			
			//menu de opciones
			System.out.println("Seleccione una opcion");
			System.out.println("1. Registrar *tablet*");
			System.out.println("2. Registrar *cliente*");
			System.out.println("3. Vender");
			System.out.println("4. Mostrar stock");
	        System.out.println("5. Mostrar clientes");
			System.out.println("0. Salir");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1: 
				Gestion.AltaTablet(sc); //tratar como objeto
				break;
			case 2: 
				Gestion.AltaCliente(sc);
				break;
			case 3:
				Gestion.VenderTablets(sc);
				break;
			case 4: 
				Gestion.MostrarStock(sc); 
				break;
            case 5: 
            		Gestion.MostrarClientes(sc); 
            	break;
            case 0:
            	System.out.println("Cerrando aplicación");
            	break;
				default:
					System.out.println("Selecciones una opcion correcta");
			}
		} while (opcion!=0);
	}

}
