package baraja;

import enumerados.PalosBarajaEspañola;

/**
 * Baraja Española
 * @author Disco Duro de Roer
 */
public class BarajaEspaniola extends Baraja<CartaEspaniola> {

    private boolean incluye_8_9;

    public BarajaEspaniola(boolean incluye_8_9) {
        super();

        this.incluye_8_9 = incluye_8_9;

        if (incluye_8_9) {
            numCartas = 48;
            cartasPorPalo = 12;
        } else {
            numCartas = 40;
            cartasPorPalo = 10;
        }

        crearBaraja(); //Creamos la baraja
        super.barajar(); // barajamos la baraja
    }

    @Override
    public void crearBaraja() {

        PalosBarajaEspañola[] palos = PalosBarajaEspañola.values();

        //Recorro los palos
        for (int i = 0; i < palos.length; i++) {

            //Recorro los numeros
            for (int j = 0; j < cartasPorPalo; j++) {

                if (incluye_8_9) {
                    this.cartas.push(new CartaEspaniola(j + 1, palos[i]));
                } else {
                    //Las posiciones del 8 y del 9 son el 7 y el 8 (emepzamos en 8)
                    if (j >= 7) {
                        //Solo para la sota, caballo y rey
                         this.cartas.push(new CartaEspaniola(j + 3, palos[i]));
                    } else {
                        //Para los casos de 1 a 7
                         this.cartas.push(new CartaEspaniola(j + 1, palos[i]));
                    }
                }

            }

        }

    }

}
