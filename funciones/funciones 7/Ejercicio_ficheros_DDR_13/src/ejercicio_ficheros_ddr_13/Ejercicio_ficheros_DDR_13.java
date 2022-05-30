package ejercicio_ficheros_ddr_13;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_ficheros_DDR_13 {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");

        boolean salir = false;
        int opcion;

        File fichero = new File("clientes.dat");

        String DNI, nombre, telefono;

        Cliente c;

        while (!salir) {

            System.out.println("1. Crear Fichero");
            System.out.println("2. Añadir cliente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Borrar fichero");
            System.out.println("5. Salir de la aplicacion");

            try {

                System.out.println("Escribe una opcion");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        //Si el fichero existe, lo indico
                        if (fichero.exists()) {
                            System.out.println("El fichero ya esta creado");
                        } else {
                            //sino existe lo creo, si hay algun problema avisa al usuario
                            if (fichero.createNewFile()) {
                                System.out.println("Se ha creado el fichero correctamente");
                            } else {
                                System.out.println("Ha habido un error al crear el fichero");
                            }
                        }

                        break;
                    case 2:

                        //Si existe el fichero, pide datos
                        if (fichero.exists()) {
                            System.out.println("Introduce un DNI");
                            DNI = sn.next();

                            //Si el DNI no es valido, saltara la excepcion y volvera al inicio
                            validarDNI(DNI);

                            System.out.println("Introduce el nombre");
                            nombre = sn.next();

                            System.out.println("Introduce un telefono");
                            telefono = sn.next();

                            c = new Cliente(DNI, nombre, telefono);

                            ObjectOutputStream oos;

                            //Si el fichero esta vacio, escribiremos con Objectoutputstream
                            //Sino con MiObjectOutputStream
                            if (fichero.length() == 0) {
                                oos = new ObjectOutputStream(new FileOutputStream(fichero));
                            } else {
                                //el true es importante
                                oos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                            }

                            //lo inserta en el fichero
                            oos.writeObject(c);

                            System.out.println("Se ha añadido correctamente");

                        } else {
                            System.out.println("Debes crear el fichero");
                        }

                        break;
                    case 3:

                        //si existe el fichero lo lee
                        if (fichero.exists()) {

                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

                            //Saldrá cuando no haya mas datos que leer, EOFException
                            while (true) {

                                //leo el objeto
                                c = (Cliente) ois.readObject();

                                //lo muestro
                                System.out.println(c.toString());

                            }
                        } else {
                            System.out.println("Debes crear el fichero");
                        }

                    case 4:

                        if (fichero.exists()) {
                            fichero.delete();  //borrar
                            System.out.println("El fichero se ha borrado");
                        } else {
                            System.out.println("No se puede borrar ya que no existe el fichero");
                        }

                        break;
                    case 5:
                        salir = true;
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sn.next();
            } catch (EOFException ex) { //Excepcion para ObjectInputStream
                System.out.println("No hay mas clientes");
            } catch (DNIException | IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    /**
     * Valida un DNI Comprueba si tiene entre 8 y 9 caracteres Comprueba si la
     * parte numerica es correcta Comprueba si la letra es correcta Comprueba si
     * el numero y la letra es corrrecta
     *
     * @param DNI
     * @throws DNIException
     */
    public static void validarDNI(String DNI) throws DNIException {

        //Comprobamos la longitud del dni
        if (!(DNI.length() >= 8 && DNI.length() <= 9)) {
            throw new DNIException(DNIException.LONGITUD_NO_CORRECTA);
        }

        //saco la parte numerica
        String parte_numerica = DNI.substring(0, DNI.length() - 1);

        //Aqui guardare el dni
        int numeroDNI = 0;

        try {
            //Lo transformo en un numero
            //Puede saltar la excepcion
            numeroDNI = Integer.parseInt(parte_numerica);
        } catch (NumberFormatException e) {
            throw new DNIException(DNIException.PARTE_NUMERICA_NO_CORRECTA);
        }

        //
        char letra = DNI.substring(DNI.length() - 1, DNI.length()).toUpperCase().charAt(0);

        if (!(letra >= 'A' && letra <= 'Z')) {
            throw new DNIException(DNIException.PARTE_LETRA_NO_CORRECTA);
        }

        //Ya hemos validado el formato
        final int DIVISOR = 23;

        char letrasNIF[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        int resto = numeroDNI % DIVISOR;

        String nuevoDNI = numeroDNI + "" + letrasNIF[resto];

        if (DNI.startsWith("0")) {
            nuevoDNI = "0" + nuevoDNI;
        }

        if (!(nuevoDNI.equals(DNI))) {
            throw new DNIException(DNIException.FORMATO_NO_CORRECTO);
        }

    }

}
