package ejercicio_recursividad_ddr_3;

/**
 * @author Disco Duro de Roer
 */
public class Ejercicio_recursividad_DDR_3 {

    public static void main(String[] args) {
        
        int[] array={1,2,3,4,5}; //Creamos un array
        mostrarArrayRecursivo(array, 0); //Pasamos el array y la posicion donde empieza
        
    }
    
    public static void mostrarArrayRecursivo(int[] array, int indice){
        
        /*1º forma*/
        /*
        if (indice == (array.length-1)){
           System.out.println(array[indice]);
        }else{
            System.out.println(array[indice]);
            mostrarArrayRecursivo(array, indice+1);
        }
        */
        
        /*2º forma*/
        if (indice != array.length){
            //Mostramos el valor en ese indice
            System.out.println(array[indice]);
            //Llamamos recursivamente a la función
            mostrarArrayRecursivo(array, indice+1);
        }
        
    }
    
    
}
