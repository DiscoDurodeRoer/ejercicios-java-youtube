package ejercicio_poo_ddr_37;

public class TicTacToe {

    private Simbolo[][] tablero;

    private boolean turno; // true = J1, false =J2
    
    public TicTacToe() {
        this.tablero = new Simbolo[3][3];
        this.turno = true;
        this.inicializartablero();
    }
    
    
    public Simbolo ganador() {

        Simbolo simbolo = coincidenciaLinea();

        if (simbolo != Simbolo.VACIO) {
            return simbolo;
        }

        simbolo = coincidenciaColumna();

        if (simbolo != Simbolo.VACIO) {
            return simbolo;
        }

        simbolo = coincidenciaDiagonal();

        if (simbolo != Simbolo.VACIO) {
            return simbolo;
        }

        return null;
    }
    
    /**
     * Insertamos en una posicion de una matriz un simbolo en concreto
     *
     * @param fila
     * @param columna
     */
    public void insertarEn(int fila, int columna) {
        if(turno){
            tablero[fila][columna] = Simbolo.X;
        }else{
            tablero[fila][columna] = Simbolo.O;
        }
    }

    /**
     * Mostramos el turno actual
     */
    public void mostrarTurnoActual() {

        if (this.turno) {
            System.out.println("Le toca al jugador 1");
        } else {
            System.out.println("Le toca al jugador 2");
        }

    }
    
    public void cambiarTurno(){
        this.turno = !this.turno;
    }

    /**
     * Rellena la matriz con un simbolo
     */
    public void inicializartablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = Simbolo.VACIO;
            }
        }

    }

    /**
     * Validamos la posicion que nos insertan
     *
     * @param tablero
     * @param fila
     * @param columna
     * @return
     */
    public boolean validarPosicion(int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length;
    }

    /**
     * Indicamos si en una posicion hay una marca
     *
     * @param fila
     * @param columna
     * @return
     */
    public boolean hayValorPosicion(int fila, int columna) {
        if (tablero[fila][columna] != Simbolo.VACIO) {
            return true;
        }

        return false;
    }

    /**
     * Muestra la matriz
     */
    public void mostrarTablero() {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j].getSimbolo() + " ");
            }
            System.out.println("");
        }

    }

    /**
     * Indica si la matriz esta llena cuando el simbolo por defecto aparezca, no
     * esta llena
     *
     * @param matriz
     * @param simboloDef
     * @return
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == Simbolo.VACIO) {
                    return false;
                }
            }
        }

        return true;

    }

    /**
     * La partida acaba cuando la matriz esta llena o hay un ganador
     * @return
     */
    public boolean finPartida() {

        if (tableroLleno()
                || coincidenciaLinea() != Simbolo.VACIO
                || coincidenciaColumna() != Simbolo.VACIO
                || coincidenciaDiagonal() != Simbolo.VACIO) {
            return true;
        }

        return false;
    }

    /**
     * Indica si hay un ganador en una linea
     *
     * @param matriz
     * @param simboloDef
     * @return simbolo ganador, sino lo hay devuelve el de por defecto
     */
    public Simbolo coincidenciaLinea() {

        Simbolo simbolo;
        boolean coincidencia;

        for (int i = 0; i < tablero.length; i++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la fila
            simbolo = tablero[i][0];
            if (simbolo != Simbolo.VACIO) {
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
        return Simbolo.VACIO;

    }

    public Simbolo coincidenciaColumna() {

        Simbolo simbolo;
        boolean coincidencia;

        for (int j = 0; j < tablero.length; j++) {

            //Reiniciamos la coincidencia
            coincidencia = true;
            //Cogemos el simbolo de la columna
            simbolo = tablero[0][j];
            if (simbolo != Simbolo.VACIO) {
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
        return Simbolo.VACIO;

    }

    public Simbolo coincidenciaDiagonal() {

        Simbolo simbolo;
        boolean coincidencia = true;

        //Diagonal principal
        simbolo = tablero[0][0];
        if (simbolo != Simbolo.VACIO) {
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

        //Diagonal inversa
        simbolo = tablero[0][2];
        if (simbolo != Simbolo.VACIO) {
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
        return simbolo.VACIO;

    }

}
