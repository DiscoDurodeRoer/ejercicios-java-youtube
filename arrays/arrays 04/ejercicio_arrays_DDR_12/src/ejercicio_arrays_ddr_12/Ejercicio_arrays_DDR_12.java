package ejercicio_arrays_ddr_12;

public class Ejercicio_arrays_DDR_12 {

    public static void main(String[] args) {
        
        //array a ordenar
        int numeros[]={5,6,2,10,1};
        
        //llamada a la funcion
        ordenacionQuicksort(numeros, 0, numeros.length-1);
        
        //mostramos el contenido
        for(int i=0;i<numeros.length;i++){
            System.out.println(numeros[i]);
        }
       
        //realizamos la busqueda binaria
        System.out.println("El numero 5 esta en la posicion  "+buscarBin(numeros, 5));

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
    
     /**
     * Busca un numero entero en un array
     * Necesita que el array este ordenado
     * @param array
     * @param numerobuscado
     * @return posicion del numero
     */
    public static int buscarBin (int array[], int numerobuscado){
        int izq=0;
        int der=array.length;
        boolean encontrado=false;
        int pos=-1;

        for(int i=0;!encontrado && i<array.length;i++){
            int central=array[(izq+der)/2]; //elegimos la casilla central
            if (central<=numerobuscado){
                if (central==numerobuscado){ //encontrado
                    encontrado=true; 
                    pos=(izq+der)/2;
                }else{
                    izq=(izq+der)/2; //modificamos izq
                }
            }else{
                der=(izq+der)/2; //modificamos der
            }
        }
        return pos;
    }
}
