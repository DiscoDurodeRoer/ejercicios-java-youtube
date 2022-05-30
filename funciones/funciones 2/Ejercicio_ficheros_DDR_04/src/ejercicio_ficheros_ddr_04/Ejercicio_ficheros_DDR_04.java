package ejercicio_ficheros_ddr_04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ejercicio_ficheros_DDR_04 {

    public static void main(String[] args) {
        
        String ruta=JOptionPane.showInputDialog(null, 
                                                "Inserta la ruta del fichero", 
                                                "Insercion", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        //Abrimos el stream de lectura
        //Abrimos otro de escritura (otro fichero distinto)
        try(FileReader fr=new FileReader(ruta);
                FileWriter fw=new FileWriter("D:\\test\\prueba2.txt")){
        
            int caracter;
            String resultado="";
            
            //leemos el fichero
            while( (caracter = fr.read()) != -1 ){
                
                if(caracter >=97 && caracter <=122){ //Si es una vocal, la pasamos a mayuscula 
                    resultado+=((char)(caracter-32));
                }else if(caracter!=32){ //Si es un espacio, no lo escribimos en el fichero
                    resultado+=(char)(caracter);
                }
                
            }
            
            //Guardamos el resultado en el nuevo fichero
            fw.write(resultado);
            
        }catch(IOException e){
            System.out.println("Error");
        }
        
        
    }
    
}
