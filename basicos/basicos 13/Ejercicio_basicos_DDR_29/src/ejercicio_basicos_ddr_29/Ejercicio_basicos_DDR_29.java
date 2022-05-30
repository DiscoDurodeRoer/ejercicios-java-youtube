package ejercicio_basicos_ddr_29;

import java.util.Scanner;

public class Ejercicio_basicos_DDR_29 {

    public static void main(String[] args) {
        
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        
        String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";

        System.out.println("Dame una frase");
        String frase = sn.next();
        
        String texto = codificar(letras, frase);
        System.out.println("Texto codificado: " + texto);
        
        texto = descodificar(letras, texto);
        System.out.println("Texto descodificado: " + texto);
        
    }
    
    public static String codificar(String letras, String texto){
        String textoCodificado = "";
        
        texto = texto.toUpperCase();
        
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            
            int pos = letras.indexOf(caracter);
         
            if(pos == -1){
                textoCodificado += caracter;
            }else{
                textoCodificado += letras.charAt( (pos + 3) % letras.length() );
            }
            
        }
        
        return textoCodificado;
    }
    
    public static String descodificar(String letras, String texto){
        String textoDescodificado = "";
        
        texto = texto.toUpperCase();
        
        char caracter;
        for (int i = 0; i < texto.length(); i++) {
            caracter = texto.charAt(i);
            
            int pos = letras.indexOf(caracter);
         
            if(pos == -1){
                textoDescodificado += caracter;
            }else{
                if(pos - 3 < 0){
                    textoDescodificado += letras.charAt( letras.length() + (pos - 3) );
                }else{
                    textoDescodificado += letras.charAt( (pos - 3) % letras.length() );
                }
            }
            
        }
        
        return textoDescodificado;
    }
    
}
