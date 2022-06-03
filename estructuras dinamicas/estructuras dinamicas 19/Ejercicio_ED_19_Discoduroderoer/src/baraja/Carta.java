package baraja;

/**
 * Clase Carta
 *
 * @author Disco Duro de Roer
 */
public class Carta<T> {

    //Atributos
    private int numero;
    private T palo;

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

    @Override
    public String toString() {

        String estado = "";
        String nombreFigura = "";

        if (palo.getClass().getSimpleName().equals("PalosBarajaEspañola")) {

            switch (numero) {
                case 1:
                    nombreFigura = "As";
                    break;
                case 10:
                    nombreFigura = "Sota";
                    break;
                case 11:
                    nombreFigura = "Caballo";
                    break;
                case 12:
                    nombreFigura = "Rey";
                    break;
                default:
                    nombreFigura = numero + "";
            }

        } else if (palo.getClass().getSimpleName().equals("PalosBarajaFrancesa")) {

            switch (numero) {
                case 1:
                    nombreFigura = "As";
                    break;
                case 11:
                    nombreFigura = "Jota";
                    break;
                case 12:
                    nombreFigura = "Reina";
                    break;
                case 13:
                    nombreFigura = "Rey";
                    break;
                default:
                    nombreFigura = numero + "";
            }

        }

        estado = nombreFigura + " de " + palo;

        return estado;

    }

}
