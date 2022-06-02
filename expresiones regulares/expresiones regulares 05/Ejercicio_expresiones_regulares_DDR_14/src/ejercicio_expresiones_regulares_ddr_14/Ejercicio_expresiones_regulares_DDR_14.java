package ejercicio_expresiones_regulares_ddr_14;

public class Ejercicio_expresiones_regulares_DDR_14 {

    public static void main(String[] args) {

        System.out.println(validarFecha("02/09/2010"));
        System.out.println(validarFecha("02/9/2010"));
        System.out.println(validarFecha("02/09/010"));
        System.out.println(validarFecha("2/9/2010"));
        System.out.println(validarFecha("30/11/2021"));
        System.out.println(validarFecha("00/12/2010"));
        System.out.println(validarFecha("15/15/1510"));
        System.out.println(validarFecha("22/7/1910"));
        
    }
    
    public static boolean validarFecha(String texto){
        return texto.matches("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/]([012][0-9])\\d{2}$");
    }


}
