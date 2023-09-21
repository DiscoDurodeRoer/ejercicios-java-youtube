package ejercicio_funciones_ddr_06;

public class Ejercicio_funciones_DDR_06 {

    public static void main(String[] args) {
        
        System.out.println(factorial(5));
        
    }
    
    public static int factorial(int numero){
        
        //No hay factorial de numeros negativos.
        if(numero<0){    
            System.out.println("No se puede calcular el factorial"
                    + " de un numero negativo");
            return -1;
        }
        
        //Factorial de 1 y 0 es 1
        if(numero==0 || numero==1){
            return 1;
        }
        
        int resultado=numero;
        
        //Recorremos de arriba a abajo
        for(int i=(numero-1);i>1;i--){
            
            resultado*=i;
            
        }
        
        return resultado;
        
    }
    
}
