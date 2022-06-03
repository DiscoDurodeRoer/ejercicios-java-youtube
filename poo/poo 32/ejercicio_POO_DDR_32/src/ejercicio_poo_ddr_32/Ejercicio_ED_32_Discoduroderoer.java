package ejercicio_poo_ddr_32;


public class Ejercicio_ED_32_Discoduroderoer {

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
