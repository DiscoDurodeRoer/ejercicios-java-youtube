package ejercicio_poo_ddr_05;

/**
 * Clase Carta
 * @author Disco Duro de Roer
 */
public class Carta {
    
    //Atributos
    private int numero;
    private String palo;
    
    //Constantes
    public static final String[] PALOS={"ESPADAS", "OROS", "COPAS", "BASTOS"};
    public static final int LIMITE_CARTA_PALO=12;

    //Constructor
    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "numero=" + numero + ", palo=" + palo;
    }
    
}
