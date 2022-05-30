package ejercicio_matrices_ddr_10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_matrices_DDR_10 {

    //Constantes
    final static int NOTA_MINIMA = 4;
    final static int NUMERO_NOTAS = 4;

    final static int COLUMNA_EXAMEN = 0;
    final static int COLUMNA_PRACTICAS = 1;
    final static int COLUMNA_TRABAJO = 2;
    final static int COLUMNA_PARTICIPACION = 3;

    final static double PORC_EX_FINAL = 0.5;
    final static double PORC_PRACTICAS = 0.25;
    final static double PORC_TRABAJO = 0.15;
    final static double PORC_PARTICIPACION = 0.1;

    public static void main(String[] args) {

        //Num alumnos 
        int n = 4;
        notas(n);

    }

    public static void notas(int n) {

        //Creo las matrices de las asignaturas
        double notas_FPI[][] = new double[n][NUMERO_NOTAS];
        double notas_FPII[][] = new double[n][NUMERO_NOTAS];

        //Leemos los ficheros de las notas y los guardamos en la matriz
        leeFichero("notas_FPI.txt", notas_FPI);
        leeFichero("notas_FPII.txt", notas_FPII);

        //Calcular las notas finales de cada asignatura
        double[] notas_finales_FPI = calcularNotas(notas_FPI);
        double[] notas_finales_FPII = calcularNotas(notas_FPII);

        //compruebo si hay un suspenso en FPI, en FPII no estara calificado
        comprobarNotas(notas_finales_FPI, notas_finales_FPII);

        //Motramos las notas
        System.out.println("FPI");
        mostrarArray(notas_finales_FPI);

        System.out.println("FPII");
        mostrarArray(notas_finales_FPII);

        //Mostramos los aprobados y suspensos
        System.out.println("Numero de aprobados FPI: " + aprobados(notas_finales_FPI));
        System.out.println("Numero de suspensos FPI: " + suspensos(notas_finales_FPI));

        System.out.println("Numero de aprobados FPII: " + aprobados(notas_finales_FPI));
        System.out.println("Numero de suspensos FPII: " + suspensos(notas_finales_FPI));

    }

    /**
     * Leemos un fichero y lo relleno en la matriz
     *
     * @param fichero
     * @param matriz
     */
    public static void leeFichero(String fichero, double[][] matriz) {

        File f = new File(fichero);

        try {
            Scanner sn = new Scanner(f);
            //importante de usar si pones puntos en las notas
            sn.useLocale(Locale.US);

            double nota;
            int i = 0, j = 0;
            //mientras haya un double, seguimos
            while (sn.hasNextDouble()) {

                //cojo la nota
                nota = sn.nextDouble();

                //relleno la nota
                matriz[i][j] = nota;

                //Miro si me he pasado de indice
                if (j < matriz[0].length - 1) {
                    j++;
                } else {
                    i++;
                    j = 0;
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio_matrices_DDR_10.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Calcula la nota de los alumnos
     *
     * @param notas
     * @return
     */
    public static double[] calcularNotas(double[][] notas) {

        //creo donde lo voy a almacenar
        double[] notasFinales = new double[notas.length];
        double notaFinal = 0;
        //indica si tienes la nota minima
        boolean notaMinima = true;
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[0].length; j++) {

                //Segun la columna, haremos una cosa u otra
                switch (j) {
                    case COLUMNA_EXAMEN:

                        //si la nota minimo es menor que 4, ya no tiene nota minima
                        if (notas[i][j] < NOTA_MINIMA) {
                            notaMinima = false;
                        }

                        //Calculo nota
                        notaFinal += notas[i][j] * PORC_EX_FINAL;

                        break;
                    case COLUMNA_PRACTICAS:

                        //si la nota minimo es menor que 4, ya no tiene nota minima
                        if (notas[i][j] < NOTA_MINIMA) {
                            notaMinima = false;
                        }

                        //Calculo nota
                        notaFinal += notas[i][j] * PORC_PRACTICAS;

                        break;
                    case COLUMNA_TRABAJO:

                        //Calculo nota
                        notaFinal += notas[i][j] * PORC_TRABAJO;

                        break;
                    case COLUMNA_PARTICIPACION:

                        //Calculo nota
                        notaFinal += notas[i][j] * PORC_PARTICIPACION;

                        break;
                }

            }

            //si la nota minima no se cumple, se queda en 3
            if (notaMinima) {
                notasFinales[i] = notaFinal;
            } else {
                notasFinales[i] = 3;
            }

            //reinicio
            notaFinal = 0;
            notaMinima = true;

        }

        return notasFinales;

    }

    /*
    public static double[] calcularNotas(double[][] notas) {

        double[] notasFinales = new double[notas.length];
        double notaFinal = 0;
        boolean notaMinima = true;
        for (int i = 0; i < notas.length; i++) {

            if (notas[i][0] < NOTA_MINIMA) {
                notaMinima = false;
            }

            notaFinal += notas[i][0] * PORC_EX_FINAL;

            if (notas[i][1] < NOTA_MINIMA) {
                notaMinima = false;
            }

            notaFinal += notas[i][1] * PORC_PRACTICAS;

            notaFinal += notas[i][2] * PORC_TRABAJO;

            notaFinal += notas[i][3] * PORC_PARTICIPACION;

            if (notaMinima) {
                notasFinales[i] = notaFinal;
            } else {
                notasFinales[i] = 3;
            }

            notaFinal = 0;
            notaMinima = true;

        }

        return notasFinales;

    }
     */
    /**
     * Compruebo las notas, si la nota final en FPI no esta aprobada, en FPII no
     * lo estara
     *
     * @param notas_FPI
     * @param notas_FPII
     */
    public static void comprobarNotas(double[] notas_FPI, double[] notas_FPII) {

        for (int i = 0; i < notas_FPI.length; i++) {
            if (notas_FPI[i] < 5) {
                notas_FPII[i] = 0;
            }
        }

    }

    /**
     * Muestra un array
     *
     * @param array
     */
    public static void mostrarArray(double[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    /**
     * Devuelve el numero de aprobados
     *
     * @param notas
     * @return
     */
    public static int aprobados(double[] notas) {

        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] >= 5) {
                contador++;
            }
        }

        return contador;

    }

    /**
     * Devuelve el numero de suspensos
     *
     * @param notas
     * @return
     */
    public static int suspensos(double[] notas) {

        int contador = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < 5) {
                contador++;
            }
        }

        return contador;

    }

}
