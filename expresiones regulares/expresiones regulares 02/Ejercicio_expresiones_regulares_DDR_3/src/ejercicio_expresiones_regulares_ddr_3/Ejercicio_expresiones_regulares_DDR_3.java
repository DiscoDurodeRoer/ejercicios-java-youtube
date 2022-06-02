package ejercicio_expresiones_regulares_ddr_3;

public class Ejercicio_expresiones_regulares_DDR_3 {

    public static void main(String[] args) {
        
        System.out.println("100: " + validarNumeroEntero("100"));
        
        System.out.println("-100: " + validarNumeroEntero("-100"));
        System.out.println("abc: " + validarNumeroEntero("abc"));
        System.out.println("20000: " + validarNumeroEntero("20000"));
        System.out.println("0: " + validarNumeroEntero("0"));
        System.out.println("100a: " + validarNumeroEntero("100a"));
        System.out.println("a100: " + validarNumeroEntero("a100"));
        System.out.println("1-00: " + validarNumeroEntero("1-00"));
        
        
    }
    
    public static boolean validarNumeroEntero(String texto){
        return texto.matches("^-?[0-9]+$");
    }
    
}
