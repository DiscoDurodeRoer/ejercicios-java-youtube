/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraja;

import enumerados.ColoresBarajaUno;
import enumerados.EfectosBarajaUno;

/**
 *
 * @author Fernando
 */
public class CartaUno extends Carta<ColoresBarajaUno> {

    private EfectosBarajaUno efecto;

    public CartaUno(int numero, ColoresBarajaUno color) {
        super(numero, color);
    }

    public CartaUno() {
    }

    public CartaUno(ColoresBarajaUno color, EfectosBarajaUno efecto) {
        super(-1, color);
        this.efecto = efecto;
    }

    public EfectosBarajaUno getEfecto() {
        return efecto;
    }

    public boolean isEspecial() {
        return this.efecto != null;
    }

    @Override
    public String toString() {

        String estado = "";

        if (this.isEspecial()) {
            switch (this.efecto) {
                case MASDOS:
                    estado = "+2 " + palo;
                    break;
                case MASCUATRO:
                    estado = "+4";
                    break;
                case SALTO:
                    estado = "Salto turno " + palo;
                    break;
                case REVERSO:
                    estado = "reverso " + palo;
                    break;
                case CAMBIOCOLOR:
                    
                    estado = "Cambio color";
                    break;
            }
        } else {
            estado = numero + " " + palo;
        }

        return estado;
    }

}
