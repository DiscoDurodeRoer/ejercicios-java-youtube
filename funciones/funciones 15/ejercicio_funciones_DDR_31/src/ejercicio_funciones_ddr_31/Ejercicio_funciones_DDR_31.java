package ejercicio_funciones_ddr_31;

import java.util.Scanner;

public class Ejercicio_funciones_DDR_31 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe una palabra");
        String palabra = sn.next().toLowerCase();

        if (esHeterograma(palabra)) {
            System.out.println("La palabra " + palabra + " es un heterograma");
        } else {
            System.out.println("La palabra " + palabra + " no es un heterograma");
        }

    }

    public static boolean esHeterograma(String palabra) {

        char caracter;
        for (int i = 0; i < palabra.length(); i++) {
            caracter = palabra.charAt(i);
            if (Character.isLetter(caracter)) {
                for (int j = i + 1; j < palabra.length(); j++) {
                    if (caracter == palabra.charAt(j)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }

}
