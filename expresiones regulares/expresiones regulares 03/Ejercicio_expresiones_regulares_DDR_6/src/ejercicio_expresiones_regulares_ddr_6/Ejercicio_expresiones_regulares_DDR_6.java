package ejercicio_expresiones_regulares_ddr_6;

public class Ejercicio_expresiones_regulares_DDR_6 {

    public static void main(String[] args) {
        System.out.println(validarBinario("1001000"));
        System.out.println(validarBinario("11001100"));
        System.out.println(validarBinario("1001200"));
        System.out.println(validarBinario("0"));
        System.out.println(validarBinario("1"));
        System.out.println(validarBinario("000A010001111000000"));
    }
    
    public static boolean validarBinario(String binario){
        return binario.matches("^[0-1]+$");
    }
    
}
