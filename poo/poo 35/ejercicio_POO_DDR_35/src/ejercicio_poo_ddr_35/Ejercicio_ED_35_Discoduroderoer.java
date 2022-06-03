package ejercicio_poo_ddr_35;

public class Ejercicio_ED_35_Discoduroderoer {

    public static void main(String[] args) {

        Leer lectura = new Leer();

        Jugador[] jugadores = {
            new Jugador("J1"),
            new Jugador("J2"),
            new Jugador("J3"),
            new Jugador("J4")
        };

        JuegoUNO juego = new JuegoUNO(jugadores, 100);

        while (!juego.finJuego()) {

            System.out.println("Ronda: " + juego.getRonda());

            while (!juego.finPartida()) {

                juego.mostrarTurnoActual();
                juego.mostrarSentidoActual();

                juego.cartaCentro();

                juego.mostrarCartasJugadorActual();
                int indiceCarta = lectura.pedirIntRango(-1, juego.numCartasJugadorActual(),
                        "Elige una carta de la mano, -1 para robar",
                        "Solo numeros entre -1 y " + juego.numCartasJugadorActual());

                if (indiceCarta == -1) {
                    System.out.println("Se haelegido robar carta");
                    juego.robarCarta();
                    juego.cambioTurno();
                } else {
                    if (!juego.cartaCompatible(indiceCarta)) {
                        System.out.println("No puedes echar esa carta");
                    } else {
                        juego.cambioTurno();
                    }
                }

            }
            juego.siguienteRonda();

            System.out.println("Ranking");
            juego.ranking();
        }
        
        Jugador ganador = juego.ganandorJuego();
        System.out.println("El ganador del juego ha sido " + ganador.getNombre());

    }

}
