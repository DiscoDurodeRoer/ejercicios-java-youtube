package ejercicio_ficheros_ddr_03;

import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ejercicio_ficheros_DDR_03 {

    public static void main(String[] args) {
        
        //Pedimos la ruta
        //No hay problemas de \ con este metodo
        String ruta=JOptionPane.showInputDialog(null, 
                                                "Inserta la ruta del fichero", 
                                                "Insercion", 
                                                JOptionPane.INFORMATION_MESSAGE);
        
        //variables que usaremos para contar
        int contadorVocales=0;
        int contadorConsonantes=0;
        int contadorNumeros=0;
        
        //Abrimos un nuevo strem de lectura
        try(FileReader fr=new FileReader(ruta)){
        
            int caracter;
            
            //Codigos ascii de las vocales en mayusculas
            int vocales[]={65,69,73,79,85};
            boolean esVocal;
            
            //Hasta que llegue al final del fichero
            while( (caracter = fr.read()) != -1 ){
                
                if(caracter>=48 && caracter<=57){ //Si es verdadero, es un numero
                    contadorNumeros++;
                }else if( (caracter >=65 && caracter <=90) || 
                                (caracter >=97 && caracter <=122)){ //Si es verdadero, es una letra
                    
                    esVocal=false;
                    for(int i=0;i<vocales.length && !esVocal;i++){
                        //Comprobamos que es una vocal
                        if( (caracter==vocales[i]) || (caracter==(vocales[i]+32)) ){
                            esVocal=true;
                        }
                    }
                    
                    //Si es vocal, aumentamos el contador de vocales, sino el de consonantes
                    if(esVocal){
                        contadorVocales++;
                    }else{
                        contadorConsonantes++;
                    }
                    
                }
                
                
            }
            
        }catch(IOException e){
            System.out.println("Error");
        }
        
        //Mostramos los resultados
        System.out.println("Hay "+contadorVocales+" vocales");
        System.out.println("Hay "+contadorConsonantes+" consonantes");
        System.out.println("Hay "+contadorNumeros+" numeros");
        
    }
    
}
