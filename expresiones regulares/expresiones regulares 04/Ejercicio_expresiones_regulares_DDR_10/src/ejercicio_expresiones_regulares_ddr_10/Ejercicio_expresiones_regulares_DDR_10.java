package ejercicio_expresiones_regulares_ddr_10;

public class Ejercicio_expresiones_regulares_DDR_10 {

    public static void main(String[] args) {

        System.out.println(validarRealPositivo("-5.5"));
        System.out.println(validarRealPositivo("5.5"));
        System.out.println(validarRealPositivo("5_5"));
        System.out.println(validarRealPositivo("5,5"));
        System.out.println(validarRealPositivo(",5"));
        System.out.println(validarRealPositivo("5,"));
        System.out.println(validarRealPositivo("5"));

    }

    public static boolean validarRealPositivo(String texto) {

        return texto.matches("^[0-9]+([\\.,][0-9]+)?$");

    }
}
