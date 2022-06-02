package ejercicio_expresiones_regulares_ddr_9;

public class Ejercicio_expresiones_regulares_DDR_9 {

    public static void main(String[] args) {

        System.out.println(validarReal("-5.5"));
        System.out.println(validarReal("5.5"));
        System.out.println(validarReal("5_5"));
        System.out.println(validarReal("5,5"));
        System.out.println(validarReal(",5"));
        System.out.println(validarReal("5,"));
        System.out.println(validarReal("5"));
        
        
    }

    public static boolean validarReal(String texto){
        
        return texto.matches("^-?[0-9]+([\\.,][0-9]+)?$");
        
    }
    
}
