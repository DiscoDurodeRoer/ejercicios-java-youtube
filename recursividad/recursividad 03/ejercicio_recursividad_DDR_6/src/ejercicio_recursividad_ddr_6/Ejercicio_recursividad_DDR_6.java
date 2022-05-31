package ejercicio_recursividad_ddr_6;

/**
 * @author DiscoDurodeRoer
 */
public class Ejercicio_recursividad_DDR_6 {

    public static void main(String[] args) {

        //Serie fibonacci
        // 1 1 2 3 5 8 13 21 34 55
        
        //llamada inicial
        int posicion = 5;
        int resultado = fibonacciRecursivo(posicion);
        System.out.println(resultado);

    }

    public static int fibonacciRecursivo(int n) {

        //CASO BASE, si es cero devuelve un cero
        //Puedes poner n<=0 tamvien para incluir negativos
        if (n == 0) {
            return 0;
        //CASO BASE, si es 1 devuelve un 1    
        } else if (n == 1) {
            return 1;
        } else {
            //Hago la suma
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }

    }

}
