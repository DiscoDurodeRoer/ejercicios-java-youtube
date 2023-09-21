package ejercicio_funciones_ddr_07;

public class Ejercicio_funciones_DDR_07 {

    public static void main(String[] args) {
        
        System.out.println(esPrimo(5));
        
    }
    
    public static boolean esPrimo(int numero){
        
        //Un primo no puede ser menor que 1
        if(numero<=1){
            return false;
        }
        
        //Empezamos desde la raiz cuadrada de ese numero
        for(int i=(int)Math.sqrt(numero);i>1;i--){
            if(numero%i==0){
                //Si hay un solo divisor, ya no sera primo
                return false;
            }
        }
        
        return true;
    }
    
}
