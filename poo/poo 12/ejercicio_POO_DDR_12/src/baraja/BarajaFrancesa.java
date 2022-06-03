package baraja;

import enumerados.PalosBarajaFrancesa;

/**
 * Baraja francesa
 * @author Disco Duro de Roer
 */
public class BarajaFrancesa extends Baraja {

    public BarajaFrancesa() {
        super();

        this.numCartas = 52;
        this.cartasPorPalo = 13;

        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }

    @Override
    public void crearBaraja() {

        this.cartas = (Carta<PalosBarajaFrancesa>[]) new Carta[numCartas];

        PalosBarajaFrancesa[] palos = PalosBarajaFrancesa.values();

        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {

            //Recorro los numeros
            for (int j = 0; j < cartasPorPalo; j++) {
                cartas[((i * cartasPorPalo) + j)] = new Carta(j + 1, palos[i]);
            }

        }

    }

    public boolean cartaRoja(Carta<PalosBarajaFrancesa> c) {
        return c.getPalo() == PalosBarajaFrancesa.CORAZONES || c.getPalo() == PalosBarajaFrancesa.DIAMANTES;
    }

    public boolean cartaNegra(Carta<PalosBarajaFrancesa> c) {
        return c.getPalo() == PalosBarajaFrancesa.TREBOLES || c.getPalo() == PalosBarajaFrancesa.PICAS;
    }

}
