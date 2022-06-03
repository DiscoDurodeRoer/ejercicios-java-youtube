package ejercicio_poo_ddr_30;

import baraja.CartaUno;
import java.util.ArrayList;

public class Jugador implements Comparable<Jugador> {

    public String nombre;
    private int puntos;
    private ArrayList<CartaUno> mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.mano = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public ArrayList<CartaUno> getMano() {
        return mano;
    }

    public void aumentarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int numCartas() {
        return this.mano.size();
    }

    public void mostrarMano() {
        System.out.println("Mano de " + this.nombre);
        for (int i = 0; i < this.numCartas(); i++) {
            CartaUno carta = this.mano.get(i);
            System.out.println(i + ". " + carta);
        }
    }

    public CartaUno getCartaAt(int pos) {
        return this.mano.get(pos);
    }

    public void removeCartaAt(int pos) {
        this.mano.remove(pos);
    }

    public boolean sinCartas() {
        return this.mano.isEmpty();
    }

    public void setCartas(ArrayList<CartaUno> cartas) {
        this.mano = cartas;
    }

    public int puntosMano() {
        int puntos = 0;
        for (CartaUno c : this.mano) {
            if (c.isEspecial()) {
                puntos += c.getEfecto().getPuntos();
            } else {
                puntos += c.getNumero();
            }
        }
        return puntos;
    }

    @Override
    public String toString() {
        return nombre + " tiene " + puntos + "puntos";
    }

    @Override
    public int compareTo(Jugador j) {
        if (j.getPuntos() > puntos) {
            return 1;
        } else if (j.getPuntos() == puntos) {
            return 0;
        } else {
            return -1;
        }
    }

}
