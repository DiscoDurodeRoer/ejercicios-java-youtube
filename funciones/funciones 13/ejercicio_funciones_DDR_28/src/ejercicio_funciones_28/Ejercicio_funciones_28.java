package ejercicio_funciones_28;

public class Ejercicio_funciones_28 {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4};
        int[] a2 = {1, 3, 4, 4};

        System.out.println(numeroElementosRepetidosMismaPosicion(a1, a2));

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

}
