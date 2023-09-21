package ejercicio_funciones_DDR_02;

public class Ejercicio_2 {

    public static void main(String[] args) {
        
        int num1=5;
        int num2=7;
        
        //la función también se puede guardar en una variable
        System.out.println("El resultado es "+suma(num1,num2));
        
    }
    
    /**
     * Función que nos realiza la suma de dos números
     * @param a
     * @param b
     * @return a+b
     */
    public static int suma(int a,int b){
        
        return a+b;
        
    }
    
}
