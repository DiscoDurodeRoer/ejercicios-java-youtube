package ejercicio_expresiones_regulares_ddr_4;

public class Ejercicio_expresiones_regulares_DDR_4 {

    public static void main(String[] args) {
     
         System.out.println("100: " + validarNumeroEnteroPositivo("100"));
        
        System.out.println("-100: " + validarNumeroEnteroPositivo("-100"));
        System.out.println("abc: " + validarNumeroEnteroPositivo("abc"));
        System.out.println("20000: " + validarNumeroEnteroPositivo("20000"));
        System.out.println("0: " + validarNumeroEnteroPositivo("0"));
        System.out.println("100a: " + validarNumeroEnteroPositivo("100a"));
        System.out.println("a100: " + validarNumeroEnteroPositivo("a100"));
        
        
        
    }
    
    public static boolean validarNumeroEnteroPositivo(String texto){
        return texto.matches("^[0-9]+$");
    }
    
}
