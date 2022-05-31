package ejercicio_recursividad_ddr_20;

import java.util.ArrayList;

public class Ejercicio_recursividad_DDR_20 {

    public static void main(String[] args) {

        int n = 5;
        ArrayList<Integer> numeros = new ArrayList<>();
        combinacionesSuma(n, numeros, 0);
    }

    public static void combinacionesSuma(int numero, ArrayList<Integer> numeros, int suma) {

        //Caso base
        if (suma == numero) {
            
            //Muestro los numeros
            System.out.println(numeros);
            
        } else {
            for (int i = 1; i <= numero; i++) {
                suma += i;
                //Si la suma es mayor que el numero no hacemos la recursividad
                if (suma <= numero) {
                    //añado el numero
                    numeros.add(i);
                    combinacionesSuma(numero, numeros, suma);
                    //elimino el numero
                    numeros.remove(numeros.indexOf(i));
                }
                //deshago la suma
                suma -= i;

            }

        }

    }

}
