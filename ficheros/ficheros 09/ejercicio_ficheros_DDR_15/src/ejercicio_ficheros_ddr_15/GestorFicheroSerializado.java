package ejercicio_ficheros_ddr_15;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorFicheroSerializado<T> {

    private File fichero;
    private ArrayList<T> datos;

    public GestorFicheroSerializado(String fichero) {
        this.fichero = new File(fichero);
        this.datos = new ArrayList();
        obtenerDatos();
    }

    public GestorFicheroSerializado(File fichero) {
        this.fichero = fichero;
        this.datos = new ArrayList();
        obtenerDatos();
    }

    /**
     * Obtiene todos los datos de un fichero serializado y los mete en una lista
     */
    public void obtenerDatos() {

        if (fichero.exists()) {

            T elemento;

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

                while (true) {
                    elemento = (T) ois.readObject();
                    datos.add(elemento);
                }

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (EOFException ex) {
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    /**
     * Guarda el elemento T en el fichero y en la lista
     *
     * @param elemento
     */
    public void guardarDato(T elemento) {

        if (fichero.exists() && fichero.length() > 0) {

            // Uso MiObjectOutputStream para evitar problemas de cabecera
            try (MiObjectOutputStream oos = new MiObjectOutputStream(new FileOutputStream(fichero, true))) {

                oos.writeObject(elemento);
                datos.add(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {

            // Uso ObjectOutputStream para crear la cabecera
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {

                oos.writeObject(elemento);
                datos.add(elemento);

            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    /**
     * Obtengo los datos
     *
     * @return
     */
    public ArrayList<T> getDatos() {
        return datos;
    }

}
