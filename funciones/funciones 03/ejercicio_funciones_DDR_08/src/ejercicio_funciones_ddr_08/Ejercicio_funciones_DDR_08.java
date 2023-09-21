package ejercicio_funciones_ddr_08;

import javax.swing.JOptionPane;

/**
 * @author DiscoDurodeRoer
 */
public class Ejercicio_funciones_DDR_08 {

    public static void main(String[] args) {
       
        //Pido la cadena
        String texto=JOptionPane.showInputDialog(null, 
                                                "Inserta una frase", 
                                                "Insercion", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        int vocales=cuentaVocales(texto.toLowerCase());
        
        System.out.println("Hay "+vocales+" vocal/es");
        
    }
    
    //Funcion para contar el numero de vocales
    public static int cuentaVocales(String frase){
        
        int contador=0;
        
        //Vocales en un arreglo
        char vocales[]={'a', 'e', 'i', 'o', 'u'};
        
        char caracterActual;
        boolean esVocal;
        
        //Recorremos la cadena
        for(int i=0;i<frase.length();i++){
            
            caracterActual=frase.charAt(i);
            
            //Reiniciamos la variable
            esVocal=false;
            
            //Recorremos el array de vocales
            for(int j=0;j<vocales.length && !esVocal;j++){
                
                if(caracterActual==vocales[j]){
                    esVocal=true;
                }
                
            }
            
            //Si es una vocal, aumenta el contador
            if(esVocal){
               contador++;
            }
            
        }
        
        return contador;
        
    }
    
    
}
