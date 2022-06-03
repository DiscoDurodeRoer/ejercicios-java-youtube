/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_poo_ddr_07;

/**
 *
 * @author Trabajo
 */
public class Revolver {

    //Atributos
    private int posicionBalaActual;
    private int posicionBala;

    //Constructor
    public Revolver() {
        posicionBalaActual = Metodos.generaNumeroAleatorio(1, 6);
        posicionBala = Metodos.generaNumeroAleatorio(1, 6);
    }

    //Metodos
    
    //Dispara el revolver
    public boolean disparar() {

        boolean exito = false;

        if (posicionBalaActual == posicionBala) {
            exito = true; //Alguien va a morir...
        }

        siguienteBala();

        return exito;

    }

    //Cambia a la siguiente posicion
    public void siguienteBala() {

        if (posicionBalaActual == 6) {
            posicionBalaActual = 1; //posicion incial
        } else {
            posicionBalaActual++;
        }

    }

    public String toString() {
        return "Posicion Bala Actual: " + posicionBalaActual + ", Posicion bala: " + posicionBala;
    }

}
