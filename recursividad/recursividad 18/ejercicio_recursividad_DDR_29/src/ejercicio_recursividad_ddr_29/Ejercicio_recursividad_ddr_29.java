package ejercicio_recursividad_ddr_29;

public class Ejercicio_recursividad_ddr_29 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        if (array.length % 2 == 0) {
            System.out.println(mediaArrayDyV(0, array.length - 1, array));
        } else {
            System.out.println("El numero de elementos debe ser par");
        }

    }

    public static float mediaArrayDyV(int inicio, int fin, int[] array) {

        if (inicio == fin) {
            return array[inicio];
        } else {

            int mitad = (inicio + fin) / 2;

            float x = mediaArrayDyV(inicio, mitad, array);
            float y = mediaArrayDyV(mitad + 1, fin, array);

            return (x + y) / 2;

        }

    }

}
