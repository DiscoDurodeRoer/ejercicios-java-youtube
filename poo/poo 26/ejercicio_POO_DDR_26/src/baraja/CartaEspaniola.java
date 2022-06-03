package baraja;

import enumerados.PalosBarajaEspañola;

public class CartaEspaniola extends Carta<PalosBarajaEspañola> {

    public CartaEspaniola(int numero, PalosBarajaEspañola palo) {
        super(numero, palo);
    }

    public CartaEspaniola() {
    }

    @Override
    public String toString() {

        String estado = "";
        String nombreFigura = "";

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

        estado = nombreFigura + " de " + palo;

        return estado;

    }

}
