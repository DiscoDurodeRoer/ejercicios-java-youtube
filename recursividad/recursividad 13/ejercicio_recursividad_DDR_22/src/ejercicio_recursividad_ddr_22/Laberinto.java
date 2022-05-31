package ejercicio_recursividad_ddr_22;

import java.util.ArrayList;

public class Laberinto {

    private Casilla[][] tablero;

    private ArrayList<ArrayList<Casilla>> caminos;

    public Laberinto(Casilla[][] tablero) {
        this.tablero = tablero;
        caminos = new ArrayList<>();
    }

    public boolean arribaDisponible(Casilla casillaActual, Casilla casillaDestino) {

        if (casillaDestino != null && !casillaDestino.isVisitado()) {
            return casillaActual.arribaDisponible();
        }

        return false;
    }

    public boolean derechaDisponible(Casilla casillaActual, Casilla casillaDestino) {

        if (casillaDestino != null && !casillaDestino.isVisitado()) {
            return casillaActual.derechaDisponible();
        }

        return false;
    }

    public boolean abajoDisponible(Casilla casillaActual, Casilla casillaDestino) {

        if (casillaDestino != null && !casillaDestino.isVisitado()) {
            return casillaActual.abajoDisponible();
        }

        return false;
    }

    public boolean izquierdaDisponible(Casilla casillaActual, Casilla casillaDestino) {

        if (casillaDestino != null && !casillaDestino.isVisitado()) {
            return casillaActual.izquierdaDisponible();
        }

        return false;
    }

    public Casilla getCasillaAt(int x, int y) {
        if (dentroDelLimite(x, y)) {
            return tablero[x][y];
        }
        return null;
    }

    public boolean dentroDelLimite(int x, int y) {

        return (x >= 0 && x < tablero.length) && (y >= 0 && y < tablero[0].length);

    }

    public void añadirCamino(ArrayList<Casilla> camino) {
        if (camino != null && !camino.isEmpty()) {
            caminos.add(camino);
        }
    }

    public void mostrarCaminos() {

        int i = 1;
        for (ArrayList<Casilla> camino : caminos) {
            System.out.println("Camino: " + i);
            for (Casilla c : camino) {
                System.out.println(c);
            }
            i++;
        }

    }

}
