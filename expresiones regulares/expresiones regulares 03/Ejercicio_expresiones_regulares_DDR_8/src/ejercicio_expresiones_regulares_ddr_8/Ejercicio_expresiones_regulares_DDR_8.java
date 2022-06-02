package ejercicio_expresiones_regulares_ddr_8;

public class Ejercicio_expresiones_regulares_DDR_8 {

    public static void main(String[] args) {
        System.out.println(validarHexadecimal("00FF11"));
        System.out.println(validarHexadecimal("0GFF11"));
        System.out.println(validarHexadecimal("00ff11"));
        System.out.println(validarHexadecimal("003311"));
        System.out.println(validarHexadecimal("ABCDEF"));
        System.out.println(validarHexadecimal("123FF11"));
    }
    
    public static boolean validarHexadecimal(String hexadecimal){
        return hexadecimal.matches("^[0-9A-F]+$");
    }
    
}
