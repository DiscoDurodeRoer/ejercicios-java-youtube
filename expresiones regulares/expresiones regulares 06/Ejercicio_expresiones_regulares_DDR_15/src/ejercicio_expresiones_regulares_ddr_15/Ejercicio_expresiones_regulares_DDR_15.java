package ejercicio_expresiones_regulares_ddr_15;

public class Ejercicio_expresiones_regulares_DDR_15 {

    public static void main(String[] args) {
        System.out.println(validarIP("192.168.1.1"));
        System.out.println(validarIP("127.0.0.1"));
        System.out.println(validarIP("258.1.1.1"));
        System.out.println(validarIP("1288.1.1.1"));
        System.out.println(validarIP("0.0.0.0"));
        System.out.println(validarIP("65.14.85.255"));
    }
    
    public static boolean validarIP(String IP){
        return IP.matches("^([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])\\.([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])$");
    }

    
}
