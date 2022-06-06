/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_shooter;

public class JugadorMaquina extends Jugador {

    private int modo;

    public static final int MODO_PRINCIPIANTE = 1;
    public static final int MODO_EXPERTO = 2;

    public JugadorMaquina(int modo) {
        this.modo = modo;
    }

}
