package root;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Enemy_Utility {

public static List<Enemy> generaEjercitoEnemigo(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Selecciona Idioma/ Select language: Español English");
	String idioma = sc.nextLine();
	List<Enemy> ejercito = new LinkedList<Enemy>();
	if(!idioma.equals("English")) {
	Boolean salida= true;
	System.out.println("Bienvenido al creador de ejercito hecho por Penedemadera Industries\n Ahora entrarás al bucle de creación de cada clase.");
	Random r = new Random();
while(salida) {
	System.out.println("¿De que clase quieres crear enemigos? Opciones:");
	for(int i =0;i<Clase.values().length;i++) {
		if(!Clase.values()[i].equals(Clase.ERROR)) {
			System.out.print(Clase.values()[i].toString()+ "  ");
		}
		if(i /10 ==1 && i %10 ==0) {
			System.out.println();
		}
	}
	System.out.println();
	String clas =sc.nextLine();
	Clase c = strToClase(clas);
	System.out.println("¿Cuántos quieres?");
	Integer cantidad = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduce el nivel más bajo");
	Integer nvBajo = sc.nextInt();
	sc.nextLine();
	System.out.println("Introduce el nivel más alto");
	Integer nvAlto = sc.nextInt();
	sc.nextLine();
	for(int i = 0;i < cantidad;i++) {
		Integer nv =r.nextInt((nvAlto+1)-nvBajo) +nvBajo;
		String name = c.toString()+ " nº"+(i+1);
		Enemy e = new Enemy(c, nv, name, true, null);
		ejercito.add(e);
	}
	System.out.println("¿Queres crear más de otras clases? Opciones: Si No");
	clas = sc.nextLine();
	if(clas.equals("No")) salida =false;
}
sc.close();}
	else {

		Boolean salida= true;
		System.out.println("Welcome to the army builder make by Penedemadera Industries\nNow you wanna join the loop of creation of characters.");
		Random r = new Random();
	while(salida) {
		System.out.println("What class has the enemy? Options:");
		for(int i =0;i<Clase.values().length;i++) {
			if(!Clase.values()[i].equals(Clase.ERROR)) {
				System.out.print(Clase.values()[i].toString()+ "  ");
			}
			if(i /10 ==1 && i %10 ==0) {
				System.out.println();
			}
		}
		System.out.println();
		String clas =sc.nextLine();
		Clase c = strToClase(clas);
		System.out.println("How many people do you want?");
		Integer cantidad = sc.nextInt();
		sc.nextLine();
		System.out.println("Write the lowest level possible of the enemies");
		Integer nvBajo = sc.nextInt();
		sc.nextLine();
		System.out.println("Write the highest level possible of the enemies");
		Integer nvAlto = sc.nextInt();
		sc.nextLine();
		for(int i = 0;i < cantidad;i++) {
			Integer nv =r.nextInt((nvAlto+1)-nvBajo) +nvBajo;
			String name = c.toString()+ " nº"+(i+1);
			Enemy e = new Enemy(c, nv, name, true, null);
			ejercito.add(e);
		}
		System.out.println("Do you want to create more people? Options: Yes No");
		clas = sc.nextLine();
		if(clas.equals("No")) salida =false;
	}
	sc.close();
	}
	return ejercito;
}

private static Clase strToClase(String clas) {
	Clase res = Clase.ERROR;
	for(int i =0; i<Clase.values().length;i++) {
		if(clas.equals(Clase.values()[i].toString())) {
			res = Clase.values()[i];
		}
	}
	return res;
}


public static void guardaEjercitoTXT(List<Enemy> ejercito) throws IOException {
	File inv = new File("output.txt");
	if(!inv.exists()) {
		System.out.println("No existe archivo en "+ inv.getAbsolutePath());
		inv.createNewFile();
		System.out.println("Creando archivo.");
	}
	BufferedWriter f = new BufferedWriter(new FileWriter(inv));
f.write("");
	List<String> escribe = ejercito.stream().map(x -> x.ToString()).collect(Collectors.toList());
	for(int i =0; i<escribe.size();i++) {
		f.write(escribe.get(i));
		f.newLine();
		f.newLine();
	}f.close();
}
}
