package ejercicio_expresiones_regulares_ddr_1;

public class Ejercicio_expresiones_regulares_DDR_1 {

    public static void main(String[] args) {

        System.out.println("70588387F: " + validaDNI("70588387F")); //true

        System.out.println("0588387F: " + validaDNI("0588387F")); //true
        System.out.println("F70588387: " + validaDNI("F70588387")); //false
        System.out.println("7058F8387: " + validaDNI("7058F8387")); //false

        System.out.println("7058F8387: " + validaDNI("7058F8387")); //false

        System.out.println("1: " + validaDNI("1")); //false
        System.out.println("12345678: " + validaDNI("12345678")); //false
        System.out.println("12345678I: " + validaDNI("12345678I")); //false

    }

    public static boolean validaDNI(String DNI) {

        return DNI.matches("^[0-9]{7,8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");

    }

}
