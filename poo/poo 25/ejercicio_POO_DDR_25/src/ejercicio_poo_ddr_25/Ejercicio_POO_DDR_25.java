package ejercicio_poo_ddr_25;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_POO_DDR_25 {

    public static void main(String[] args) {

        try {
            WorldWarBot ww = new WorldWarBot("participantes.txt");

            while (!ww.hayGanador()) {
                ww.combate();
            }

            ww.mostrarGanador();
            
        } catch (Exception ex) {
            Logger.getLogger(Ejercicio_POO_DDR_25.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
