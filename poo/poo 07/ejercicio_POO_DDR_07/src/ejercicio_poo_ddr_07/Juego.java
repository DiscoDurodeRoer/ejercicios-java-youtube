package ejercicio_poo_ddr_07;

/**
 * @author Discoduroderoer
 */
public class Juego {

    //atributos
    private Jugador[] jugadores;
    private Revolver revolver;

    //Constructor
    public Juego(int numJugadores) {

        jugadores = new Jugador[comprobarJugadores(numJugadores)];

        crearJugadores();

        revolver = new Revolver();

    }

    //Comprueba que el numero de jugadores esta en el rango correcto
    private int comprobarJugadores(int numJugadores) {

        //Sino esta en el rango correcto se pone a 6
        if (!(numJugadores >= 1 && numJugadores <= 6)) {
            numJugadores = 6;
        }

        return numJugadores;
    }

    //Crea los jugadores
    private void crearJugadores() {
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = new Jugador(i + 1);
        }
    }

    //indica si el juego acaba o no
    public boolean finJuego() {

        for (int i = 0; i < jugadores.length; i++) {
            if (!jugadores[i].isVivo()) {
                //Acabo el juego
                return true;
            }
        }
        return false; //No termina el juego
    }

    //Realiza una ronda (si muere algun jugador todos participan igualmente)
    public void ronda() {

        for (int i = 0; i < jugadores.length; i++) {
            //El jugador se dispara
            jugadores[i].disparar(revolver);
        }

    }
    
    //Realiza una ronda (si muere algun jugador, los siguientes no participan)
    public void rondaV2() {

        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i].disparar(revolver);
            
            //Si muere, terminamos
            if(!jugadores[i].isVivo()){
                return;
            }
        }

    }

}
