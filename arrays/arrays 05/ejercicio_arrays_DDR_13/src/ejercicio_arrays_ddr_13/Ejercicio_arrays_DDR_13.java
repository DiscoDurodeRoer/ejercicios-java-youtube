package ejercicio_arrays_ddr_13;

import java.util.Scanner;

/**
 * Juego del ahorcado
 *
 * @author DiscoDurodeRoer
 */
public class Ejercicio_arrays_DDR_13 {

    public static void main(String[] args) {

        //Scanner para las palabras
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        //Constantes
        final int PUNTUACION_SUPERAR = 3;
        final int NUMERO_ERRORES = 6;
        final int NUMERO_JUGADORES = 2;
        final int NUMERO_CARACTERES = 26;

        //Variables y arrays usados
        String jugadores[] = new String[NUMERO_JUGADORES];
        int puntos[] = new int[NUMERO_JUGADORES];
        int turno = 0, numeroErrores = NUMERO_ERRORES; //Controla a quien le toca
        String palabraElegida, pista, palabraAdivinar, palabraUsuario;
        char abecedario[] = generaCaracteres(); // Genera in array con los caracteres de A-Z, no se incluye la ñ
        boolean caracteresInsertados[] = new boolean[NUMERO_CARACTERES];

        //Pedimos el nombre de los jugadores
        for (int i = 0; i < jugadores.length; i++) {
            jugadores[i] = pedirString(sn, "Escribe el nombre del jugador " + (i + 1));
        }

        while (!fin(puntos, PUNTUACION_SUPERAR)) {

            //Validamos la palabra y la pista
            palabraElegida = validar(sn,
                    "Escribe una palabra con solo caracteres y sin espacios, Jugador: " + jugadores[turno],
                    "Error, escribe palabra con solo caracteres y sin espacios y de longitud de mas de 1");

            pista = validar(sn,
                    "Escribe una pista con solo caracteres y sin espacios, Jugador: " + jugadores[turno],
                    "Error, escribe pista con solo caracteres y sin espacios");

            espacios(30); //añadimos espacios para que el otro jugador no vea
            palabraAdivinar = rellenaGuiones(palabraElegida); //rellenamos la palabraAdivinar con guiones

            //ahora toca adivinar la palabra
            while (!palabraCorrecta(palabraElegida, palabraAdivinar) && numeroErrores > 0) {

                //mostamos la pista, la palabra y los repetidos
                System.out.println("Pista: " + pista);
                mostrarPalabra(palabraAdivinar);
                mostrarRepetidos(abecedario, caracteresInsertados);

                //el jugador escribe
                palabraUsuario = pedirString(sn, "Escribe una letra, si escribes una palabra sera como escribir la solucion, Jugador: " + jugadores[turno]).toLowerCase();

                //si la longitud es de una, podemos decir que quiere poner una letra
                if (palabraUsuario.length() == 1) {

                    if (Character.isAlphabetic(palabraUsuario.charAt(0))) {

                        if (caracterIntroducido(caracteresInsertados, palabraUsuario.charAt(0))) {
                            System.out.println("El caracter ya esta puesto, elige otro");
                        } else if (numRemplazos(palabraElegida, palabraUsuario.charAt(0)) > 0) {
                            palabraAdivinar = remplazar(palabraElegida, palabraAdivinar, palabraUsuario.charAt(0));
                        } else {
                            numeroErrores--;
                            System.out.println("Error, te quedan " + numeroErrores + " errores");
                        }
                        actualizarInsertados(caracteresInsertados, palabraUsuario.charAt(0));
                    }

                    //si es mas de una letra, el jugador quiere intentar adivinarlo
                } else if (!palabraCorrecta(palabraElegida, palabraUsuario)) {
                    numeroErrores--;
                    System.out.println("Error, no es la palabra correcta");
                } else {
                    //Si entramos aqui, significa que la plabra es correcta, necesitamos asignar la palabra del usuario a la de adivinar
                    //Otra solucion podria ser poner en la condicion otra llamada al metodo palabraCorrecta
                    palabraAdivinar = palabraUsuario;
                    System.out.println("Correcto, has acertado");
                }
            }

            //Si el numero de errores es mayor que cero, significa que hemos acertado la palabra
            if (numeroErrores > 0) {
                //Suma puntos el resto de jugadores y se cambia el turno
                sumaPuntosOtroJugador(puntos, 1, turno);
                turno = cambiaTurno(turno, jugadores.length - 1);
            } else {
                //el usuario que puso la palabra suma un punto y continua escribiendo la palabra
                puntos[turno]++;
            }

            //Mostramos las puntuaciones de los jugadores
            mostrarPuntuaciones(jugadores, puntos);

            //reiniciamos los errores y los caracteres insertados
            numeroErrores = NUMERO_ERRORES;
            actualizarInsertados(caracteresInsertados);

        }

        //Indicamos el ganador
        mostrarGanador(puntos, jugadores, PUNTUACION_SUPERAR);

        System.out.println("Fin");

    }

