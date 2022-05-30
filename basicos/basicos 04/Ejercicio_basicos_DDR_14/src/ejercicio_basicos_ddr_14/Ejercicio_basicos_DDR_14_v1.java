package ejercicio_basicos_ddr_14;

import javax.swing.JOptionPane;

public class Ejercicio_basicos_DDR_14_v1 {

    public static void main(String[] args) {
        
        String texto=JOptionPane.showInputDialog(null, 
                                                "Por favor, introduce una frase", 
                                                "Introducción", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        String cadenaResultante="";
        
        //true = Lo pasamos todo a mayusculas
        //false= Lo pasamos todo a minusculas
        boolean isMayus;
        final int DIFERENCIA=32;
        
        String[] opciones={"Mayusculas", "Minusculas"};
        int eleccion=JOptionPane.showOptionDialog(null, 
                                                  "Elige tu opcion", 
                                                  "Eleccion", 
                                                  JOptionPane.YES_NO_OPTION, 
                                                  JOptionPane.QUESTION_MESSAGE, 
                                                  null, 
                                                  opciones, 
                                                  opciones[0]);
        
        
        isMayus= (eleccion==JOptionPane.YES_OPTION);
        
        char caracterActual;
        
        for(int i=0;i<texto.length();i++){
            
            //obtenemos el caracter de la pos i
            caracterActual=texto.charAt(i);
            
            if(isMayus){
                
                //Si esta entre esos valores, lo cambia a mayucula
                // Puedes sustituir 97 por 'a' y asi con todos
                if(caracterActual>=97 && caracterActual<=122){
                    cadenaResultante+=(char)(caracterActual-DIFERENCIA);
                }else{
                    //Si no es un caracter alfabetico en minuscula, lo agregamos
                    // sin hacerle nada
                    cadenaResultante+=caracterActual;
                }
                
            }else{
                
                //Si esta entre esos valores, lo cambia a minuscula
                // Puedes sustituir 65 por 'A' y asi con todos
                if(caracterActual>=65 && caracterActual<=90){
                    cadenaResultante+=(char)(caracterActual+DIFERENCIA);
                }else{
                    //Si no es un caracter alfabetico en minuscula, lo agregamos
                    // sin hacerle nada
                    cadenaResultante+=caracterActual;
                }
                
            }
        }
        
        //Mostramos la cadena resultante
        JOptionPane.showMessageDialog(null, 
                                        cadenaResultante, 
                                        "Resultado", 
                                        JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
