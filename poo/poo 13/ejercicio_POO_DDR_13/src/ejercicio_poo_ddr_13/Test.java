package ejercicio_poo_ddr_13;

import Leer.Leer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import listaDinamica.ListaDinamica;

public class Test {

    //atributos
    private ListaDinamica<Pregunta> preguntas;
    private int puntosTotales;
    private int preguntaActual;

    //Constructor
    public Test() {
        preguntas = new ListaDinamica<>();
        puntosTotales = 0;
        preguntaActual = 0;
    }

    //Getter
    public ListaDinamica<Pregunta> getPreguntas() {
        return preguntas;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public int getPreguntaActual() {
        return preguntaActual;
    }

    public Pregunta siguientePregunta() {

        //cojo la siguiente pregunta
        Pregunta p = preguntas.get(preguntaActual);

        //si la pregunta es distinto de null, paso la siguiente
        if (p != null) {
            preguntaActual++;
        }

        return p;

    }

    public void reiniciarTest() {
        preguntaActual = 0;
        puntosTotales = 0;
    }

    public void realizarTest() {

        //si estan vacias las preguntas, no hacemos nada
        if (preguntas.isEmpty()) {
            System.out.println("No hay preguntas");
        } else {

            //Creamos un objeto leer
            Leer teclado = new Leer();

            int i = 0, respuesta;
            Pregunta p;

            //recorremos las preguntas
            while (i < preguntas.size()) {

                //Cojemos una pregunta
                p = preguntas.get(i);
                //La mostramos
                p.mostrarPregunta();

                //Pedimos una respuesta
                respuesta = teclado.pedirIntRango(1, p.getRespuestas().size(), "Introduce la respuesta");

                //Comprobamos si es correcta o no
                if (p.comprobarRespuesta(respuesta)) {
                    System.out.println("Has acertado");
                    puntosTotales += p.getPuntos();
                } else {
                    System.out.println("No has acertado");
                }

                i++;
            }

        }

        //muestro los puntos
        System.out.println("Has obtenido " + puntosTotales + " puntos");

    }

    public void cargarFichero(String fichero) throws FileNotFoundException, IOException {

        //Creo el buffer
        BufferedReader br = new BufferedReader(new FileReader(fichero));

        //variables necesarias
        String linea;
        Pregunta p;
        ListaDinamica<Respuesta> respuestas = new ListaDinamica<>();
        String texto_pregunta = "";
        int puntosPregunta = 0, opcioncorrecta = 0;
        boolean pregunta = false, respuesta = false, puntos = false;

        //leo el fichero
        while ((linea = br.readLine()) != null) {

            try {

                //si empieza por ;P; es una pregunta
                if (linea.startsWith(";P;")) {
                    texto_pregunta = linea.substring(3);
                    pregunta = true; //marco que ya tengo la pregunta
                    //si tengo la pregunta y empieza por ;R; cojo la respuesta correcta
                } else if (pregunta && linea.startsWith(";R;")) {
                    opcioncorrecta = Integer.parseInt(linea.substring(3).trim());
                    respuesta = true; //marco que ya tengo la respuesta
                    //Si la respuesta esta marcada, cojo los puntos
                } else if (respuesta) {
                    puntosPregunta = Integer.parseInt(linea.trim());
                    puntos = true; //marco los puntos
                    //Si tengo la pregunta marcada, cojo la respuesta
                    //Lo pongo el ultimo en caso de que no haya nada mas
                } else if (pregunta) {
                    respuestas.addLast(new Respuesta(linea));

                    //Si tiene mas de 4 respuestas, lanzo excepcion
                    if (respuestas.size() > 4) {
                        throw new Exception();
                    }
                }

                //Si tenemos marcado la pregunta, la respuesta, los puntos y hay entre 2 y 4 opciones
                if (pregunta && respuesta && puntos && (respuestas.size() >= 2 && respuestas.size() <= 4)) {

                    //Marcamos la respuesta correcta como la correcta
                    respuestas.get(opcioncorrecta - 1).setCorrecta(true);

                    //creo la pregunta
                    p = new Pregunta(texto_pregunta, respuestas, puntosPregunta);

                    //añado la pregunta
                    preguntas.addLast(p);

                    //reincio
                    pregunta = false;
                    respuesta = false;
                    puntos = false;
                    respuestas = new ListaDinamica<>();

                }

            } catch (Exception ex) {
                //reincio
                pregunta = false;
                respuesta = false;
                puntos = false;
                respuestas = new ListaDinamica<>();
            }

        }

        br.close();

    }

}
