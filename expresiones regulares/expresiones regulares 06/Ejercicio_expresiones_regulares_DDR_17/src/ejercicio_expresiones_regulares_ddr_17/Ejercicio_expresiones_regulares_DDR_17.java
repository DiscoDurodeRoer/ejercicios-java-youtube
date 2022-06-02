package ejercicio_expresiones_regulares_ddr_17;

public class Ejercicio_expresiones_regulares_DDR_17 {

    public static void main(String[] args) {
        System.out.println(validarUsuarioTwitter("@discoduroderoer"));
        System.out.println(validarUsuarioTwitter("@discoduroderoer_gaming"));
        System.out.println(validarUsuarioTwitter("@discoduroderoer@discoduroderoer@discoduroderoer"));
        System.out.println(validarUsuarioTwitter("@"));
    }
    
    
    public static boolean validarUsuarioTwitter(String usuario){
        return usuario.matches("^@([A-Za-z0-9_-]){1,30}$");
    }
    
}
