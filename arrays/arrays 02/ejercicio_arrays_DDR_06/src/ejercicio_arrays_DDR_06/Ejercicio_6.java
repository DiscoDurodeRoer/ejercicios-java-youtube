package ejercicio_arrays_DDR_06;

public class Ejercicio_6 {

    public static void main(String[] args) {
        
        //Creamos el array
        int numeros[]={1,2,3,4,5};
        
        //Creamos uno auxiliar (vacio)
        int aux[]=new int[numeros.length];
        
        /*Recorremos el array auxiliar, cogiendo las ultimas posiciones
            del array numeros hasta las primeras
        */
        for(int i=numeros.length-1, j=0;i>=0;i--,j++){
            aux[j]=numeros[i];
            System.out.println(aux[j]);
        }
        
        numeros=aux; //Copiamos la referencia de aux a numeros
        
        aux=null; //Dejamos aux sin referencia
    }
    
}
