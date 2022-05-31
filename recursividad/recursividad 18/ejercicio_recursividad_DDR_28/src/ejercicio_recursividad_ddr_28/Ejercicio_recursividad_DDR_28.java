package ejercicio_recursividad_ddr_28;

public class Ejercicio_recursividad_DDR_28 {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(multiplicarArrayDyV(0, array.length - 1, array));

    }

    public static int multiplicarArrayDyV(int inicio, int fin, int[] array) {

        if (inicio == fin) {
            return array[inicio];
        } else {

            int mitad = (inicio + fin) / 2;

            int x = multiplicarArrayDyV(inicio, mitad, array);
            int y = multiplicarArrayDyV(mitad + 1, fin, array);

            return x * y;

        }

    }

}
