package conexionssh;

import java.util.Scanner;

public class EntradaSalida {
	
	public static void mostrarMenu()
	{
		System.out.println("---------------------------------------------");
		System.out.println("---------------MENÚ PRINCIPAL----------------" + "\n");
		System.out.println("-- 1. Buscar patologías por nombre. 	   --");
		System.out.println("-- 2. Buscar síntomas por nombre.          --");
		System.out.println("-- 3. Listar patologías.                   --");
		System.out.println("-- 4. Buscar lista patología por síntomas. --");
		System.out.println("-- 5. Listar síntomas por patología.       --");
		System.out.println("---------------------------------------------");
	}
	
	
	
	public static int recogerOpcion()
	{
		int opcion = 0;
		Scanner sc = new Scanner (System.in);
		opcion = sc.nextInt();
		return opcion;
	}
	
	public static String recogerPatologia()
	{
		String patologia = null;
		Scanner sc = new Scanner (System.in);
		System.out.println("Introduzca nombre de patología:");
		patologia = sc.nextLine();
		return patologia;
	}

}
