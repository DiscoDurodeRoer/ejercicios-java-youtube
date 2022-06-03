package baraja;

import enumerados.PalosBarajaFrancesa;

public class CartaFrancesa extends Carta<PalosBarajaFrancesa> {

    public CartaFrancesa(int numero, PalosBarajaFrancesa palo) {
        super(numero, palo);
    }

    public CartaFrancesa() {
    }

    @Override
    public String toString() {

        String estado = "";
        String nombreFigura = "";

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

        estado = nombreFigura + " de " + palo;

        return estado;

    }

}
