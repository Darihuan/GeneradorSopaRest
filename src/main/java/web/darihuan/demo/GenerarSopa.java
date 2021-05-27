package web.darihuan.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.stereotype.Service;

public class GenerarSopa {
	char tablero[][];
	int size;
	List<String> words;

//	public GenerarSopa() {
//
//		this.size = 0;
//		this.words = new HashMap<String, Integer>();
//		Entrada();
//		this.tablero = new char[size][size];
//		resettablero();
//		rellenar(words);
//		rellenarVacios();
//		try {
//			creartxt();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	public GenerarSopa(int size,List<String> words) {

		this.size = 0;
		this.words = words;
		
		this.tablero = new char[size][size];
		resettablero();
		rellenar(words);
		rellenarVacios();
	

	}
	
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public GenerarSopa(int size) {

		this.size = size;
		this.words = new ArrayList<String>();
		this.tablero = new char[size][size];
		resettablero();
		rellenarVacios();

	}


//	public void Entrada() {
//		Scanner in = new Scanner(System.in);
//		System.out.println("Introduce Tama�o del tablero:");
//		int size = Integer.parseInt(in.nextLine());
//		this.size = size;
//		System.out.println("�Cu�ntas Palabras Quieres Buscar?");
//		int npalabras = Integer.parseInt(in.nextLine());
//		System.out.println("introduce palabra  y  acontinuacion veces que que quieres que aparezca.");
//
//		for (int i = 0; i < npalabras; i++) {
//
//			String palabra = in.nextLine().toUpperCase();
//			int nveces = Integer.parseInt(in.nextLine());
//			words.
//
//		}
//
//	}

	public void resettablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = ' ';
			}
		}

	}

	public String tablerotoString() {
		StringBuilder devolver = new StringBuilder();
		devolver.append(size + "\n");
		devolver.append(size + "\n");
		for (char[] cs : tablero) {
			for (char c : cs) {
				devolver.append(c);
			}
			devolver.append("\n");
		}
		devolver.append(words.size() + "\n");
		
		for (String string : words) {
			devolver.append(string + "\n");
		}
		return devolver.toString();
	}

	public void rellenar(List<String> words) {
		
		for (String string : words) {
		
				int opcion = generaraleatorio();
				if (opcion == 1)
					Horizontal(string);
				else if (opcion == 2)
					Vertical(string);
				else if (opcion == 3)
					diagonalIzquierda(string);
				else if (opcion == 4)
					diagonalderecha(string);
			}
		

	}

	public void rellenarVacios() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				if (tablero[i][j] == ' ') {
					tablero[i][j] = caracteraleatorio();
				}
			}
		}
	}

	public char caracteraleatorio() {
		String alphabet = "ABCDEFGHIJKLMN�OPQRSTUWYZ";
		int random = (int) (Math.random() * 25);
		char caracter = alphabet.charAt(random);
		return caracter;
	}

	public void Horizontal(String palabra) {
		int[] coordenadas = espacioHorizontal(palabra);
		int x = coordenadas[0];
		int y = coordenadas[1];
		if (generaraleatorio() < 3) {
			int indice = 0;
			for (int i = y; i < y + palabra.length(); i++) {
				tablero[x][i] = palabra.charAt(indice);
				indice++;
			}

		} else {
			int indice = palabra.length() - 1;
			for (int i = y; i < y + palabra.length(); i++) {
				tablero[x][i] = palabra.charAt(indice);
				indice--;
			}
		}

	}

	public int[] espacioHorizontal(String palabra) {
		int coordenadas[] = new int[2];
		boolean condicion = true;
		while (condicion) {
			int x = coordenadaaleatoria();
			int y = coordenadaaleatoria();
			int caracter = 0;
			if (y + palabra.length() <= tablero[0].length) {
				for (int j = y; j < y + palabra.length(); j++) {
					if (tablero[x][j] == ' ') {
						caracter++;

					}

				}

				if (caracter == palabra.length()) {
					coordenadas[0] = x;
					coordenadas[1] = y;
					condicion = false;
				}
				caracter = 0;

			}
		}
		return coordenadas;

	}

	public void Vertical(String palabra) {
		int[] coordenadas = espacioVertical(palabra);
		int x = coordenadas[0];
		int y = coordenadas[1];
		if (generaraleatorio() < 3) {
			int indice = 0;
			for (int i = x; i < x + palabra.length(); i++) {
				tablero[i][y] = palabra.charAt(indice);
				indice++;
			}

		} else {
			int indice = palabra.length() - 1;
			for (int i = x; i < x + palabra.length(); i++) {
				tablero[i][y] = palabra.charAt(indice);
				indice--;
			}
		}

	}

	public int[] espacioVertical(String palabra) {

		int coordenadas[] = new int[2];
		boolean condicion = true;
		while (condicion) {
			int x = coordenadaaleatoria();
			int y = coordenadaaleatoria();
			int caracter = 0;
			if (x + palabra.length() <= tablero.length) {
				for (int j = x; j < x + palabra.length(); j++) {
					if (tablero[j][y] == ' ') {
						caracter++;

					}

				}

				if (caracter == palabra.length()) {
					coordenadas[0] = x;
					coordenadas[1] = y;
					condicion = false;
				}
				caracter = 0;

			}
		}
		return coordenadas;

	}

	public void diagonalIzquierda(String palabra) {
		int[] coordenadas = espacioDiagonal(palabra);
		int x = coordenadas[0];
		int y = coordenadas[1];
		if (generaraleatorio() < 3) {
			int indice = 0;
			for (int i = x; i < x + palabra.length(); i++) {
				tablero[i][y] = palabra.charAt(indice);
				y++;
				indice++;
			}

		} else {
			int indice = palabra.length() - 1;
			for (int i = x; i < x + palabra.length(); i++) {
				tablero[i][y] = palabra.charAt(indice);
				y++;
				indice--;
			}
		}
	}

	public int[] espacioDiagonal(String palabra) {

		int coordenadas[] = new int[2];
		boolean condicion = true;
		while (condicion) {
			int x = coordenadaaleatoria();
			int y = coordenadaaleatoria();
			int ycopia = y;
			int caracter = 0;
			if ((x + palabra.length() < tablero.length) && (y + palabra.length() < tablero[0].length)) {
				for (int j = x; j < x + palabra.length(); j++) {
					if (tablero[j][ycopia] == ' ') {
						caracter++;
						ycopia++;

					}

				}

				if (caracter == palabra.length()) {
					coordenadas[0] = x;
					coordenadas[1] = y;
					condicion = false;
				}
				caracter = 0;

			}
		}
		return coordenadas;

	}

	public void diagonalderecha(String palabra) {
		int[] coordenadas = espacioDiagonalderecha(palabra);
		int x = coordenadas[0];
		int y = coordenadas[1];
		if (generaraleatorio() < 3) {
			int indice = 0;
			for (int i = x; i > x - palabra.length(); i--) {
				tablero[i][y] = palabra.charAt(indice);
				y--;
				indice++;
			}

		} else {
			int indice = palabra.length() - 1;
			for (int i = x; i > x - palabra.length(); i--) {
				tablero[i][y] = palabra.charAt(indice);
				y--;
				indice--;
			}
		}

	}

	public int[] espacioDiagonalderecha(String palabra) {

		int coordenadas[] = new int[2];
		boolean condicion = true;
		while (condicion) {
			int x = coordenadaaleatoria();
			int y = coordenadaaleatoria();
			int ycopia = y;
			int caracter = 0;
			if ((x - palabra.length()) > 0 && (y - palabra.length()) > 0) {
				for (int j = x; j > x - palabra.length(); j--) {
					if (tablero[j][ycopia] == ' ') {
						caracter++;
						ycopia--;

					}

				}

				if (caracter == palabra.length()) {
					coordenadas[0] = x;
					coordenadas[1] = y;
					condicion = false;
				}
				caracter = 0;

			}
		}
		return coordenadas;

	}

	public int coordenadaaleatoria() {
		return (int) (Math.random() * (tablero.length - 1));
	}

	public static int generaraleatorio() {
		return (int) (Math.random() * 4) + 1;
	}

	public void creartxt() throws IOException {
		String ruta = "C:/data/sopa.txt";
		String contenido = tablerotoString();
		File file = new File(ruta);
		// Si el archivo no existe es creado
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(contenido);
		bw.close();
	}
	public String atexto(){
		String cadena="";
		for (char[] cs : tablero) {
			for (char c : cs) {
				cadena+=c;
			}
			cadena+="\n";
		}
		return cadena;
	}
	



}
