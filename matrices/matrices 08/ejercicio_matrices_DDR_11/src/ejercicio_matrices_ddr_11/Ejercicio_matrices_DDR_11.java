package ejercicio_matrices_ddr_11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_matrices_DDR_11 {

    public static void main(String[] args) {

        //Pido el nombre de un fichero
        File f = pedirNombreFichero();

        //Si no es nulo, seguimos
        if (f != null) {

            //leo el fichero y paso los datos a una matriz
            int[][] matriz = leerFichero(f);

            //Si no es nulo seigo
            if (matriz != null) {

                //Si la matriz es simetrica lo hacemos de una manera y sino de otra
                if (esMatrizSimetrica(matriz)) {
                    trasponerMatrizSimetrica(matriz);
                } else {
                    matriz = trasponerMatrizNoSimetrica(matriz);
                }

                //Guardo el fichero donde se guardara
                File f_guardar = new File((f.getName().split("\\."))[0] + "_T.txt");

                //guardo la matriz en el fichero
                guardarMatrizFichero(f_guardar, matriz);

                System.out.println("Fichero guardado");

            } else {
                System.out.println("Error, comprueba el fichero");
            }

        } else {
            System.out.println("El fichero no existe");
        }

    }

    /**
     * Pide el nombre del fichero
     *
     * @return
     */
    public static File pedirNombreFichero() {

        Scanner sn = new Scanner(System.in);

        System.out.println("Escribe el nombre de un fichero");
        String nombre = sn.next();

        File f = new File(nombre);

        //si exsite el fichero, lo devuelvo
        if (f.exists()) {
            return f;
        } else {
            return null;
        }

    }

    /**
     *
     * @param f
     * @return
     */
    public static int[][] leerFichero(File f) {

        int[][] matriz = null;
        try {
            Scanner sn = new Scanner(f);

            int filas = 0, columnas = 0, contador = 0;
            //Mientras haya numeros continuo
            while (sn.hasNextInt()) {

                //Segun el contador, hago una u otra
                switch (contador) {
                    case 0:
                        //Cojo las filas
                        filas = sn.nextInt();
                        break;
                    case 1:
                        //Cojo las columnas y creo la matriz
                        columnas = sn.nextInt();
                        matriz = new int[filas][columnas];

                        break;
                    default:
                        //obtengo la fila y la columna
                        matriz[(contador - 2) / columnas][(contador - 2) % columnas] = sn.nextInt();
                }

                contador++;
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_matrices_DDR_11.class.getName()).log(Level.SEVERE, null, ex);
        }

        return matriz;

    }

    /**
     * Indico si es o no simetrica la matriz
     *
     * @param matriz
     * @return
     */
    public static boolean esMatrizSimetrica(int[][] matriz) {

        return matriz.length == matriz[0].length;

    }

    /**
     * Traspongo una matriz
     *
     * @param matriz
     */
    public static void trasponerMatrizSimetrica(int[][] matriz) {

        //Creo una matriz de booleanos para indicar los indices que se hicieron cambios
        boolean[][] cambios = new boolean[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                //Sino hay continuo
                if (!cambios[i][j]) {
                    intercambio(matriz, i, j);
                    //marco el cambio
                    cambios[i][j] = true;
                    cambios[j][i] = true;
                }
            }
        }

    }

    /**
     * Trapongo una matriz no simetrica
     *
     * @param matriz
     * @return
     */
    public static int[][] trasponerMatrizNoSimetrica(int[][] matriz) {

        //Creo una nueva matriz
        int[][] matrizTraspuesta = new int[matriz[0].length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                intercambio(matriz, matrizTraspuesta, i, j);
            }
        }

        return matrizTraspuesta;

    }

    /**
     * Intercambia una posicion por otra
     * @param matriz
     * @param i
     * @param j 
     */
    public static void intercambio(int[][] matriz, int i, int j) {

        int aux = matriz[i][j];
        matriz[i][j] = matriz[j][i];
        matriz[j][i] = aux;

    }

    /**
     * Intercambio de valores en dos matrices
     * @param matriz
     * @param matrizT
     * @param i
     * @param j 
     */
    public static void intercambio(int[][] matriz, int[][] matrizT, int i, int j) {

        matrizT[j][i] = matriz[i][j];

    }

    /**
     * Guarda la matriz en un fichero
     * @param f
     * @param matriz 
     */
    public static void guardarMatrizFichero(File f, int[][] matriz) {

        try {
            PrintWriter pw = new PrintWriter(f);

            //guardo las filas y columnas
            pw.print(matriz.length + " ");
            pw.print(matriz[0].length + " ");

            //Guardo los datos
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    pw.print(matriz[i][j] + " ");
                }
            }

            pw.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_matrices_DDR_11.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
