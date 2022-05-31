
package ejercicio_recursividad_ddr_8;


public class Ejercicio_recursividad_DDR_8 {

    public static void main(String[] args) {
        
        String palabra = "Hola";
        System.out.println(invertirPalabra(palabra, palabra.length()-1));
        
        
    }
    
     public static String invertirPalabra(String palabra, int longitud){
        
        if(longitud==0){
            return palabra.charAt(longitud)+"";
        }else{
            return palabra.charAt(longitud) + (invertirPalabra(palabra, longitud-1));
        }
        
    }
    
}
