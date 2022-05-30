/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_basicos_ddr_14;

import javax.swing.JOptionPane;

/**
 *Ejercicio 14 version 2 Básicos
 * @author Discoduroderoer
 */
public class Ejercicio_basicos_DDR_14_v2 {

    public static void main(String[] args) {
        
        String texto=JOptionPane.showInputDialog(null, 
                                                "Por favor, introduce una frase", 
                                                "Introducción", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        String cadenaResultante;
        
        //true = Lo pasamos todo a mayusculas
        //false= Lo pasamos todo a minusculas
        boolean isMayus;
        
        int eleccion=JOptionPane.showConfirmDialog(null, 
                                        "¿Quieres que se pase a mayusculas?", 
                                        "Eleccion", 
                                        JOptionPane.YES_NO_OPTION);
        
        isMayus=  (eleccion==JOptionPane.YES_OPTION);
        
        //Segun lo elegido, lo transformaremos a mayuscula o minuscula
        if(isMayus){
             cadenaResultante=texto.toUpperCase();
        }else{
            cadenaResultante=texto.toLowerCase();
        }

        //Mostramos el mensaje resultante
        JOptionPane.showMessageDialog(null, 
                                        cadenaResultante, 
                                        "Resultado", 
                                        JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
