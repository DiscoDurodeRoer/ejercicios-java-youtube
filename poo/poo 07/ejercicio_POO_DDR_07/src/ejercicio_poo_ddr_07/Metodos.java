package ejercicio_poo_ddr_07;

/**
 * @author Discoduroderoer
 */
public class Metodos {

    /**
     * Genera un numero aleatorio entre dos numeros
     * @param minimo
     * @param maximo
     * @return 
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
