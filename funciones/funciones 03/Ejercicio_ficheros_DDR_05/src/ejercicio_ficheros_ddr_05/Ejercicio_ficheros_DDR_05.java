package ejercicio_ficheros_ddr_05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_ficheros_DDR_05 {

    public static void main(String[] args) {
        
        //Escribimos el texto a escribir
        String texto1="Dale like ";
        String texto2="si te mola el video";
        
        //Abrimo el stream
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\test\\prueba_buffered.txt"))){
            
            bw.write(texto1); //Escribimos en el fichero
            bw.newLine(); //Introduce una nueva linea, cuidado con /n
            bw.write(texto2);//Escribimos en el fichero
            
        }catch(IOException e){
            System.out.println("Error");
        }
        
    }
    
}
