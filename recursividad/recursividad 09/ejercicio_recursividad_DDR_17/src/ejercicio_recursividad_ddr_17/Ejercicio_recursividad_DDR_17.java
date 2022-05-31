package ejercicio_recursividad_ddr_17;

public class Ejercicio_recursividad_DDR_17 {

    public static void main(String[] args) {

        int[] a1 = {1, 2, 3, 4, 5};
        
        invertirArrayRecursivo(a1, 0, a1.length-1);

        for (int i = 0; i < a1.length; i++) {
            System.out.println(a1[i]);
        }
        
    }

    public static void invertirArrayRecursivo(int[] a1, int inicio, int fin) {

        if (inicio < fin) {
            int aux = a1[inicio];
            a1[inicio] = a1[fin];
            a1[fin] = aux;
            invertirArrayRecursivo(a1, inicio + 1, fin - 1);
        }

    }

}
