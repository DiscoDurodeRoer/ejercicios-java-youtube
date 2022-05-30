package ejercicio_arrays_DDR_01;

public class Ejercicio_1 {

    public static void main(String[] args) {
        
        //Creo el array
        int[] numeros=new int[100];
        
        //Lo recorro y le asigno números
        for(int i=0;i<numeros.length;i++){
            numeros[i]=i+1;
            System.out.println(numeros[i]);
        }
        
    }
    
}
