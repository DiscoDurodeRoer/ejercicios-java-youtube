package ejercicio_poo_ddr_12;

/**
 * Clase Metodos, contiene métodos estaricos sueltos
 * @author Disco Duro de Roer
 */
public class Metodos {

    public static int generaNumeroEnteroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

}
