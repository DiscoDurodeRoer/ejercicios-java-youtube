package ejercicio_matrices_ddr_13;

import java.util.Arrays;

public class Ejercicio_matrices_DDR_13 {

    public static void main(String[] args) {

        int[][] carton = new int[3][9];

        // Rellenar numeros en el carton
        rellenarNumerosCarton(carton);
        // Ordena cada columna del carton
        ordenarColumnasCarton(carton);
        // Marca los huecos del cartón
        marcarHuecosCarton(carton);
        // Mostramos el cartón
        mostrarCarton(carton);

    }

    public static void rellenarNumerosCarton(int[][] carton) {

        // Declaramos las variables necesarias
        int numAleatorio;
        boolean repetido;

        // Recorre los números
        for (int j = 0; j < carton[0].length; j++) {
            for (int i = 0; i < carton.length; i++) {
                do {
                    repetido = false;
                    // Genera un número aleatorio
                    // En la columna 0, el numero estará entre 1 y 9
                    // Entre las columnas 1 y 7, el numero estará entre (10 * j) y ((10 * j) + 9)
                    // En la columna 8, el numero estará entre 80 y 90
                    switch (j) {
                        case 0:
                            numAleatorio = generaNumeroAleatorio(1, 9);
                            break;
                        case 8:
                            numAleatorio = generaNumeroAleatorio(80, 90);
                            break;
                        default:
                            numAleatorio = generaNumeroAleatorio(10 * j, (10 * j) + 9);
                            break;
                    }

                    // Se puede hacer con un bucle
                    // Comprobamos si se repite el primero
                    if (i == 1 && carton[0][j] == numAleatorio) {
                        repetido = true;
                        // Comprobamos si se repite el primero o el segungo
                    } else if (i == 2 && (carton[0][j] == numAleatorio || carton[1][j] == numAleatorio)) {
                        repetido = true;
                    }

                } while (repetido);

                // Añadimos el número
                carton[i][j] = numAleatorio;
            }
        }
    }

    public static void ordenarColumnasCarton(int[][] carton) {

        int[] numeros = new int[3];
        for (int j = 0; j < carton[0].length; j++) {

            // Obtengo los numeros de la columna x
            for (int i = 0; i < carton.length; i++) {
                numeros[i] = carton[i][j];
            }

            // Ordeno los numeros
            Arrays.sort(numeros);

            // Vuelvo a asignar los valores, ya ordenados
            for (int i = 0; i < numeros.length; i++) {
                carton[i][j] = numeros[i];
            }

        }
    }

    public static void marcarHuecosCarton(int[][] carton) {

        // generar un array de 9 posiciones con 6 unos y 3 doses
        int[] distribucion = {1, 1, 1, 1, 1, 1, 1, 1, 1};

        int posicionAleatoria;
        // Solo generamos 3 doses
        for (int i = 0; i < 3; i++) {
            do {
                posicionAleatoria = generaNumeroAleatorio(0, distribucion.length - 1);
            } while (distribucion[posicionAleatoria] == 2);
            // Colocamos un 2
            distribucion[posicionAleatoria] = 2;
        }

        // Recorrer array e ir llevando una cuenta del numero de huecos de cada fila, no puede superar 4
        int numHuecos[] = new int[3];
        boolean huecoDisponible[] = new boolean[3];
        int menor, filaAleatoria, posOcupadas;
        boolean iguales;

        for (int j = 0; j < carton[0].length; j++) {

            // Marco las posiciones como disponible
            Arrays.fill(huecoDisponible, true);

            // Compruebo si son iguales
            iguales = true;
            for (int i = 0; i < numHuecos.length - 1 && iguales; i++) {
                if (numHuecos[i] != numHuecos[i + 1]) {
                    iguales = false;
                }
            }

            // Sino son iguales, debo descartar aquellos que distintos al menor hueco
            if (!iguales) {

                // Busco el menor hueco
                menor = numHuecos[0];
                for (int i = 1; i < numHuecos.length; i++) {
                    if (numHuecos[i] < menor) {
                        menor = numHuecos[i];
                    }
                }

                // Marco como no disponible los huecos diferentes al menor
                for (int i = 0; i < huecoDisponible.length; i++) {
                    if (numHuecos[i] != menor) {
                        huecoDisponible[i] = false;
                    }
                }

            }

            // Compruebo donde colocar los huecos
            do {
                // Genero una fila aleatoria
                filaAleatoria = generaNumeroAleatorio(0, carton.length - 1);
                // Salgo si el hueco esta disponible y no esta repetido
            } while (!huecoDisponible[filaAleatoria] || carton[filaAleatoria][j] == -1);

            // Coloco el hueco
            carton[filaAleatoria][j] = -1;

            // Incremento en 1 el numero de huecos de esa fila
            numHuecos[filaAleatoria]++;

            // Solo compruebo las posiciones ocupadas si tengo que poner dos huecos
            if (distribucion[j] == 2) {
                // Compruebo cuantos huecos hay en la columna
                posOcupadas = 0;
                for (int i = 0; i < carton.length; i++) {
                    if (carton[i][j] == -1) {
                        posOcupadas++;
                    }
                }

                // Si hay menos posiciones ocupadas que el de la distribucion de la columna, repetimos
                if (posOcupadas < distribucion[j]) {
                    j--;
                }
            }
        }
    }

    public static void mostrarCarton(int[][] carton) {

        // Recorremos el carton
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {

                // Si es -1, ponemos un * o **, segun la columna
                if (carton[i][j] == -1) {
                    // Si es la primera columna, pongo un * y sino pongo 2 *
                    if (j == 0) {
                        System.out.print("* ");
                    } else {
                        System.out.print("** ");
                    }

                } else {
                    // Muestro el valor tal cual
                    System.out.print(carton[i][j] + " ");
                }
            }
            // Salto de linea
            System.out.println("");
        }
    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }
}
