package ejercicio_poo_ddr_03;

public class MetodosSueltos {
    
    /**
     * Genera un numero aleatorio entre dos numeros.
     * Entre el minimo y el maximo
     * @param minimo
     * @param maximo
     * @return numero entre minimo y maximo
     */
    public static int generaNumeroAleatorio(int minimo, int maximo){
        
        int num=(int)Math.floor(Math.random()*(minimo-(maximo+1))+(maximo+1));
        return num;
    }
    
}
