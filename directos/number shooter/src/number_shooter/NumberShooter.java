package number_shooter;

public class NumberShooter {

    private int[][] tablero;
    private Jugador[] jugadores;
    private int limiteFilas;
    private int limiteColumnas;

    public NumberShooter(int filas, int columnas, Jugador[] jugadores) {
        this.jugadores = jugadores;
        tablero = new int[filas][columnas];
        this.limiteFilas = filas;
        this.limiteColumnas = columnas;
        this.rellenarTablero();
    }

    // Filas
    public int getN() {
        return this.tablero.length;
    }

    // Columnas
    public int getM() {
        return this.tablero[0].length;
    }

    private void rellenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = generaNumeroAleatorio(0, 3);
            }
        }
    }

    public void mostrarTablero() {

        for (int i = 0; i < limiteFilas; i++) {
            for (int j = 0; j < limiteColumnas; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public boolean filaTiene0(int fila) {

        for (int i = 0; i < limiteColumnas; i++) {
            if (tablero[fila][i] == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean columnaTiene0(int columna) {
        for (int i = 0; i < limiteFilas; i++) {
            if (tablero[i][columna] == 0) {
                return true;
            }
        }
        return false;
    }

    public int columnaAleatoria() {

        boolean correcto = false;
        int columna = 0;
        while (!correcto) {
            columna = this.generaNumeroAleatorio(0, this.limiteColumnas - 1);

            if (this.columnaTiene0(columna)) {
                correcto = true;
            }

        }

        return columna;
    }

    public int filaAleatoria() {
        boolean correcto = false;
        int fila = 0;
        while (!correcto) {
            fila = this.generaNumeroAleatorio(0, this.limiteFilas - 1);
            if (this.filaTiene0(fila)) {
                correcto = true;
            }
        }

        return fila;
    }

    public void sumaColumna(int columna, boolean jHumano) {

        System.out.println("Columna elegida: " + columna);

        int suma = 0;
        for (int i = 0; i < this.tablero[0].length; i++) {
            suma += tablero[i][columna];
        }

        if (jHumano) {
            System.out.println("El jugador " + ((JugadorHumano) this.jugadores[0]).getNombre() + " obtiene " + suma + " puntos");
            this.jugadores[0].aumentarPuntos(suma);
        } else {
            System.out.println("El jugador maquina obtiene " + suma + " puntos");
            this.jugadores[1].aumentarPuntos(suma);
        }

    }

    public void sumaFila(int fila, boolean jHumano) {

        System.out.println("Fila elegida: " + fila);

        int suma = 0;
        for (int i = 0; i < this.tablero.length; i++) {
            suma += tablero[fila][i];
        }

        if (jHumano) {
            System.out.println("El jugador " + ((JugadorHumano) this.jugadores[0]).getNombre() + " obtiene " + suma + " puntos");
            this.jugadores[0].aumentarPuntos(suma);
        } else {
            System.out.println("El jugador maquina obtiene " + suma + " puntos");
            this.jugadores[1].aumentarPuntos(suma);
        }

    }

    public boolean finJuego() {

        for (int i = 0; i < limiteFilas; i++) {
            for (int j = 0; j < limiteColumnas; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void desplazar(int filaOrigen, int columnaOrigen) {
        this.desplazarFilas(filaOrigen);
        this.desplazarColumnas(columnaOrigen);

        this.limiteFilas = this.limiteFilas - 1;
        this.limiteColumnas = this.limiteColumnas - 1;
    }

    private void desplazarFilas(int filaOrigen) {

        for (int i = filaOrigen; i < tablero.length - 1; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                tablero[i][j] = tablero[i + 1][j];
            }
        }

        // ultima fila
        for (int i = 0; i < tablero[0].length; i++) {
            tablero[tablero.length - 1][i] = 0;
        }

    }

    private void desplazarColumnas(int columnaOrigen) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = columnaOrigen; j < tablero[0].length - 1; j++) {
                tablero[i][j] = tablero[i][j + 1];
            }
        }

        // ultima columna
        for (int i = 0; i < tablero.length; i++) {
            tablero[i][tablero[0].length - 1] = 0;
        }
    }

    public void mostrarPuntuaciones() {
        System.out.println("Puntos jugador 1: " + jugadores[0].getPuntos());
        System.out.println("Puntos jugador 2: " + jugadores[1].getPuntos());
    }

    public void mostrarGanador() {

        this.mostrarPuntuaciones();
        if (jugadores[0].getPuntos() >= jugadores[1].getPuntos()) {
            if (jugadores[0].getPuntos() == jugadores[1].getPuntos()) {
                System.out.println("Empate");
            } else {
                System.out.println("El jugador " + ((JugadorHumano) this.jugadores[0]).getNombre() + " ha ganado");
            }
        } else {
            System.out.println("El jugador maquina ha ganado");
        }

    }

    private int generaNumeroAleatorio(int minimo, int maximo) {
        int num = (int) (Math.random() * (minimo - (maximo + 1)) + (maximo + 1));
        return num;
    }

}
