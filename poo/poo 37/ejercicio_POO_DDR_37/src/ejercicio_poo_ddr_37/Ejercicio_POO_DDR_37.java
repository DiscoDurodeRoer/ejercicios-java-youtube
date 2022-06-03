package ejercicio_poo_ddr_37;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_POO_DDR_37 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        jugar();
    }

    /**
     * Metodo donde empezaremos a jugar
     */
    public static void jugar() {

        TicTacToe juego = new TicTacToe();

        int fila, columna;
        boolean posValida, correcto;

        //No salimos hasta que uno gane o no haya mas posibilidades
        while (!juego.finPartida()) {

            do {

                //mostramos el jugador al que le toca
                juego.mostrarTurnoActual();

                //muestro el tablero
                juego.mostrarTablero();

                correcto = false;
                fila = pedirInteger("Dame la fila");
                columna = pedirInteger("Dame la columna");

                //Validamos la posicion
                posValida = juego.validarPosicion(fila, columna);

                //Si es valido, comprobamos que no haya ninguna marca
                if (posValida) {

                    //Si no hay marca, significa que es correcto
                    if (!juego.hayValorPosicion(fila, columna)) {
                        correcto = true;
                    } else {
                        System.out.println("Ya hay una marca en esa posicion");
                    }
                } else {
                    System.out.println("La posicion no es valida");
                }

                //Mientras no sea correcto, no salgo
            } while (!correcto);

            //depende del turno, inserta un simbolo u otro
            juego.insertarEn(fila, columna);

            //cambio de turno
            juego.cambiarTurno();
        }

        //Muestra el tablero
        juego.mostrarTablero();

        //Mostramos el ganador
        Simbolo ganador = juego.ganador();
        if(ganador == null){
            System.out.println("Empate");
        }else if(ganador == Simbolo.X){
            System.out.println("J1 es el ganador");
        }else {
            System.out.println("J2 es el ganador");
        }
    }

    /**
     * Pedimos un numero y lo devolvemos
     *
     * @param mensaje
     * @return
     */
    public static int pedirInteger(String mensaje) {

        boolean correcto;
        int numero = 0;
        do {
            try {

                System.out.println(mensaje);
                numero = teclado.nextInt();
                correcto = true;
            } catch (InputMismatchException e) {
                teclado.next();
                correcto=false;
            }
        } while (!correcto);

        return numero;

    }

}
