package ejercicio_funciones_24;

public class Ejercicio_funciones_24 {

    public static void main(String[] args) {

        int[] a = {9, 2, 3, 4, 5, 6, 7, 1, 9};
        System.out.println(elementoRepetido(a));

    }

    /**
     * Indica si un elemento dentro de un array esta repetido
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
    
    

}
