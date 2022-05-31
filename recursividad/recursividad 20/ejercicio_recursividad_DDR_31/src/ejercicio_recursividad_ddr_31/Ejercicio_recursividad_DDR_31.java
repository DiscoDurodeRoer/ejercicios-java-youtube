package ejercicio_recursividad_ddr_31;

public class Ejercicio_recursividad_DDR_31 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 4, 3, 1, 0, 7, 6, -10};

        int min = minimo(0, arr.length - 1, arr);
        int max = maximo(0, arr.length - 1, arr);

        int[] minmax = minmax(0, arr.length - 1, arr);

        System.out.println("Minimo (funcion1): " + min);
        System.out.println("Maximo (funcion2): " + max);

        System.out.println("Minimo (funcion3): " + minmax[0]);
        System.out.println("Maximo (funcion3): " + minmax[1]);

    }

    public static int minimo(int inicio, int fin, int[] arr) {

        if (inicio == fin) {
            return arr[inicio];
        } else {

            int mitad = (inicio + fin) / 2;
            int x = minimo(inicio, mitad, arr);
            int y = minimo(mitad + 1, fin, arr);

            if (x < y) {
                return x;
            } else {
                return y;
            }

        }

    }

    public static int maximo(int inicio, int fin, int[] arr) {

        if (inicio == fin) {
            return arr[inicio];
        } else {

            int mitad = (inicio + fin) / 2;
            int x = maximo(inicio, mitad, arr);
            int y = maximo(mitad + 1, fin, arr);

            if (x > y) {
                return x;
            } else {
                return y;
            }

        }

    }

    public static int[] minmax(int inicio, int fin, int[] arr) {

        int[] minmax = new int[2];

        if (fin - inicio <= 1) {

            minmax[0] = arr[inicio];
            minmax[1] = arr[fin];

            if (minmax[0] > minmax[1]) {
                int aux = minmax[0];
                minmax[0] = minmax[1];
                minmax[1] = aux;
            }

        } else {

            int mitad = (inicio + fin) / 2;
            int[] mm1 = minmax(inicio, mitad, arr);
            int[] mm2 = minmax(mitad + 1, fin, arr);

            if (mm1[0] < mm2[0]) {
                minmax[0] = mm1[0];
            } else {
                minmax[0] = mm2[0];
            }

            if (mm1[1] > mm2[1]) {
                minmax[1] = mm1[1];
            } else {
                minmax[1] = mm2[1];
            }

        }

        return minmax;

    }

}
