package ejercicio_expresiones_regulares_ddr_11;

public class Ejercicio_expresiones_regulares_DDR_11 {

    public static void main(String[] args) {

        System.out.println(validarRealNegativo("-5.5"));
        System.out.println(validarRealNegativo("5.5"));
        System.out.println(validarRealNegativo("5_5"));
        System.out.println(validarRealNegativo("5,5"));
        System.out.println(validarRealNegativo(",5"));
        System.out.println(validarRealNegativo("-5,"));
        System.out.println(validarRealNegativo("-5"));

    }

    public static boolean validarRealNegativo(String texto) {

        return texto.matches("^-[0-9]+([\\.,][0-9]+)?$");

    }

}
