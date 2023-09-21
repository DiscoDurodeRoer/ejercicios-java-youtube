package ejercicio_funciones_ddr_16;

public class Ejercicio_funciones_DDR_16 {

    public static void main(String[] args) {

        int numero = 1000;

        int[] divisores = divisores(numero);
        //int[] divisores = divisoresV2(numero); //funciona igual

        if (divisores != null) {
            for (int i = 0; i < divisores.length; i++) {
                System.out.println(divisores[i]);
            }
        }

    }

    public static int[] divisores(int numero) {

        int contador = 0;

        if (numero > 0) {
            for (int i = numero - 1; i > 1; i--) {
                if (numero % i == 0) {
                    contador++;
                }
            }
        } else {
            for (int i = numero + 1; i < -1; i++) {
                if (numero % i == 0) {
                    contador++;
                }
            }
        }

        if (contador == 0) {
            return null;
        } else {
            int[] divisores = new int[contador];

            if (numero > 0) {
                for (int i = numero - 1, j = 0; i > 1; i--) {
                    if (numero % i == 0) {
                        divisores[j] = i;
                        j++;
                    }
                }
            } else {
                for (int i = numero + 1, j = 0; i < -1; i++) {
                    if (numero % i == 0) {
                        divisores[j] = i;
                        j++;
                    }
                }
            }

            return divisores;
        }

    }

    public static int[] divisoresV2(int numero) {

        int contador = 0;

        int aux = numero;

        if (numero < 0) {
            aux = Math.abs(numero);
        }

        for (int i = aux - 1; i > 1; i--) {
            if (aux % i == 0) {
                contador++;
            }
        }

        if (contador == 0) {
            return null;
        } else {
            int[] divisores = new int[contador];

            for (int i = aux - 1, j = 0; i > 1; i--) {
                if (aux % i == 0) {
                    if (numero < 0) {
                        divisores[j] = i * (-1);
                    } else {
                        divisores[j] = i;
                    }
                    j++;
                }
            }

            return divisores;
        }

    }

}
