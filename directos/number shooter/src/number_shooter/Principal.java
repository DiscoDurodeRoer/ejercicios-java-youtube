/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package number_shooter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        JugadorHumano jh = new JugadorHumano("Lauriel");
        JugadorMaquina jm = null;

        System.out.println("Number Shooter,  ");

        boolean continuar = false;

        while (!continuar) {

            Scanner sn = new Scanner(System.in);
            boolean salir = false;
            int opcion; //Guardaremos la opcion del usuario
            int filas = 0;
            int columnas = 0;

            while (!salir) {

                System.out.println("1. Partida rápida (matriz 10x10) contra principiante.");
                System.out.println("2. Partida estándar (matriz 20x20) contra principiante.");
                System.out.println("3. Partida estándar (matriz 20x20) contra experto.");
                System.out.println("4. Partida larga (matriz 30x30) contra experto");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = sn.nextInt();

                    switch (opcion) {
                        case 1:
                            filas = 10;
                            columnas = 10;
                            jm = new JugadorMaquina(JugadorMaquina.MODO_PRINCIPIANTE);
                            salir = true;
                            break;
                        case 2:
                            filas = 20;
                            columnas = 20;
                            salir = true;
                            jm = new JugadorMaquina(JugadorMaquina.MODO_PRINCIPIANTE);
                            break;
                        case 3:
                            filas = 20;
                            columnas = 20;
                            salir = true;
                            jm = new JugadorMaquina(JugadorMaquina.MODO_EXPERTO);
                            break;
                        case 4:

                            filas = 30;
                            columnas = 30;
                            jm = new JugadorMaquina(JugadorMaquina.MODO_EXPERTO);
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    sn.next();
                }
            }

            Jugador[] jugadores = new Jugador[2];
            jugadores[0] = jh;
            jugadores[1] = jm;

            // Creo el number shooter
            NumberShooter ns = new NumberShooter(filas, columnas, jugadores);

            while (!ns.finJuego()) {

                ns.mostrarPuntuaciones();
                ns.mostrarTablero();

                int filaUsuario = pedirIntRango(0, ns.getN() - 1, "Introduce una fila");

                if (ns.filaTiene0(filaUsuario)) {

                    ns.sumaFila(filaUsuario, true);

                    int columnaJM = ns.columnaAleatoria();
                    ns.sumaColumna(columnaJM, false);

                    ns.desplazar(filaUsuario, columnaJM);

                } else {
                    System.out.println("La fila no tiene un 0");
                }

            }

            ns.mostrarGanador();

            continuar = !pedirBooleanSiNo("¿Quieres jugar otra partida?");
        }

    }

    public static int pedirIntRango(int minimo, int maximo, String mensaje) {
        int num;

        Scanner sc = new Scanner(System.in);
        //En caso de el minimo sea mas grande, se intercambia
        if (minimo > maximo) {
            int aux = minimo;
            minimo = maximo;
            maximo = aux;
        }

        do {
            try {
                System.out.println(mensaje);
                num = sc.nextInt();
            } catch (InputMismatchException ex) {
                // En caso de error, el num se marca como un numero no valido
                num = maximo + 1;
                sc.next();
            }

            if (!(num >= minimo && num <= maximo)) {
                System.out.println("Error, Introduce un numero integer entre " + minimo + " y " + maximo);
            }

        } while (!(num >= minimo && num <= maximo));

        return num;
    }

    public static boolean pedirBooleanSiNo(String mensaje) {

        Scanner sc = new Scanner(System.in);
        boolean correcto, booleano = false;
        String respuesta = "";
        do {
            correcto = true;
            try {
                System.out.println(mensaje);
                respuesta = sc.next();
                respuesta = respuesta.toLowerCase().trim();
            } catch (Exception ex) {
                correcto = false;
                sc.next();
            }

            if (respuesta.equals("si")) {
                booleano = true;
            } else if (respuesta.equals("no")) {
                booleano = false;
            } else {
                correcto = false;
            }

            if (!(respuesta.equals("si")) || respuesta.equals("no")) {
                correcto = false;
            }

            if (!correcto) {
                System.out.println("Error, introduce un valor booleano");
            }

        } while (!correcto);

        return booleano;
    }

}
