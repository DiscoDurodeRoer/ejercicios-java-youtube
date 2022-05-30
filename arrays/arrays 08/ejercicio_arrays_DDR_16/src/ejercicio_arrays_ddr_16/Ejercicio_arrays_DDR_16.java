package ejercicio_arrays_ddr_16;

import java.util.Scanner;

public class Ejercicio_arrays_DDR_16 {

    public static void main(String[] args) {

        //numero de jugadores
        int n = 3;
        jugar(n);

    }

    public static void jugar(int n) {

        //Si no hay suficientes jugaores, no se jugara
        if (n < 2) {
            System.out.println("Se necesitan mas jugadores");
        } else {
            
            //matriz donde guardaremos los puntos
            int numeros_jugadores[][] = new int[n][4];
            
            //array donde guardaremos los numeros del arbitro
            int numeros_arbitro[] = new int[2];

            //Recorro los jugadores
            for (int i = 0; i < numeros_jugadores.length; i++) {
                
                //pedimos los numeros
                System.out.println("Jugador " + i);
                pedirNumeros(numeros_jugadores[i]); //array del jugador

                //mostrar los numeros del jugador
                System.out.println("Jugador " + i);
                mostrarArray(numeros_jugadores[i]);

            }

            //Numero del arbitro
            System.out.println("Arbitro");
            pedirNumeros(numeros_arbitro);

            System.out.println("Arbitro");
            mostrarArray(numeros_arbitro);

            //array para almacenar los puntos
            int puntos_jugador[] = new int[n];

            //calculamos los puntos
            calcularPuntos(puntos_jugador, numeros_arbitro, numeros_jugadores);

            //muestro los puntos
            System.out.println("Puntos");
            mostrarArray(puntos_jugador);

            //obtengo la posicion del ganador
            int ganador = ganador(puntos_jugador);

            //muestro el ganador y los puntos
            System.out.println("Ha ganado el jugador " + ganador + " por " + puntos_jugador[ganador] + " puntos");

            //obtengo la media
            double mediaAciertos = mediaArray(puntos_jugador);

            //muestro la media
            System.out.println("La media de aciertos es de " + mediaAciertos);

        }

    }

    /**
     * Añade numeros pedidos al usuario a un array
     * @param numeros_jugadores 
     */
    public static void pedirNumeros(int[] numeros_jugadores) {

        //recorro el array
        for (int i = 0; i < numeros_jugadores.length; i++) {

            //relleno
            numeros_jugadores[i] = validarNumero(1, 10);

        }

    }

    /**
     * Valido un numero entre dos numeros
     * @param minimo
     * @param maximo
     * @return 
     */
    public static int validarNumero(int minimo, int maximo) {

        Scanner sn = new Scanner(System.in);

        int numero = 0;
        do {
            System.out.println("Inserta un numero entre " + minimo + " y " + maximo);
            numero = sn.nextInt();

            //muestra un pequeño mensaje de aviso
            if (!(numero >= minimo && numero <= maximo)) {
                System.out.println("Solo numeros entre " + minimo + " y " + maximo);
            }

        } while (!(numero >= minimo && numero <= maximo));

        return numero;

    }

    /**
     * Relleno en puntos los puntos de los jugadores
     * @param puntos
     * @param numeros_arbitro
     * @param numeros_jugadores 
     */
    public static void calcularPuntos(int[] puntos, int[] numeros_arbitro, int[][] numeros_jugadores) {

        int puntos_jugador = 0;

        //Recorro la matriz
        for (int i = 0; i < numeros_jugadores.length; i++) {
            for (int j = 0; j < numeros_jugadores[0].length; j++) {

                //Segun el orden de los numeros
                if (numeros_arbitro[0] > numeros_arbitro[1]) {

                    //si esta entre los numeros, aumento los puntos
                    if (numeros_jugadores[i][j] >= numeros_arbitro[1] && numeros_jugadores[i][j] <= numeros_arbitro[0]) {
                        puntos_jugador++;
                    }

                } else {

                    //si esta entre los numeros, aumento los puntos
                    if (numeros_jugadores[i][j] >= numeros_arbitro[0] && numeros_jugadores[i][j] <= numeros_arbitro[1]) {
                        puntos_jugador++;
                    }

                }

            }

            //Relleno los puntos
            puntos[i] = puntos_jugador;
            //Reinicio los puntos
            puntos_jugador = 0;

        }

    }

    /**
     * Devuelve la posicion del ganador
     * @param puntos
     * @return 
     */
    public static int ganador(int[] puntos) {

        //inicial
        int maximo = puntos[0];
        int pos_jugador_ganador = 0;

        for (int i = 1; i < puntos.length; i++) {

            //compruebo el maximo
            if (puntos[i] > maximo) {
                maximo = puntos[i];
                pos_jugador_ganador = i;
            }

        }

        return pos_jugador_ganador;

    }

    /**
     * Muestra un array
     * @param array 
     */
    public static void mostrarArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    /**
     * Muestra la media de un array
     * @param array
     * @return 
     */
    public static double mediaArray(int[] array) {

        double media = 0;
        int suma = 0;

        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }

        media = (double) suma / array.length;

        return media;
    }

}
