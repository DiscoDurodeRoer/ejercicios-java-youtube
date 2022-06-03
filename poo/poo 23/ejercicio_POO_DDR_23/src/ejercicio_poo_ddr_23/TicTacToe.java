package ejercicio_poo_ddr_23;

public class TicTacToe {

    //Reprentaciones de los jugadores y del simbolo vacio
    private final char J1 = 'X';
    private final char J2 = 'O';
    private final char VACIO = '-';

    //turno actual
    //true = J1, false = J2
    private boolean turno;

    //tablero donde vamos a jugar
    private char tablero[][];

    public TicTacToe() {
        this.turno = true;
        this.tablero = new char[3][3];
        this.inicializarTablero();
    }

    /**
     * Inicializa el tablero con el simbolo VACIO
     */
    private void inicializarTablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = VACIO;
            }
        }

    }

    /**
     * Indica si es el fin de la partida, acaba cuando hay un ganador o el tablero esta lleno
     * @return fin de partida
     */
    public boolean finPartida() {

        if (tableroLleno()
                || coincidenciaLinea() != VACIO
                || coincidenciaColumna() != VACIO
                || coincidenciaDiagonal() != VACIO) {
            return true;
        }

        return false;
    }

    /**
     * Indica si el tablero esta llena cuando el simbolo por defecto aparezca, no
     * esta llena
     *
     * @return talero vacio o no
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == VACIO) {
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * Indica si hay un ganador en una linea
     * @return Simbolo del ganador, VACIO sino hay ganador
     */
    private char coincidenciaLinea() {

        char simbolo;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = tablero[i][0];
            if (simbolo != VACIO) {
                for (int j = 1; j < tablero[0].length; j++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return VACIO;

    }

    /**
     * Indica si hay un ganador en una columna
     * @return Simbolo del ganador, VACIO sino hay ganador
     */
    private char coincidenciaColumna() {

        char simbolo;
        boolean coincidencia;

        for (int j = 0; j < tablero.length; j++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = tablero[0][j];
            if (simbolo != VACIO) {
                for (int i = 1; i < tablero[0].length; i++) {
                    //sino coincide ya no habra ganadro en esta fila
                    if (simbolo != tablero[i][j]) {
                        coincidencia = false;
                    }
                }

                //Si no se mete en el if, devuelvo el simbolo ganador
                if (coincidencia) {
                    return simbolo;
                }

            }

        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return VACIO;

    }

    /**
     * Comprueba las diagonales
     * @return Simbolo del ganador, VACIO sino hay ganador
     */
    private char coincidenciaDiagonal() {

        char simbolo;
        boolean coincidencia = true;

        //Diagonal principal
        simbolo = tablero[0][0];
        if (simbolo != VACIO) {
            for (int i = 1; i < tablero.length; i++) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != tablero[i][i]) {
                    coincidencia = false;
                }
            }

            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }

        }

        coincidencia = true;

        //Diagonal inversa
        simbolo = tablero[0][2];
        if (simbolo != VACIO) {
            for (int i = 1, j = 1; i < tablero.length; i++, j--) {
                //sino coincide ya no habra ganadro en esta fila
                if (simbolo != tablero[i][j]) {
                    coincidencia = false;
                }
            }

            //Si no se mete en el if, devuelvo el simbolo ganador
            if (coincidencia) {
                return simbolo;
            }
        }

        //Si no hay ganador, devuelvo el simbolo por defecto
        return VACIO;

    }

    /**
     * Muestra el ganador de la partida
     */
    public void mostrarGanador() {

        char simbolo = coincidenciaLinea();

        if (simbolo != VACIO) {

            ganador(simbolo, 1);

            return;

        }

        simbolo = coincidenciaColumna();

        if (simbolo != VACIO) {

            ganador(simbolo, 2);

            return;

        }

        simbolo = coincidenciaDiagonal();

        if (simbolo != VACIO) {

            ganador(simbolo, 3);

            return;

        }

        System.out.println("Hay empate");

    }

    /**
     * Funcion auxiliar de la anterior funcion
     *
     * @param simbolo
     * @param tipo
     */
    private void ganador(char simbolo, int tipo) {

        switch (tipo) {
            case 1:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por linea");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por linea");
                }

                break;
            case 2:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por columna");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por columna");
                }
                break;
            case 3:
                if (simbolo == J1) {
                    System.out.println("Ha ganado el Jugador 1 por diagonal");
                } else {
                    System.out.println("Ha ganado el Jugador 2 por diagonal");
                }
                break;
        }

    }

    /**
     * Insertamos en una posicion de una matriz un simbolo en concreto
     *
     * @param fila
     * @param columna
     */
    public void insertarEn(int fila, int columna) {
        if (turno) {
            this.tablero[fila][columna] = J1;
        } else {
            this.tablero[fila][columna] = J2;
        }
    }

    /**
     * Muestra la matriz
     *
     */
    public void mostrarTablero() {

        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero[0].length; j++) {
                System.out.print(this.tablero[i][j] + " ");
            }
            System.out.println("");
        }

    }

    /**
     * Mostramos el turno actual
     */
    public void mostrarTurnoActual() {

        if (turno) {
            System.out.println("Le toca al jugador 1");
        } else {
            System.out.println("Le toca al jugador 2");
        }

    }

    public void cambiaTurno() {
        this.turno = !this.turno;
    }

    /**
     * Validamos la posicion que nos insertan
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean validarPosicion(int fila, int columna) {

        if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
            return true;
        }
        return false;

    }

    /**
     * Indicamos si en una posicion hay una marca
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean hayValorPosicion(int fila, int columna) {
        if (this.tablero[fila][columna] != VACIO) {
            return true;
        }

        return false;
    }

}
