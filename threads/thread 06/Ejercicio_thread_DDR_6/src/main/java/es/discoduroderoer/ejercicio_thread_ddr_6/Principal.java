package es.discoduroderoer.ejercicio_thread_ddr_6;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        try {
            boolean sincronizado = true;

            Counter c = new Counter(sincronizado);

            HiloContador h1 = new HiloContador(1, 5, c);
            HiloContador h2 = new HiloContador(2, 10, c);

            h1.start();
            h2.start();

            h1.join();
            h2.join();
            System.out.println("Fin Programa");
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
