package ejercicio_arrays_ddr_11;

public class Ejercicio_arrays_DDR_11 {

    public static void main(String[] args) {

        //array a ordenar
        String cadenas[]={"Fernando","Pepe","Alejandro","Alfredo","Eufrasio"};
        
        //llamada funcion
        ordenacionQuicksort(cadenas, 0, cadenas.length-1);

        System.out.println("Orden alfabetico");
        
        //mostramos el contenido en orden alfabetico
        for(int i=0;i<cadenas.length;i++){
            System.out.println(cadenas[i]);
        }
        
        System.out.println("");
        
        //llamada funcion
        ordenacionQuicksortInverso(cadenas, 0, cadenas.length-1);
        
        System.out.println("Orden alfabetico inverso");
        
        //mostramos el contenido en orden alfabetico inverso
        for(int i=0;i<cadenas.length;i++){
            System.out.println(cadenas[i]);
        }
        
    }
    
    /**
     * Ordena un array de cadenas por el metodo QuickSort
     * @param array
     * @param izq
     * @param der 
     */
    public static void ordenacionQuicksort (String array[], int izq, int der){
        int i=izq;
        int j=der;
        int pivote=(i+j)/2; //determinamos el pivote
        do {
            //uso compareIgnoreCase para indicar si es mayor o no una cadena
            while (array[i].compareToIgnoreCase(array[pivote])<0){
                i++;
            }
            while (array[j].compareToIgnoreCase(array[pivote])>0){
                j--;
            }
            if (i<=j){
                //intercambio
                String aux=array[i];
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
     * Ordena un array de cadenas por el metodo QuickSort
     * @param array
     * @param izq
     * @param der 
     */
    public static void ordenacionQuicksortInverso (String array[], int izq, int der){
        int i=izq;
        int j=der;
        int pivote=(i+j)/2; //determinamos el pivote
        do {
            //uso compareIgnoreCase para indicar si es mayor o no una cadena
            while (array[i].compareToIgnoreCase(array[pivote])>0){
                i++;
            }
            while (array[j].compareToIgnoreCase(array[pivote])<0){
                j--;
            }
            if (i<=j){
                //intercambio
                String aux=array[i];
                array[i]=array[j];
                array[j]=aux;
                i++;
                j--;
            }
        }while(i<=j);
        //llamada de funciones (recursivo)
        if (izq<j){
            ordenacionQuicksortInverso(array, izq, j);
        }
        if (i<der){
            ordenacionQuicksortInverso(array, i, der);
        }
    }
}
