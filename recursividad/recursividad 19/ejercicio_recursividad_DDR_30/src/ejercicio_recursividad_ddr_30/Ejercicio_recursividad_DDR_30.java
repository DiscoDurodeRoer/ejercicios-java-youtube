package ejercicio_recursividad_ddr_30;

public class Ejercicio_recursividad_DDR_30 {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = {1, 2, 3, 5, 5, 6, 7, 8};

        if (arr1.length == arr2.length) {

            if (arraysIguales(0, arr1.length - 1, arr1, arr2) == -1) {
                System.out.println("Los arrays son iguales");
            } else {
                System.out.println("Los arrays no son iguales");
            }

        } else {
            System.out.println("Los arrays no son iguales");
        }

    }

    public static int arraysIguales(int inicio, int fin, int[] arr1, int[] arr2) {

        if (inicio == fin) {
            if (arr1[inicio] == arr2[inicio]) {
                return -1;
            } else {
                return inicio;
            }

        } else {

            int mitad = (inicio + fin) / 2;
            int x = arraysIguales(inicio, mitad, arr1, arr2);
            int y = arraysIguales(mitad + 1, fin, arr1, arr2);

            if (x != -1) {
                return x;
            }

            if (y != -1) {
                return y;
            }

            return -1;

        }

    }

}
