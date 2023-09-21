package ejercicio_funciones_27;

public class Ejercicio_funciones_27 {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {2, 3, 4, 3};

        System.out.println(numeroElementosRepetidosDistintaPosicion(a1, a2));

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

}
