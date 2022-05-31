package ejercicio_recursividad_ddr_22;

import java.util.ArrayList;

public class Ejercicio_recursividad_DDR_22 {

    public static void main(String[] args) {

        //Generacion del tablero
        Casilla[][] tablero = {
            {
                new Casilla(0, 0, new boolean[]{false, true, true, false}, false),
                new Casilla(0, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(0, 2, new boolean[]{false, false, true, true}, false),
                new Casilla(0, 3, new boolean[]{false, false, true, false}, false)
            },
            {
                new Casilla(1, 0, new boolean[]{true, true, true, false}, false),
                new Casilla(1, 1, new boolean[]{false, false, false, true}, false),
                new Casilla(1, 2, new boolean[]{false, true, true, false}, false),
                new Casilla(1, 3, new boolean[]{true, false, false, true}, false)
            },
            {
                new Casilla(2, 0, new boolean[]{true, true, true, false}, false),
                new Casilla(2, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(2, 2, new boolean[]{true, true, true, true}, false),
                new Casilla(2, 3, new boolean[]{false, false, false, true}, false)
            },
            {
                new Casilla(3, 0, new boolean[]{true, true, false, false}, false),
                new Casilla(3, 1, new boolean[]{false, true, false, true}, false),
                new Casilla(3, 2, new boolean[]{true, true, false, true}, false),
                new Casilla(3, 3, new boolean[]{false, false, false, true}, true)
            }

        };

        //Posible camino que puede haber
        ArrayList<Casilla> camino = new ArrayList<>();

        //Creo el laberinto
        Laberinto laberinto = new Laberinto(tablero);
        camino.add(tablero[0][0]);

        rellenarCaminos(laberinto, tablero[0][0], camino);

        //Muestro las soluciones
        laberinto.mostrarCaminos();

    }

    public static void rellenarCaminos(Laberinto laberinto, Casilla casillaActual, ArrayList<Casilla> camino) {

        //si la casilla donde estoy en la final, acabo
        if (casillaActual.isFin()) {

            //añado un clon del camino
            laberinto.añadirCamino((ArrayList<Casilla>) camino.clone());

        } else {

            //Movimientos disponibles
            int[][] movimientos = {
                {-1, 0}, //arriba
                {0, 1}, // derecha
                {1, 0}, // abajo
                {0, -1} // izquierda
            };

            int posXnueva, posYnueva;
            Casilla aux;

            //Pruebo los posibles caminos
            for (int i = 0; i < movimientos.length; i++) {

                posXnueva = casillaActual.getPosX() + movimientos[i][0];
                posYnueva = casillaActual.getPosY() + movimientos[i][1];
                aux = laberinto.getCasillaAt(posXnueva, posYnueva);

                switch (i) {
                    case 0: //arriba
                        if (laberinto.arribaDisponible(casillaActual, aux)) {
                            //la añado al camino
                            camino.add(aux);
                            //la marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            //la desmarco como visitada
                            casillaActual.setVisitado(false);
                            // la elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 1: //derecha
                        if (laberinto.derechaDisponible(casillaActual, aux)) {
                            //la añado al camino
                            camino.add(aux);
                            //la marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            //la desmarco como visitada
                            casillaActual.setVisitado(false);
                            // la elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 2://abajo
                        if (laberinto.abajoDisponible(casillaActual, aux)) {
                            //la añado al camino
                            camino.add(aux);
                            //la marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            //la desmarco como visitada
                            casillaActual.setVisitado(false);
                            // la elimino del camino
                            camino.remove(aux);
                        }
                        break;
                    case 3: //izquierda
                        if (laberinto.izquierdaDisponible(casillaActual, aux)) {
                            //la añado al camino
                            camino.add(aux);
                            //la marco como visitada
                            casillaActual.setVisitado(true);
                            rellenarCaminos(laberinto, aux, camino);
                            //la desmarco como visitada
                            casillaActual.setVisitado(false);
                            // la elimino del camino
                            camino.remove(aux);
                        }
                        break;
                }

            }

        }

    }

    public static void rellenarCaminosV2(Laberinto laberinto, Casilla casillaActual, ArrayList<Casilla> camino) {

        if (casillaActual.isFin()) {

            laberinto.añadirCamino((ArrayList<Casilla>) camino.clone());

        } else {

            int[][] movimientos = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
            };

            int posXnueva, posYnueva;
            Casilla aux;
            boolean accesible = false;

            for (int i = 0; i < movimientos.length; i++) {

                posXnueva = casillaActual.getPosX() + movimientos[i][0];
                posYnueva = casillaActual.getPosY() + movimientos[i][1];
                aux = laberinto.getCasillaAt(posXnueva, posYnueva);

                switch (i) {
                    case 0:
                        accesible = laberinto.arribaDisponible(casillaActual, aux);
                        break;
                    case 1:
                        accesible = laberinto.derechaDisponible(casillaActual, aux);
                        break;
                    case 2:
                        accesible = laberinto.abajoDisponible(casillaActual, aux);
                        break;
                    case 3:
                        accesible = laberinto.izquierdaDisponible(casillaActual, aux);
                        break;
                }

                if (accesible) {
                    camino.add(aux);
                    casillaActual.setVisitado(true);
                    rellenarCaminos(laberinto, aux, camino);
                    casillaActual.setVisitado(false);
                    camino.remove(aux);
                }

            }

        }

    }

}
