package ejercicio_poo_ddr_05;

/**
 * Clase Metodos, contiene métodos estaricos sueltos
 * @author Trabajo
 */
public class Metodos {

    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

}
