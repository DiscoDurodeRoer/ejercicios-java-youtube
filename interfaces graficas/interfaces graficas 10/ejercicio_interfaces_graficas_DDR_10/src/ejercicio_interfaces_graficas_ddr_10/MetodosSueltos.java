package ejercicio_interfaces_graficas_ddr_10;

public class MetodosSueltos {

    public static boolean validar_Mail_Exp(String email) {

        return email.matches("^([\\w-]+\\.)*?[\\w-]+@[\\w-]+\\.([\\w-]+\\.)*?[\\w]+$");

    }

}
