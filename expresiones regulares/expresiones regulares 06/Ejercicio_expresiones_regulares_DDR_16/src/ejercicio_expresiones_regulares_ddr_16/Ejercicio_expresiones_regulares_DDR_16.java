package ejercicio_expresiones_regulares_ddr_16;

public class Ejercicio_expresiones_regulares_DDR_16 {

    public static void main(String[] args) {
        System.out.println(validarISBN("9781234567891"));
        System.out.println(validarISBN("97912345678911"));
        System.out.println(validarISBN("9801234567891"));
        System.out.println(validarISBN("978123456789"));
        System.out.println(validarISBN("978"));
    }
    
    public static boolean validarISBN(String ISBN){
        return ISBN.matches("^(978|979)[0-9]{10}$");
    }
}
