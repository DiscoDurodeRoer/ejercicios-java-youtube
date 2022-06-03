package ejercicio_poo_ddr_04;

import java.util.Scanner;

/**
 * Clase ejecutable
 * @author DiscoDurodeRoer
 */
public class Ejercicio_POO_DDR_04 {

    public static void main(String[] args) {

        //Creo la pelicula
        Pelicula pelicula = new Pelicula("Mi vida", 90, 16, "DDR");
        
        // Pido datos (esto no se mostro en el video por falta de tiempo)
        // No valida nada al respecto de tamaños (siguiente version)
        Scanner sn = new Scanner(System.in);
        
        System.out.println("Introduce el numero de filas");
        int filas=sn.nextInt();
        
        System.out.println("Intrdouce el numero de columnas");
        int columnas=sn.nextInt();
        
        System.out.println("Introduce el precio de la entrada de cine");
        double precio=sn.nextDouble();
        
        //Creo el cine, necesito la pelicula para ello
        Cine cine = new Cine(filas, columnas, precio, pelicula);

        //Numero de espectadores que seran creados
        System.out.println("Introduce el numero de espectadores a crear");
        int numEspectadores = sn.nextInt();

        //Variables y objetos usados
        Espectador e;
        int fila;
        char letra;

        System.out.println("Espectadores generados: ");
        //Termino cuando no queden espectadores o no haya mas sitio en el cine
        for (int i = 0; i < numEspectadores && cine.haySitio(); i++) {

            //Generamos un espectador
            e = new Espectador(
                    Metodos.nombres[Metodos.generaNumeroEnteroAleatorio(0, Metodos.nombres.length - 1)], //Nombre al azar
                    Metodos.generaNumeroEnteroAleatorio(10, 30), //Generamos una edad entre 10 y 30
                    Metodos.generaNumeroEnteroAleatorio(1, 10)); //Generamos el dinero entre 1 y 10 euros

            //Mostramos la informacion del espectador
            System.out.println(e);
            
            //Generamos una fila y letra
            //Si esta libre continua sino busca de nuevo
            do {

                fila = Metodos.generaNumeroEnteroAleatorio(0, cine.getFilas() - 1);
                letra = (char) Metodos.generaNumeroEnteroAleatorio('A', 'A' + (cine.getColumnas()-1));

            } while (cine.haySitioButaca(fila, letra));

            //Si el espectador cumple con las condiciones
            if (cine.sePuedeSentar(e)) {
                e.pagar(cine.getPrecio()); //El espectador paga el precio de la entrada
                cine.sentar(fila, letra, e); //El espectador se sienta
            }

        }

        System.out.println("");
        cine.mostrar(); //Mostramos la información del cine, tambien se puede usar un toString
        
        System.out.println("Fin");

    }

}
