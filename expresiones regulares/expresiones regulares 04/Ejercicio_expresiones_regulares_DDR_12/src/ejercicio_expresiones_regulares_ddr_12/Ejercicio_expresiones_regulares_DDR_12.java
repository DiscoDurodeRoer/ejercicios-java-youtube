package ejercicio_expresiones_regulares_ddr_12;

public class Ejercicio_expresiones_regulares_DDR_12 {

    public static void main(String[] args) {

        System.out.println(validarReal("-5.5", 1));
        System.out.println(validarReal("5.5", 2));
        System.out.println(validarReal("5_5", 1));
        System.out.println(validarReal("5,500", 3));
        System.out.println(validarReal("5,5", -1));
        System.out.println(validarReal("-5,", -1));
        System.out.println(validarReal("-5", 1));

    }

    public static boolean validarReal(String texto, int numDecimales) {
        if (numDecimales >= 0) {
            return texto.matches("^-?[0-9]+([\\.,][0-9]{" + numDecimales + "," + numDecimales + "})?$");
        } else {
            return false;
        }
    }

}
