/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_matrices_DDR_02;

import java.util.Scanner;

/**
 *
 * @author fernandos
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sn=new Scanner(System.in);
        
        System.out.println("Escriba un numero de columnas");
        int columnas=sn.nextInt();
        
        int matriz[][]=new int[5][columnas];
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                matriz[i][j]=generaNumAleatorio(0,9);
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("");
            
        }
        
    }
    
    public static int generaNumAleatorio(int minimo,int maximo){
        
        return (int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        
    }
    
}
