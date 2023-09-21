package ejercicio_funciones_ddr_10;

public class Ejercicio_funciones_DDR_10 {

    public static void main(String[] args) {
       
        int[] numeros={1,2,3,4,5};
        
        System.out.println("Contenido array");
        mostrar(numeros);
        
    }
    
    //Funcion que muestra el contenido del array
    public static void mostrar(int[] array){
        
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        
    }
    
}
