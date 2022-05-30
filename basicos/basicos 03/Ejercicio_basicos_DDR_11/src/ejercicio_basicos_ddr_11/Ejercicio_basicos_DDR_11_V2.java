package ejercicio_basicos_ddr_11;

import javax.swing.JOptionPane;

public class Ejercicio_basicos_DDR_11_V2 {

    public static void main(String[] args) {
        
        String texto=JOptionPane.showInputDialog(null, 
                                                "Inserta una frase", 
                                                "Inserción", 
                                                JOptionPane.INFORMATION_MESSAGE);
        //lo pasamos a minusculas para igualar todas las letras
        texto=texto.toLowerCase();
        
        int contador_vocales=0;
        
        char caracterActual;
        
        for(int i=0;i<texto.length();i++){
            
            caracterActual=texto.charAt(i);
        
            //otra forma de comparar
            if( caracterActual=='a' ||
                caracterActual=='e' ||
                caracterActual=='i' ||
                caracterActual=='o' ||
                caracterActual=='u'){
                contador_vocales++; //aumeta el contador
            }
            
        }
        
        JOptionPane.showMessageDialog(null, 
                                      "La frase tiene "+contador_vocales+" vocales", 
                                      "Resultado", 
                                      JOptionPane.INFORMATION_MESSAGE);
        
        
        
        
    }
    
}
