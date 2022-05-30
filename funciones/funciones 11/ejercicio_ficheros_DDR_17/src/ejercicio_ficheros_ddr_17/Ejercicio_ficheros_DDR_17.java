package ejercicio_ficheros_ddr_17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_ficheros_DDR_17 {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        Agenda agendaTelefonica = new Agenda(3);
        String nombre;
        int telefono;

        Contacto c;

        while (!salir) {

            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Contactos disponibles");
            System.out.println("7. Agenda llena");
            System.out.println("8. Exportar a XML");
            System.out.println("9. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        //Pido valores
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        System.out.println("Escribe un telefono");
                        telefono = sn.nextInt();

                        //Creo el contacto
                        c = new Contacto(nombre, telefono);

                        agendaTelefonica.aniadirContacto(c);

                        break;
                    case 2:

                        agendaTelefonica.listarContactos();

                        break;
                    case 3:

                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        agendaTelefonica.buscarPorNombre(nombre);

                        break;
                    case 4:

                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        //Creo el contacto auxiliar
                        c = new Contacto(nombre, 0);

                        if (agendaTelefonica.existeContacto(c)) {
                            System.out.println("Existe contacto");
                        } else {
                            System.out.println("No existe contacto");
                        }

                        break;
                    case 5:

                        //pido el nombre
                        System.out.println("Escribe un nombre");
                        nombre = sn.next();

                        //Creo el contacto auxiliar
                        c = new Contacto(nombre, 0);

                        agendaTelefonica.eliminarContacto(c);

                        break;
                    case 6:

                        System.out.println("Hay " + agendaTelefonica.huecosLibre() + " contactos libre");

                        break;
                    case 7:

                        //como devuelve un booleano, lo meto en un if
                        if (agendaTelefonica.agendaLlena()) {
                            System.out.println("La agenda esta llena");
                        } else {
                            System.out.println("Aun puedes meter contactoss");
                        }

                        break;
                    case 8:
                        agendaTelefonica.exportarContactos();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }

        }

    }

}
