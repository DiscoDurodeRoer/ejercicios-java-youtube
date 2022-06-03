/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_interfaces_graficas_ddr_17;

public enum Simbolo {
    X('X'),
    O('O'),
    VACIO('-');

    private char simbolo;

    private Simbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

}
