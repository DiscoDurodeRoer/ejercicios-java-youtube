package ejercicio_arrays_ddr_10;

public class Ejercicio_arrays_DDR_10 {

    public static void main(String[] args) {

        //array a ordenar
        int numeros[]={5,6,2,10,1};
        
        //llamada funcion
        ordenacionQuicksort(numeros, 0, numeros.length-1);
        
        //mostramos el contenido
        for(int i=0;i<numeros.length;i++){
            System.out.println(numeros[i]);
        }
        
    }
    
    /**
     * Ordena un array por el metodo de ordenacion QuickSort
     * @param array
     * @param izq
     * @param der 
     */
    public static void ordenacionQuicksort (int array[], int izq, int der){
        int i=izq;
        int j=der;
        int pivote=array[(i+j)/2]; //determinamos el pivote
        do {
            while (array[i]<pivote){
                i++;
            }
            while (array[j]>pivote){
                j--;
            }
            if (i<=j){
                //intercambio
                int aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        //llamada de funciones (recursivo)
        if (izq<j){
            ordenacionQuicksort(array, izq, j);
        }
        if (i<der){
            ordenacionQuicksort(array, i, der);
        }
    }
    
    
}
