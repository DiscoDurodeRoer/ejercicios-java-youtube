package ejercicio_expresiones_regulares_ddr_13;

public class Ejercicio_expresiones_regulares_DDR_13 {

    public static void main(String[] args) {

        System.out.println(validarMatricula("1234ABC"));
        System.out.println(validarMatricula("1234abc"));
        System.out.println(validarMatricula("12abc"));
        System.out.println(validarMatricula("1234AB"));
        System.out.println(validarMatricula("1A"));
        System.out.println(validarMatricula("12345ABC"));
        System.out.println(validarMatricula("1234a3b"));

    }

    public static boolean validarMatricula(String texto){
        return texto.matches("^[0-9]{4}[A-Z]{3}$");
    }
    

}
