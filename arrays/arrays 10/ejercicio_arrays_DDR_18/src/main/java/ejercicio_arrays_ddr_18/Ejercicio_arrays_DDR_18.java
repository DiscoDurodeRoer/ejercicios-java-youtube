package ejercicio_arrays_ddr_18;

public class Ejercicio_arrays_DDR_18 {

    public static void main(String[] args) {

        // numero de casillas totales (0 a 63)
        final int NUM_CASILLAS = 64;

        // Casillas especiales
        int[] origenCasillasEspeciales = {7, 11, 31, 30, 40, 43, 50, 59};
        int[] destinoCasillasEspeciales = {38, 37, 46, 2, 21, 60, 5, 42};

        // Variables necesarias
        int[] jugadores = {0, 0};
        boolean bloqueado[] = {false, false};
        int turno = 0, dado, tiradasConsecutivas = 0, casillaSuperior;
        boolean casillaEspecial;
        int casillaLimite = NUM_CASILLAS - 1;

        // Seguimos hasta que uno de los jugadores llegue a la casilla limite
        while (jugadores[0] != casillaLimite && jugadores[1] != casillaLimite) {

            // tiro el dado
            dado = generaNumeroAleatorio(1, 6);
            System.out.println("El jugador " + (turno + 1) + " ha sacado un " + dado);

            // Si saca un 6, añadimos en uno al contador de tiradas (sino esta bloqueado)
            if (dado == 6) {
                // Si el jugador esta bloqueado, se desbloquea
                if (bloqueado[turno]) {
                    bloqueado[turno] = false;
                    tiradasConsecutivas = 0;
                    System.out.println("El jugador " + (turno + 1) + " se ha desbloqueado");
                } else {
                    tiradasConsecutivas++;
                }
            } else {
                tiradasConsecutivas = 0;
            }

            // Si llega a 3, bloqueamos al jugador
            if (tiradasConsecutivas == 3) {
                bloqueado[turno] = true;
                jugadores[turno] = 0;
                System.out.println("El jugador " + (turno + 1) + " se ha bloqueado");
            } else {

                // Movimiento rebotado
                if (jugadores[turno] + dado > NUM_CASILLAS - 1) {
                    casillaSuperior = jugadores[turno] + dado;
                    jugadores[turno] = casillaLimite - (casillaSuperior - casillaLimite);
                } else {
                    jugadores[turno] += dado;
                }

                // Comprobamos si la casilla donde esta el jugador es una casilla especial
                casillaEspecial = false;
                for (int i = 0; i < origenCasillasEspeciales.length && !casillaEspecial; i++) {
                    if (jugadores[turno] == origenCasillasEspeciales[i]) {
                        // Si el origen es menor que el destino es una escalera, sino una serpiente
                        if (origenCasillasEspeciales[i] < destinoCasillasEspeciales[i]) {
                            System.out.println("El jugador " + (turno + 1) + " ha subido una escalera");
                        } else {
                            System.out.println("El jugador " + (turno + 1) + " ha bajado una serpiente");
                        }
                        // Transportamos al jugador
                        jugadores[turno] = destinoCasillasEspeciales[i];
                        casillaEspecial = true;
                    }
                }

                System.out.println("El jugador " + (turno + 1) + " esta en la casilla " + (jugadores[turno] + 1));

            }

            // Si saco un 6, no cambio de turno
            if (dado != 6) {
                // Cambio de turno
                if (turno == 0) {
                    turno = 1;
                } else {
                    turno = 0;
                }
            }

        }

        // Comprobación del ganador
        if (jugadores[0] == casillaLimite) {
            System.out.println("El jugador 1 ha ganado");
        } else {
            System.out.println("El jugador 2 ha ganado");
        }

    }

    //Genera un numero aleatorio entre el minimo y el maximo, includo el maximo y el minimo
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }

}
