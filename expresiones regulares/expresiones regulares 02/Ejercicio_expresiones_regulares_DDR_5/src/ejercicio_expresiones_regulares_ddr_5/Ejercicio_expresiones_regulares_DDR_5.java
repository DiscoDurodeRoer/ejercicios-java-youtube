package ejercicio_expresiones_regulares_ddr_5;

public class Ejercicio_expresiones_regulares_DDR_5 {

    public static void main(String[] args) {

        System.out.println("100: " + validarNumeroNegativo("100"));

        System.out.println("-100: " + validarNumeroNegativo("-100"));
        System.out.println("abc: " + validarNumeroNegativo("abc"));
        System.out.println("20000: " + validarNumeroNegativo("20000"));
        System.out.println("0: " + validarNumeroNegativo("0"));
        System.out.println("100a: " + validarNumeroNegativo("100a"));
        System.out.println("a100: " + validarNumeroNegativo("a100"));

    }

    public static boolean validarNumeroNegativo(String texto) {
        return texto.matches("^-[0-9]+$");
    }

}
