package ejercicio_ed_19_discoduroderoer;

import baraja.BarajaEspañola;
import baraja.BarajaFrancesa;
import baraja.Carta;

public class Ejercicio_ED_19_Discoduroderoer {

    public static void main(String[] args) {

        //Creamos la baraja
        BarajaEspañola b = new BarajaEspañola(false);

        //Mostramos las cartas disponibles (40)
        System.out.println("Hay " + b.cartasDisponible() + " cartas disponibles");

        //Saco una carta
        b.siguienteCarta();

        //Saco 5 cartas
        b.darCartas(5);

        //Mostramos las cartas disponibles (34)
        System.out.println("Hay " + b.cartasDisponible() + " cartas disponibles");

        System.out.println("Cartas sacadas de momento");

        b.cartasMonton();

        //Barajamos de nuevo
        b.barajar();

        //Saco 5 cartas
        Carta[] c = b.darCartas(5);

        System.out.println("Cartas sacadas despues de barajar ");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
        
        System.out.println("--------");
        
        b.mostrarBaraja();
        
    }

}
