package progamacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;


public class Operaciones {

	/**
	 *Mètode que diu si el directori existe
	 *@param nombre nombre del directori
	 *@return boolean resultat del exist 
	 */
	
	public Boolean ExisteDirectorio(String nombre) {
		File file=new File(nombre);
		if(file.exists()) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 *Mètode que mostra les caracteristiques de cada fitxer del directori proporcionat
	 *@param direc nombre del directori
	 *@return String[] amb el dates 
	 */
	public String[][] OperacionBusca(String direc) {


		File directorio = new File(direc);
		String[] listaArchivos = directorio.list(new FiltroExtension(".txt"));
		
		for(int j=0;j<listaArchivos.length;j++) {
			listaArchivos[j]=direc+"/"+listaArchivos[j];
		}
		
		String arrayString[][]=null;
		arrayString=new String[20][4];
		

		for (int i = 0; i < listaArchivos.length; i++) {
			File fichero = new File(listaArchivos[i]);

			
			arrayString[i][0]=fichero.getName();
			arrayString[i][1]="Extension .txt";
			arrayString[i][2] ="La grandaria del archivo es " + fichero.length();
			arrayString[i][3]="La ultima modificacion fue " + new Date(fichero.lastModified());
			
		}
		return arrayString;
	}
	
	/**
	 *Mètode que indica la longitud del directori
	 *@return int indicant la longitud del directori 
	 */
	
	public int LonDir() {
		File directorio = new File(".");
		String[] listaArchivos = directorio.list(new FiltroExtension(".txt"));
		return listaArchivos.length;
	}

	/**
	 *Mètode ordena segon la preferencia del usuari
	 *@param direc nombre del directori, tipo numero per a saber cual orden elegir
	 *@return String[] amb el dates ordenades
	 */

	public String[][] OperacionOrden(int tipo,String direc) throws IOException {

		File directorio = new File(direc);
		String[] listaArchivos = directorio.list(new FiltroExtension(".txt"));
		
		for(int j=0;j<listaArchivos.length;j++) {
			listaArchivos[j]=direc+"/"+listaArchivos[j];
		}
		String arrayString[][]=null;
		arrayString=new String[20][4];
		
		switch (tipo) {
		case 1:
			Arrays.sort(listaArchivos);
			break;
		case 2:
			Arrays.sort(listaArchivos,Collections.reverseOrder());
			break;
		case 3:
			
			File[] arrayFichero=null;
			arrayFichero=new File[listaArchivos.length];
			
			
			for (int i = 0; i < listaArchivos.length; i++) {
				File fichero = new File(listaArchivos[i]);
				arrayFichero[i]=fichero;
			}
			Arrays.sort(arrayFichero,(a,b) -> Long.compare(a.length(),b.length()));

			
			for(int i=0;i<listaArchivos.length;i++) {
				
				listaArchivos[i]=direc+"/"+arrayFichero[i].getName();
			}
			break;
		case 4:
			File[] arrayFichero1=null;
			arrayFichero1=new File[listaArchivos.length];
			
			for (int i = 0; i < listaArchivos.length; i++) {
				File fichero = new File(listaArchivos[i]);
				arrayFichero1[i]=fichero;
			}
			
			Arrays.sort(arrayFichero1,(a,b) -> -Long.compare(a.length(),b.length()));
			for(int i=0;i<listaArchivos.length;i++) {
				listaArchivos[i]=direc+"/"+arrayFichero1[i].getName();
			}
			break;
			
		case 5:
			File[] arrayFichero11=null;
			arrayFichero11=new File[listaArchivos.length];
			
			for (int i = 0; i < listaArchivos.length; i++) {
				File fichero = new File(listaArchivos[i]);
				arrayFichero11[i]=fichero;
			}
			
			Arrays.sort(arrayFichero11,(a,b) -> Long.compare(a.lastModified(),b.lastModified()));
			for(int i=0;i<listaArchivos.length;i++) {
				listaArchivos[i]=direc+"/"+arrayFichero11[i].getName();
			}
			break;
		case 6:
			File[] arrayFichero111=null;
			arrayFichero111=new File[listaArchivos.length];
			
			for (int i = 0; i < listaArchivos.length; i++) {
				File fichero = new File(listaArchivos[i]);
				arrayFichero111[i]=fichero;
			}
			
			Arrays.sort(arrayFichero111,(a,b) -> -Long.compare(a.lastModified(),b.lastModified()));
			for(int i=0;i<listaArchivos.length;i++) {
				listaArchivos[i]=direc+"/"+arrayFichero111[i].getName();
			}
			break;
			
		}
		
		for (int i = 0; i < listaArchivos.length; i++) {
			//System.out.println(listaArchivos[i]);
			File fichero = new File(listaArchivos[i]);
			
			//System.out.print(listaArchivos[i]);
			arrayString[i][0]="Nombre del archivo " + fichero.getName();
			arrayString[i][1]="Extension .txt";
			arrayString[i][2] ="La grandaria del archivo es " + fichero.length();
			arrayString[i][3]="La ultima modificacion fue " + new Date(fichero.lastModified());
			
		}
		return arrayString;

	}

	
	/**
	 *Mètode que Selecciona el fitxers i crea una unio amb la fusió
	 *@param direc nombre del directori, nuevoFic nom del nou fitxer,ficherosSelect los fichero seleccionas en al JList
	 *@return Boolean per a saber que se ejecuta
	 */
	
	public Boolean OperacionSeleccion(String nuevoFic,String[] ficherosSelect,String direc) throws IOException {

		File[] arrayFile=new File[ficherosSelect.length];
		
		for(int j=0;j<ficherosSelect.length;j++) {
			System.out.println(ficherosSelect[j]);
			ficherosSelect[j]=direc+"/"+ficherosSelect[j];
			arrayFile[j]=new File(ficherosSelect[j]);
		}
		
		String nou=direc+"/"+nuevoFic;
		
		File nf = new File(nou);

		if (nf.exists()) {
			System.out.println("El nombre del fichero existe");
		} else {

			for (int i = 0; i < arrayFile.length; i++) {

				FileReader fr = new FileReader(arrayFile[i]);
				BufferedReader br = new BufferedReader(fr);
				FileWriter fw = new FileWriter(nf, true);
				BufferedWriter bw = new BufferedWriter(fw);
				String linea = br.readLine();

				while (linea != null) {
					//System.out.println("Copiando " + linea + " de " + ficheroOriginal + " a " + nuevoFichero);
					bw.write(linea + '\n');
					linea = br.readLine();
				}
				System.out.println(" ");
				System.out.println("Copiando");
				br.close();
				bw.close();

			}
		}
		return true;
	}


	/**
	 *Mètode lee el fichero y el pasa a string
	 *@param fichero nom del fitxer a llegir
	 *@return String texto del archivo
	 */
	public String leeFichero(String fichero) {
		String texto="";
		try {
            FileReader entrada=new FileReader(fichero);

                int c=0;

                while(c!=-1) {
                    c=entrada.read();

                    char letra=(char)c;

                    texto+=letra;
                }

                entrada.close();

        } catch (IOException e) {

            System.out.println("No se ha encontrado el archivo");
        }
		return texto;
	}
	
	/**
	 *Mètode que busca les coincidencies de la paraula en tots els fitxers del directori proporcionat
	 *@param direc nombre del directori, strPa paraula a sercar
	 *@return String amb les coincidencies
	 */
	public String OperacionCoincidencia(String strPa,String direc) {
		Operaciones lasOperaciones=new Operaciones();

		String sol=" ";
		File directorio = new File(direc);
		String[] listaArchivos = directorio.list(new FiltroExtension(".txt"));
		
		for(int j=0;j<listaArchivos.length;j++) {
			listaArchivos[j]=direc+"/"+listaArchivos[j];
		}
		for(int i=0;i<listaArchivos.length;i++) {
		
		
		String strPalabra=strPa;
		
		String str=lasOperaciones.leeFichero(listaArchivos[i]);

		   int matches = 0;
		   for(int j = 0; j < str.length()-(strPalabra.length()-1); ++j)
		   {
		     if(str.substring(j,j+strPalabra.length()).equals(strPalabra))++matches;
		   }
			sol=sol+listaArchivos[i]+":"+String.valueOf(matches)+"  ";
			

		}
		System.out.println(sol);
		return sol;
		}
	
}
