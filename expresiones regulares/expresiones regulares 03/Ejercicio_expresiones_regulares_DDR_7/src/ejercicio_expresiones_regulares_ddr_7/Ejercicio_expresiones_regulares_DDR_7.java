
package ejercicio_expresiones_regulares_ddr_7;

public class Ejercicio_expresiones_regulares_DDR_7 {

    public static void main(String[] args) {
        System.out.println(validarOctal("56"));
        System.out.println(validarOctal("14"));
        System.out.println(validarOctal("78"));
        System.out.println(validarOctal("55421"));
        System.out.println(validarOctal("77458025"));
        System.out.println(validarOctal("456321A"));
        System.out.println(validarOctal("65321452"));
    }
    
    public static boolean validarOctal(String octal){
        return octal.matches("^[0-7]+$");
    }
    
}
