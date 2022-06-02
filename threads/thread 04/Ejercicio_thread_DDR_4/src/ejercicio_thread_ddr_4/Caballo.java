package ejercicio_thread_ddr_4;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Caballo extends Observable implements Runnable {

    private String nombre;

    public Caballo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {

        int porcentaje = 0;
        int numAleatorio;
        try {
            while (porcentaje < 100) {
                numAleatorio = generaNumeroAleatorio(1, 15);
                System.out.println("Caballo " + nombre + " ha aumentado en " + numAleatorio);
                porcentaje += numAleatorio;

                this.setChanged();
                this.notifyObservers(porcentaje);
                this.clearChanged();

                Thread.sleep(1000);

            }
        } catch (InterruptedException ex) {
            System.out.println("Hilo interrumpido");
        }

    }

    public static int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;
    }

}
