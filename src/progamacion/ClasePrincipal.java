package progamacion;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ClasePrincipal {

	Operaciones lasOperaciones;
	/**
	 *Mètode que llama a la interfaz 
	 */

	public ClasePrincipal() throws IOException {
		
		lasOperaciones = new Operaciones();

		Visual interfaz = new Visual();
		interfaz.asignaOperaciones(lasOperaciones);
		interfaz.setVisible(true);  
		//menu();
	}

	/**
	 *Mètode per a ejecutar per comands
	 */
	/*public void menu() throws IOException {

		Scanner scOp = new Scanner(System.in);
		System.out.println("Introduce la operacion a realizar: ");
		String strOp = scOp.nextLine();
		int op = Integer.parseInt(strOp);

		switch (op) {
		case 1:
			//lasOperaciones.OperacionBusca();
			break;
		case 2:
			Scanner sc = new Scanner(System.in);
			System.out.print("Introduce el txt a buscar : ");
			String strCoincidencia = sc.nextLine();
			//lasOperaciones.OperacionCoincidencia(strCoincidencia);
			break;
		case 3:
			//lasOperaciones.OperacionSeleccion();
			break;
		case 4:
			//lasOperaciones.OperacionOrden();

		}

	}*/

}
