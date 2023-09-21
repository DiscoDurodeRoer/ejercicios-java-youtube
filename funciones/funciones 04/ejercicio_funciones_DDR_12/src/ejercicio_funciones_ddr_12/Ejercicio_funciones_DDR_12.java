package ejercicio_funciones_ddr_12;

public class Ejercicio_funciones_DDR_12 {

    public static void main(String[] args) {
       
        //Creacion de arrays
        int[] arr1 = serie(5,7);
        int[] arr2 = serie(7,5);
        int[] arr3 = serie(5,5);
        
        System.out.println("Inicio 5 y final 7");
        mostrar(arr1);
        System.out.println("");
        System.out.println("Inicio 7 y final 5");
        mostrar(arr2);
        System.out.println("");
        System.out.println("Inicio 5 y final 5");
        mostrar(arr3);
        
    }
    
    public static int[] serie(int inicio_num, int final_num){
        
        int tamanio = Math.abs(inicio_num - final_num) + 1;
        int[] serie = new int[tamanio];
        
        //Segun sea menor o mayor, el inicio y el incremento, sera distinto
        if(inicio_num < final_num){
            
            for(int i=0, j=inicio_num;i<serie.length;i++, j++){
                serie[i] = j;
            }
            
        }else{
            
            for(int i=0, j=inicio_num;i<serie.length; i++,j--){
                serie[i] = j;
            }
            
        }
        
        return serie;
        
    }
    
    public static void mostrar(int[] array){
        
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
        
    }
    
}
