
package ejercicio_funciones_ddr_17;


public class Ejercicio_funciones_DDR_17 {

    
    public static void main(String[] args) {
        
        
        int numero = 99;
        
        int[] mayorMenorDivisor = mayorMenorDivisor(numero);
        
        if(mayorMenorDivisor!=null){
            for (int i = 0; i < mayorMenorDivisor.length; i++) {
                System.out.println(mayorMenorDivisor[i]);
            }
        }else{
            System.out.println("No tiene divisores");
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
    
    public static int[] mayorMenorArray(int[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        // 0 = mayor, 1 = menor
        int[] mayor_menor = new int[2];

        mayor_menor[0] = array[0];
        mayor_menor[1] = array[0];;

        for (int i = 1; i < array.length; i++) {

            if (array[i] > mayor_menor[0]) {
                mayor_menor[0] = array[i];
            }

            if (array[i] < mayor_menor[1]) {
                mayor_menor[1] = array[i];
            }

        }

        return mayor_menor;

    }
    
    public static int[] mayorMenorDivisor(int numero){
     
        int[] divisores = divisores(numero);
        
        if(divisores==null || divisores.length==0){
            return null;
        }else{
            int[] mayorMenor = mayorMenorArray(divisores);
            
            return mayorMenor;
            
        }
        
    }
    
}
