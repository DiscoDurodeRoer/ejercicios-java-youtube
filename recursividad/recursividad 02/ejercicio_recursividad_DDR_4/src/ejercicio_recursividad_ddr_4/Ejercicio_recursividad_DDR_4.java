
package ejercicio_recursividad_ddr_4;

public class Ejercicio_recursividad_DDR_4 {

    public static void main(String[] args) {
        
        int[] array={1,2,3,4,5};
        int elementoBuscar=3;
        int posElementoEncontrado=posicionElementoRecursivo(array, elementoBuscar,0);
        System.out.println(posElementoEncontrado);
        
    }
    
    public static int posicionElementoRecursivo(int[] array, int elementoBuscar ,int indice){
        
       if(indice==array.length || array[indice]==elementoBuscar){
            
            if(indice==array.length){
               return -1; 
            }else{
                return indice;
            }
            
        }else{
            return posicionElementoRecursivo(array, elementoBuscar, indice+1);
        }
        
    }
    
    
    
}
