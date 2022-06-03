package ejercicio_ed_5_discoduroderoer;

/**
 * @author Discoduroderoer
 */
public class Metodos {

    /**
     * Genera un numero aleatorio entre dos numeros. Entre el minimo y el maximo
     * incluidos
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

    /**
     * Genera un numero aleatorio entre dos numeros reales. Entre el minimo y el
     * maximo incluidos Devuelve un numero con dos decimales.
     *
     * @param minimo Número mínimo
     * @param maximo Número máximo
     * @return Número entre minimo y maximo
     */
    public static double generaNumeroRealAleatorio(double minimo, double maximo) {

        double num = Math.rint(Math.floor(Math.random() * (minimo - ((maximo * 100) + 1)) + ((maximo * 100) + 1))) / 100;
        return num;

    }
}
