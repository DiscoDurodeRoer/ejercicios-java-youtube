/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_matrices_ddr_06;

import java.util.Arrays;

public class Ejercicio_matrices_DDR_06 {

   
    public static void main(String[] args) {
      
        int matriz[][]=new int [3][3];
        
        int[] numeros=generarNumerosAleatoriosSinRepetir(1, 9, matriz.length*matriz[0].length);
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j]=numeros[(matriz.length*i) + j ];
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
        }
        
        
        
    }
    
    
    //Funcion para generar numeroa aleatorios que no se repitan
    public static int[] generarNumerosAleatoriosSinRepetir(int minimo, int maximo, int longitud){
       
        //En caso de que uno sea mayotr que otro
        //Lo intercambiamos
        if(maximo<minimo){
            int aux=maximo;
            maximo=minimo;
            minimo=aux;
        }
        
        //Si caben los numeros del rango
        //Generamos el array
        if( (maximo-minimo) >= (longitud-1) ){
        
            int numero_elementos=0;
            int numeros[]=new int[longitud];
            //RECOMENDADO: rellena el arreglo con un numero que nunca se va a generar
            Arrays.fill(numeros, minimo-1);
            boolean encontrado;
            int aleatorio;
            
            //Hasta que el numero de elementos no sea como el de la longitud del array no salimos
            while(numero_elementos<longitud){
                
                aleatorio=generaNumeroAleatorio(minimo, maximo);
                encontrado=false;            

                //Buscamos si el numero existe
                for(int i=0;i<numeros.length && !encontrado;i++){
                    if(aleatorio==numeros[i]){
                        encontrado=true;
                    }
                }
                
                //Sino lo agregamos
                if(!encontrado){
                    numeros[numero_elementos++] = aleatorio;
                }
                
            }
            
            return numeros;
            
        }else{
            System.out.println("No se puede generar el arreglo, revusa los parametros");
            return null;
        }
        
        
    }
    
    //Genera un numero aleatorio entre el minimo y el maximo, includo el maximo y el minimo
    public static int generaNumeroAleatorio(int minimo,int maximo){
        
        int num=(int)Math.floor(Math.random()*(maximo-minimo+1)+(minimo));
        return num;
    }
    
    
}
   
        
    