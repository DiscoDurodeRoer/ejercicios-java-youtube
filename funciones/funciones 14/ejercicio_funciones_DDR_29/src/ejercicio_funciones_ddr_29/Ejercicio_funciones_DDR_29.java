package ejercicio_funciones_ddr_29;

import java.util.Scanner;

public class Ejercicio_funciones_DDR_29 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        System.out.println("Dame el primer numero");
        int num1 = sn.nextInt();

        System.out.println("Dame el segundo numero");
        int num2 = sn.nextInt();

        int res = mcd(num1, num2);
        
        System.out.println("MCD: " + res);
    }

    public static int mcd(int num1, int num2) {

        int a = Math.max(num1, num2);
        int b = Math.min(num1, num2);

        int resultado = 0;
        do {
            resultado = b;
            b = a % b;
            a = resultado;

        } while (b != 0);

        return resultado;
        
    }

}
