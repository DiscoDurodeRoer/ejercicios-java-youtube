/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_poo_ddr_31;

import baraja.BarajaUno;
import baraja.Metodos;

public class JuegoUNO {

    private int ronda;
    private BarajaUno baraja;
    private int turno;
    private Jugador[] jugadores;
    private int puntosLimite;

    public JuegoUNO(Jugador[] jugadores, int puntosLimite) {
        this.jugadores = jugadores;
        this.puntosLimite = puntosLimite;
        this.ronda = 1;
        this.turnoInicial();
        this.repartirCartas();
    }

    public void turnoInicial() {
        this.turno = Metodos.generaNumeroEnteroAleatorio(0, this.jugadores.length - 1);
    }

    public void repartirCartas() {
        this.baraja = new BarajaUno();
        for (Jugador j : this.jugadores) {
            j.setCartas(this.baraja.darCartas(7, false));
        }
    }

    public int getRonda() {
        return this.ronda;
    }

    public Jugador jugadorActual() {
        return this.jugadores[this.turno];
    }

    public void mostrarTurnoActual() {
        System.out.println("Es el turno del jugador: " + this.jugadorActual().getNombre());
    }

    public void mostrarCartasJugadorActual() {
        this.jugadorActual().mostrarMano();
    }

    public int numCartasJugadorActual() {
        return this.jugadorActual().numCartas();
    }

    public void mostrarSentidoActual() {
        if (this.baraja.isSentido()) {
            System.out.println("El sentido actual es la de las agujas del reloj");
        } else {
            System.out.println("El sentido actual es el contrario a la de las agujas del reloj");
        }
    }

    public void cambioTurno() {

        if (this.baraja.isSentido() && turno == this.jugadores.length - 1) {
            turno = 0;
        } else if (this.baraja.isSentido() && turno == 0) {
            this.turno = this.jugadores.length - 1;
        } else {
            if(this.baraja.isSentido()){
                turno++;
            }else{
                turno--;
            }
        }

    }

}
