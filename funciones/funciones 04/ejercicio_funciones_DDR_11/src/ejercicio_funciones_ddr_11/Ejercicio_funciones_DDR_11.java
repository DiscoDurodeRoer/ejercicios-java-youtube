package ejercicio_funciones_ddr_11;

public class Ejercicio_funciones_DDR_11 {

    public static void main(String[] args) {
        
        int[] numeros={1,2,3,4,5};
        
        System.out.println("La suma es "+suma(numeros));
        
        System.out.println("La media es "+media(numeros));
        
    }
    
    public static int suma(int[] numeros){
        
        int suma=0;
        for(int i=0;i<numeros.length;i++){
            suma+=numeros[i]; //Acumula los valores
        }
        
        return suma;
        
    }
    
    public static double media(int[] numeros){
        
        int suma= suma(numeros); //llamo a la anterior funcion
        
        return suma / numeros.length;
    }
    
    
}
