package ejercicio_ficheros_ddr_06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio_ficheros_DDR_06 {

    public static void main(String[] args) {
        
        //Abrimos el stream
        try(BufferedReader br=new BufferedReader(new FileReader("D:\\test\\prueba_buffered.txt"))){
            
            String linea;
            
            //Leemos el fichero, linea a linea
            while ( (linea = br.readLine()) != null ){
                System.out.println(linea); //mostramos
            }
            
        }catch(IOException e){
            System.out.println("Error");
        }
        
        
    }
    
}
