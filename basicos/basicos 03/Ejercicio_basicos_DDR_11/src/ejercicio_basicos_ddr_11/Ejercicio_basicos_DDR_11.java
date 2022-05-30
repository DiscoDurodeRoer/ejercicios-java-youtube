package ejercicio_basicos_ddr_11;

import javax.swing.JOptionPane;

public class Ejercicio_basicos_DDR_11 {

    public static void main(String[] args) {
        
        String texto=JOptionPane.showInputDialog(null, 
                                                "Inserta una frase", 
                                                "Inserción", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        //lo pasamos a minusculas para igualar todas las letras
        texto=texto.toLowerCase(); 
        
        int contador_vocales=0;
        
        //Arrays con vocales
        char vocales[]={'a', 'e', 'i', 'o', 'u'};
        
        char caracterActual;
        boolean esVocal=false;
        
        //recorro la cadena
        for(int i=0;i<texto.length();i++){
            
            caracterActual=texto.charAt(i);
            
            //Recorro las vocales comparando con el caracter
            //Cuando lo encuentra, aumenta el contador y sale del bucle
            for(int j=0;j<vocales.length && !esVocal;j++){
                if(caracterActual==vocales[j]){
                    esVocal=true;
                    contador_vocales++;
                }
            }
            
            esVocal=false;
            
        }
        
        JOptionPane.showMessageDialog(null, 
                                      "La frase tiene "+contador_vocales+" vocales", 
                                      "Resultado", 
                                      JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
