package ejercicio_recursividad_ddr_11;

public class Ejercicio_recursividad_DDR_11 {

    public static void main(String[] args) {

        int[] numeros = {6, 5, -9999, 10, 2, -10, 6};

        System.out.println("Maximo v1: " + maximoRec(numeros, 0, numeros[0]));

        System.out.println("Maximo v2: " + maximoRecV2(numeros, 0));

        System.out.println("Minimo v1: " + minimoRec(numeros, 0, numeros[0]));

        System.out.println("Minimo v2: " + minimoRecV2(numeros, 0));

    }

    public static int maximoRec(int[] numeros, int indice, int max) {

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Si el valor actual es mayor que el actual, lo llamaremos de forma distinta
            if (numeros[indice] > max) {
                max = maximoRec(numeros, indice + 1, numeros[indice]);
            } else {
                max = maximoRec(numeros, indice + 1, max);
            }

        }

        return max;

    }

    public static int maximoRecV2(int[] numeros, int indice) {

        int maximo = Integer.MIN_VALUE;

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Comparamos el 1º con el 2º, el 2º con el 3º, etc.
            maximo = Math.max(numeros[indice], maximoRecV2(numeros, indice + 1));

        }

        return maximo;

    }

    public static int minimoRec(int[] numeros, int indice, int min) {

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Si el valor actual es menor que el actual, lo llamaremos de forma distinta
            if (numeros[indice] < min) {
                min = minimoRec(numeros, indice + 1, numeros[indice]);
            } else {
                min = minimoRec(numeros, indice + 1, min);
            }

        }

        return min;

    }

    public static int minimoRecV2(int[] numeros, int indice) {

        int minimo = Integer.MAX_VALUE;

        //Cuando el indice sea igual a la longitud del array, terminaremos la recursividad
        if (indice != numeros.length) {

            //Comparamos el 1º con el 2º, el 2º con el 3º, etc.
            minimo = Math.min(numeros[indice], minimoRecV2(numeros, indice + 1));

        }

        return minimo;

    }

}