    /**
     * Pide y devuelve un String
     *
     * @param sn
     * @param mensaje
     * @return valor String
     */
    public static String pedirString(Scanner sn, String mensaje) {

        System.out.println(mensaje);
        return sn.next();

    }

    /**
     * Genera un array de caracteres
     *
     * @return Array con caracteres de A-Z
     */
    public static char[] generaCaracteres() {

        char[] caracteres = new char[26];
        for (int i = 0, j = 97; i < caracteres.length; i++, j++) {
            caracteres[i] = (char) j;
        }

        return caracteres;

    }

    /**
     * Comprueba si lo insertado es correcto, sin numeros, espacios, caracteres
     * no legibles, etc.
     *
     * @param cadena
     * @return true si todo esta bien, false si hay un caracter inválido
     */
    public static boolean comprobarAlfabeticos(String cadena) {

        char caracter;

        for (int i = 0; i < cadena.length(); i++) {
            caracter = cadena.charAt(i);
            if (!Character.isAlphabetic(caracter)) {
                return true;
            }
        }

        return false;

    }

    /**
     * Indica si el juego termina
     *
     * @param puntos
     * @param puntuacionSuperar
     * @return true, fin del juego, false, el juego continua
     */
    public static boolean fin(int puntos[], int puntuacionSuperar) {

        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] >= puntuacionSuperar) {
                return true;
            }
        }

        return false;

    }

    /**
     * Valida si una palabra insertada es correcta, sino lo es vuelve a pedirlo
     *
     * @param sn
     * @param mensaje
     * @param mensajeError
     * @return true, la palabra es válida, false, no lo es
     */
    public static String validar(Scanner sn, String mensaje, String mensajeError) {

        String palabra;
        boolean correcto;
        do {
            correcto=true;
            palabra = pedirString(sn, mensaje).toLowerCase();
            
            if (comprobarAlfabeticos(palabra) || palabra.length() <= 1) {
                System.out.println(mensajeError);
                correcto=false;
            }

        } while (!correcto);

        return palabra;
    }

    /**
     * Inserta el número de espacios pasados por parámetro
     *
     * @param numSaltos
     */
    public static void espacios(int numSaltos) {

        for (int i = 0; i < numSaltos; i++) {
            System.out.println("");
        }
    }

    /**
     * Crea una nueva cadena con guiones para el juego
     *
     * @param cadena
     * @return String con guiones
     */
    public static String rellenaGuiones(String cadena) {

        String palabra = "";
        for (int i = 0; i < cadena.length(); i++) {
            palabra += "_"; //le pongo el guion
        }

        return palabra;
    }

    /**
     * Muestro una palabra con espacios entre sus caracteres
     *
     * @param cadena
     */
    public static void mostrarPalabra(String cadena) {

        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i) + " ");
        }

        System.out.println("");

    }

    /**
     * Indica si la palabra insertada por el usuario es correcta
     *
     * @param palabraOriginal
     * @param palabraUsuario
     * @return true, correcto, false, incorrecto
     */
    public static boolean palabraCorrecta(String palabraOriginal, String palabraUsuario) {

        return palabraOriginal.equals(palabraUsuario);

    }

    /**
     * Muestra las palabras que hemos repetido durante el turno de un jugador
     *
     * @param abecedario
     * @param insertados
     */
    public static void mostrarRepetidos(char[] abecedario, boolean insertados[]) {

        System.out.print("Repetidas: ");
        for (int i = 0; i < insertados.length; i++) {
            //Si esta insertado, se muestra el caracter
            if (insertados[i]) {
                System.out.print(abecedario[i]);
            }

        }
        System.out.println("");
    }

    /**
     * Suma puntos a todos los jugadores excepto a uno
     *
     * @param puntos
     * @param puntosSuperar
     * @param pos_excluida
     */
    public static void sumaPuntosOtroJugador(int[] puntos, int puntosSuperar, int pos_excluida) {

        for (int i = 0; i < puntos.length; i++) {
            if (i != pos_excluida) {
                puntos[i]++;
            }

        }
    }

    /**
     * Indica el numero de remplazos a realizar
     *
     * @param cadenaOriginal
     * @param caracter
     * @return numero de remplazos a realizar
     */
    public static int numRemplazos(String cadenaOriginal, char caracter) {

        int remplazos = 0;
        char caracterCadena;
        for (int i = 0; i < cadenaOriginal.length(); i++) {
            caracterCadena = cadenaOriginal.charAt(i);
            if (caracterCadena == caracter) {
                remplazos++;
            }
        }
        return remplazos;

    }

    /**
     * Remplaza los guiones con el caracter dado
     *
     * @param cadenaOriginal
     * @param cadenaRemplazar
     * @param caracter
     * @return cadena con guiones remplazados
     */
    public static String remplazar(String cadenaOriginal, String cadenaRemplazar, char caracter) {

        String cadenaRemplazo = "";
        char caracterCadena;
        for (int i = 0; i < cadenaOriginal.length(); i++) {
            caracterCadena = cadenaOriginal.charAt(i);

            if (caracterCadena == caracter) {
                cadenaRemplazo += caracter;
            } else {
                cadenaRemplazo += cadenaRemplazar.charAt(i);
            }
        }
        return cadenaRemplazo;

    }

    /**
     *
     * @param insertados
     * @param caracter
     * @return
     */
    public static boolean caracterIntroducido(boolean[] insertados, char caracter) {
        return insertados[caracter - 'a'];
    }

    public static void actualizarInsertados(boolean[] insertados, char caracter) {

        insertados[caracter - 'a'] = true;

    }

    /**
     * Cambia el turno del jugador, si llega al final, empieza de cero
     *
     * @param turnoActual
     * @param limite
     * @return turno del jugador actual
     */
    public static int cambiaTurno(int turnoActual, int limite) {

        if (turnoActual == limite) {
            return 0;
        } else {
            return ++turnoActual; //importante que sea pre-incremento
        }

    }

    /**
     * Muestra las puntuaciones de los jugadores
     *
     * @param jugadores
     * @param puntos
     */
    public static void mostrarPuntuaciones(String[] jugadores, int[] puntos) {

        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i] + ": " + puntos[i] + " puntos");
        }
        System.out.println("");
    }

    /**
     * Muestra al ganador del juego
     *
     * @param puntos
     * @param jugadores
     * @param puntosSuperar
     */
    public static void mostrarGanador(int[] puntos, String jugadores[], int puntosSuperar) {

        int indiceGanador = 0;
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i] >= puntosSuperar) {
                indiceGanador = i; //obtenemos el indice
                break;
            }
        }

        System.out.println("El ganador es " + jugadores[indiceGanador]);

    }

    /**
     * Reiniciamos los caracteres insertados
     *
     * @param insertados
     */
    public static void actualizarInsertados(boolean insertados[]) {

        for (int i = 0; i < insertados.length; i++) {
            insertados[i] = false;
        }

    }

}
