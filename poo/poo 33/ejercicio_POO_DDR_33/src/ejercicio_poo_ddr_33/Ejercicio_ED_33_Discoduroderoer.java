package ejercicio_poo_ddr_33;


public class Ejercicio_ED_33_Discoduroderoer {

    public static void main(String[] args) {

        Jugador[] jugadores = {
            new Jugador("J1"),
            new Jugador("J2"),
            new Jugador("J3"),
            new Jugador("J4")
        };
        
        JuegoUNO juego = new JuegoUNO(jugadores, 500);
        
        
    }

}
