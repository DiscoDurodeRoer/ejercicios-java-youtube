package ejercicio_recursividad_ddr_19;

public class Ejercicio_recursividad_DDR_19 {

    public static void main(String[] args) {
         String cadena = "Hola";
        int indice = 0;

        mostrarCadenaRec(cadena, indice);
        System.out.println("");
    }

    public static void mostrarCadenaRec(String cadena, int indice) {
        try {
            char c = cadena.charAt(indice);
            System.out.print(c);
            mostrarCadenaRec(cadena, indice + 1);
        } catch (IndexOutOfBoundsException ex) {}
    }
}
