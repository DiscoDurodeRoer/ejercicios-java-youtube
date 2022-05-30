package ejercicio_basicos_ddr_28;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_28 {

    public static void main(String[] args) throws InterruptedException {

        Scanner sn = new Scanner(System.in);

        int numAdivinar = 0;
        int[] digitos;
        boolean cifrasRepetidas = false;

        // Genero el numero sin cifras repetidas
        do {

            numAdivinar = generaNumeroAleatorio(1000, 9999);

            digitos = devuelveDigitos(numAdivinar);

            cifrasRepetidas = elementoRepetido(digitos);

        } while (cifrasRepetidas);

        // System.out.println(numAdivinar);

        boolean fin = false;

        // empieza el juego
        while (!fin) {

            // el usuario introduce un numero
            System.out.println("Inserte un número: ");
            int numeroUsuario = sn.nextInt();

            // Creamos el array de digitos
            int[] digitosUsuario = devuelveDigitos(numeroUsuario);

            // Sino son 4 cifras, volvemos de nuevo a pedir
            if (digitosUsuario.length != 4) {
                System.out.println("Solo numeros de 4 cifras");
            } else {

                // obtenemos el numero de toros
                int toros = numeroElementosRepetidosMismaPosicion(digitosUsuario, digitos);

                // Obtengo el numero de vacas
                int vacas = numeroElementosRepetidosDistintaPosicion(digitosUsuario, digitos);

                // Muestro lo obtenido
                System.out.println(toros + "T" + vacas + "V");

                // Si son 4 toros, hemos ganado
                if(toros == digitos.length){
                    fin = true;
                    System.out.println("Has acertado");
                }
                
            }

        }

    }

    /*Funciones*/
    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

    /**
     * Indica si un elemento dentro de un array esta repetido
     *
     * @param array array a comprobar
     * @return si hay o no algun elemento repetido
     */
    public static boolean elementoRepetido(int[] array) {

        // Recorremos el array la 1º vez
        for (int i = 0; i < array.length; i++) {

            // Recorremos el mismo array
            for (int j = i + 1; j < array.length; j++) {
                // Si coincide significa que hay un elemento repetido
                if (array[i] == array[j]) {
                    return true;
                }
            }

        }

        // No hay un elemento repetido
        return false;

    }

    /**
     * Indica cuantos repetidos hay en dos arrays, sin contar los que estan en
     * la misma posicion
     *
     * @param array1 Primer array
     * @param array2 Segundo array
     * @return Numero de repeticiones en ambos arrays sin contar los que estan
     * en la misma posicion
     */
    public static int numeroElementosRepetidosDistintaPosicion(int[] array1, int[] array2) {

        int repetidos = 0;
        for (int i = 0; i < array1.length; i++) {

            for (int j = 0; j < array2.length; j++) {
                // Sino es la misma posicion y son igaules, aumento los repetidos
                if (i != j && array1[i] == array2[j]) {
                    repetidos++;
                }
            }
        }
        return repetidos;
    }

    /**
     * Indico cuando elementos repetidos hay en dos arrays. Solo arrays con la
     * misma longitud y en la misma posicion.
     *
     * @param array1 Primer array
     * @param array2 Segundo array
     * @return Numero de repeticiones en ambos arrays. Devuelve -1 en caso de
     * que sean de logitudes diferentes
     */
    public static int numeroElementosRepetidosMismaPosicion(int[] array1, int[] array2) {

        // Si son de diferentes longitudes, devuelvo -1
        if (array1.length != array2.length) {
            return -1;
        }

        int repetidos = 0;

        for (int i = 0; i < array1.length; i++) {
            // Si son iguales, aumento los repetidos
            if (array1[i] == array2[i]) {
                repetidos++;
            }
        }

        return repetidos;

    }

    /**
     * Devuelve los digitos de un numero en un array
     *
     * @param numeroInicial Numero al que extraer los digitos
     * @return Array con cada uno de los digitos
     */
    public static int[] devuelveDigitos(int numeroInicial) {

        int numero = numeroInicial;

        int digitos[] = new int[cuentaCifras(numeroInicial)];
        int numero_solo;

        for (int i = 0; numeroInicial > 0; i++) {
            numero /= 10;
            numero_solo = numeroInicial - (numero * 10);
            digitos[i] = numero_solo;
            numeroInicial = numero;
        }
        return invertirArray(digitos);

    }

    /**
     * Cuenta el numero de cifras de un numero
     *
     * @param num Número a contrar
     * @return numero de cifras
     */
    public static int cuentaCifras(int num) {

        int contador = 0;

        if (num == 0) {
            contador = 1;
        } else {

            for (int i = Math.abs(num); i > 0; i /= 10) {
                contador++;
            }

        }

        return contador;
    }

    /**
     * Invierte los datos de un array
     *
     * @param array Array que contiene los datos
     * @return Devuelve un nuevo array con los datos invertidos
     */
    public static int[] invertirArray(int array[]) {

        int temp[] = new int[array.length];

        for (int i = temp.length - 1, j = 0; i >= 0; i--, j++) {
            temp[i] = array[j];
        }

        return temp;
    }

}
