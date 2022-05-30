package ejercicio_arrays_ddr_09;

public class Ejercicio_arrays_DDR_09 {

    public static void main(String[] args) {
        
        //array a ordenar
        int numeros[]={5,6,2,10,1};
        
        //llamada funcion
        ordenacionBurbuja(numeros);
        
        //mostrar el contenido
        for(int i=0;i<numeros.length;i++){
            System.out.println(numeros[i]);
        }
        
    }
    
    /**
     * Ordena un array de enteros por el metodo de la burbuja
     * @param lista 
     */
    public static void ordenacionBurbuja (int lista[]){
        int cuentaintercambios=0; //Variable que cuenta los intercambios que hacemos
        for (boolean ordenado=false;!ordenado;){ //hasta que no haya mas intercambios no sales
                for (int i=0;i<lista.length-1;i++){
                    if (lista[i]>lista[i+1]){
                        //intercambio
                        int variableauxiliar=lista[i];
                        lista[i]=lista[i+1];
                        lista[i+1]=variableauxiliar;
                        //indico que ha habido un intercambio mas
                        cuentaintercambios++;
                    }
                }
                //Si no hay intercambios, el array esta ordenado
                if (cuentaintercambios==0){
                    ordenado=true;
                }
                cuentaintercambios=0; //Reinicio la variable
        }
    }
    
}
