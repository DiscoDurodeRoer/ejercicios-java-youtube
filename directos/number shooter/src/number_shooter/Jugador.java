/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_shooter;

public class Jugador {

    private int puntos;

    public Jugador() {
        this.puntos = 0;
    }

    public void aumentarPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

}
