package baraja;

/**
 * Clase Carta
 *
 * @author Disco Duro de Roer
 */
public abstract class Carta<T> {

    //Atributos
    protected int numero;
    protected T palo;

    public int getNumero() {
        return numero;
    }

    public T getPalo() {
        return palo;
    }

    //Constructor
    public Carta(int numero, T palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Carta() {
    }

}
