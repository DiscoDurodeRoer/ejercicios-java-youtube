/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraja;

import enumerados.ColoresBarajaUno;
import enumerados.EfectosBarajaUno;

public class BarajaUno extends Baraja<CartaUno> {

    private boolean sentido; // true = sentido agujas del reloj, false = sentido contrario agujas del reloj
    private CartaUno ultimaCarta;
    private ColoresBarajaUno colorActual;
    
    public BarajaUno() {
        this.numCartas = 108;
        this.cartasPorPalo = 13;
        this.sentido = true;
        
        this.crearBaraja();
        super.barajar();
        
        this.ultimaCarta = super.siguienteCarta(true);
        this.actualizarColor();
    }

    @Override
    public void crearBaraja() {

        ColoresBarajaUno[] colores = ColoresBarajaUno.values();

        for (ColoresBarajaUno color : colores) {

            if (color != ColoresBarajaUno.NEGRO) {

                for (int i = 0; i < this.cartasPorPalo; i++) {
                    if (i > 9) {
                        switch (i) {
                            case 10:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.MASDOS));
                                break;
                            case 11:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.SALTO));
                                break;
                            case 12:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.REVERSO));
                                break;
                        }
                    } else {
                        this.cartas.push(new CartaUno(i, color));
                    }
                }

                for (int i = 1; i < this.cartasPorPalo; i++) {
                    if (i > 9) {
                        switch (i) {
                            case 10:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.MASDOS));
                                break;
                            case 11:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.SALTO));
                                break;
                            case 12:
                                this.cartas.push(new CartaUno(color, EfectosBarajaUno.REVERSO));
                                break;
                        }
                    } else {
                        this.cartas.push(new CartaUno(i, color));
                    }
                }

            } else {

                for (int i = 0; i < 4; i++) {
                    this.cartas.push(new CartaUno(color, EfectosBarajaUno.MASCUATRO));
                    this.cartas.push(new CartaUno(color, EfectosBarajaUno.CAMBIOCOLOR));
                }

            }

        }

    }

    public boolean isSentido() {
        return sentido;
    }

    public void cambiarSentido(){
        this.sentido = !this.sentido;
    }

    public CartaUno getUltimaCarta() {
        return ultimaCarta;
    }

    public void setUltimaCarta(CartaUno ultimaCarta) {
        this.ultimaCarta = ultimaCarta;
    }

    public ColoresBarajaUno getColorActual() {
        return colorActual;
    }

    public void setColorActual(ColoresBarajaUno colorActual) {
        this.colorActual = colorActual;
    }
    
    public void actualizarColor(){
        this.colorActual = this.ultimaCarta.getPalo();
    }
    

}
