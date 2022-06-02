package ejercicio_expresiones_regulares_ddr_2;

public class Ejercicio_expresiones_regulares_DDR_2 {

    public static void main(String[] args) {

        System.out.println("Manuel: " + validarNombre("Manuel"));
        System.out.println("Fernando: " + validarNombre("Fernando"));
        System.out.println("Manuel Fernando: " + validarNombre("Manuel Fernando"));
        System.out.println("manuel: " + validarNombre("manuel"));
        System.out.println("12343: " + validarNombre("12343"));
        System.out.println("Manuel  Fernando: " + validarNombre("Manuel  Fernando"));
        System.out.println("M: " + validarNombre("M"));
        System.out.println("Ma: " + validarNombre("Ma"));

    }

    public static boolean validarNombre(String nombre) {

        return nombre.matches("^([A-Z]{1}[a-z]+[ ]*){1,2}$");

    }

}
