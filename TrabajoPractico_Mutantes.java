/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajopractico_mutantes;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mauro
 */
public class TrabajoPractico_Mutantes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        System.out.println("Se generaran vectores aleatorios para la validación de los dna.\n");
        while (true) {
            String[] dna = generarSecuenciasAleatorias();
            String [][] dna= llenaMatriz(matrizAux)
            if (isMutant(dna)) {
                System.out.println("La persona con dna ingresado ES mutante");
            } else {
                System.out.println("La persona con dna ingresado NO es mutante");
            }
            System.out.println("Ingrese 'n' para salir del programa. De lo contrario ingrese cualquier tecla");
            Scanner sc = new Scanner(System.in);
            if ("n".equalsIgnoreCase(sc.nextLine())) {
                break;
            }
        }

    }

    public static boolean isMutant(String[] dna) {
        char[][] matDNA = new char[6][6];
        for (int x = 0; x < matDNA.length; x++) {
            for (int y = 0; y < matDNA[x].length; y++) {
                matDNA[x][y] = dna[x].charAt(y);
            }
        }
        muestraMatriz(matDNA);
        return buscarElementosSeguidos(matDNA);
    }

    public static boolean buscarElementosSeguidos(char[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;

        int n = 4;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (j + n <= columnas) {

                    if (sonIguales(matriz[i], j, j + n)) {
                        return true;
                    }
                }
                if (i + n <= filas) {
                    if (sonIgualesColumna(matriz, i, i + n, j)) {
                        return true;
                    }
                    if (j + n <= columnas) {
                        if (sonIgualesDiagonalPrincipal(matriz, i, j, n)) {
                            return true;
                        }
                    }
                    if (j - n + 1 >= 0) {
                        if (sonIgualesDiagonalInvertida(matriz, i, j, n)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // Función para verificar si n elementos en una fila son iguales
    public static boolean sonIguales(char[] fila, int inicio, int fin) {
        for (int i = inicio + 1; i < fin; i++) {
            if (fila[i] != fila[inicio]) {
                return false;
            }
        }
        return true;
    }

    public static boolean sonIgualesColumna(char[][] matriz, int inicioFila, int finFila, int columna) {
        for (int i = inicioFila + 1; i < finFila; i++) {
            if (matriz[i][columna] != matriz[inicioFila][columna]) {
                return false;
            }
        }
        return true;
    }

    public static boolean sonIgualesDiagonalPrincipal(char[][] matriz, int fila, int columna, int n) {
        for (int i = 1; i < n; i++) {
            if (matriz[fila + i][columna + i] != matriz[fila][columna]) {
                return false;
            }
        }
        return true;
    }

    public static boolean sonIgualesDiagonalInvertida(char[][] matriz, int fila, int columna, int n) {
        for (int i = 1; i < n; i++) {
            if (matriz[fila + i][columna - i] != matriz[fila][columna]) {
                return false;
            }
        }
        return true;
    }

    public static void muestraMatriz(char[][] mat) {
        for (char[] ind : mat) {
            for (char valor : ind) {
                System.out.print(valor + " | ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
    
        public static int[][] llenaMatriz() { //pide al usuario que llene la matriz
        Scanner sc = new Scanner(System.in);
        char[][] matrizAux= new char[6][6];
        for (int x = 0; x < matrizAux.length; x++) { //itera filas
            for (int y = 0; y < matrizAux[x].length; y++) {  //itera columnas
                System.out.println("Ingrese el valor: (" + x + ", " + y + ")");
                matrizAux[x][y] = sc.nextLine(); //asigna el valor ingresado a cada posicion
            }
        }
        return (matrizAux); //retorna matriz llena
    }

    public static String[] generarSecuenciasAleatorias() {
        String[] secuencias = new String[6];
        Random random = new Random();
        String opciones = "ATCG";

        for (int i = 0; i < 6; i++) {
            StringBuilder secuencia = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                int index = random.nextInt(opciones.length());
                secuencia.append(opciones.charAt(index));
            }
            secuencias[i] = secuencia.toString();
        }

        return secuencias;
    }
}
