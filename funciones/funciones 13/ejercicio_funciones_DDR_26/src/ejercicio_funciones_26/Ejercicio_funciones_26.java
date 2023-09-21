package ejercicio_funciones_26;

public class Ejercicio_funciones_26 {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 4, 4, 8};

        System.out.println(numeroElementosRepetido(a, 4));

        System.out.println(numeroElementosRepetido(a, 0));

    }

    /**
     * Indica cuantas veces se repite un elemento en el arrat dado
     *
     * @param array Array a comprobar
     * @param elemento Elemento a buscar
     * @return Numero de repeticiones del elemento en el array
     */
    public static int numeroElementosRepetido(int[] array, int elemento) {

        int repetidos = 0;
        for (int i = 0; i < array.length; i++) {
            // Si coincide, tenemos un repetido mas
            if (array[i] == elemento) {
                repetidos++;
            }
        }

        return repetidos;
    }

}
