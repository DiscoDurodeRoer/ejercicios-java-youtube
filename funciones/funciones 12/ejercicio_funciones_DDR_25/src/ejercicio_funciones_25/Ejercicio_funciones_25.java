package ejercicio_funciones_25;

public class Ejercicio_funciones_25 {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 7, 8, 9, 10};
        int[] a2 = {1};
        System.out.println(elementoRepetido(a1, a2));

    }

    public static boolean elementoRepetido(int[] array1, int[] array2) {

        // Recorro el primer array
        for (int i = 0; i < array1.length; i++) {

            // Recorro el segundo array
            for (int j = 0; j < array2.length; j++) {
                // Si coincide hay un elemento repetido
                if (array1[i] == array2[j]) {
                    return true;
                }
            }

        }

        // No hay elemento repetido
        return false;

    }

}
