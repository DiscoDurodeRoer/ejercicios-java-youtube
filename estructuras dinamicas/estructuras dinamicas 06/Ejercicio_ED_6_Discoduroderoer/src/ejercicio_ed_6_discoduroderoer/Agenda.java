package ejercicio_ed_6_discoduroderoer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;
import lista_dinamica.ListaDinamica;

/**
 * Lleva la gestion de una agenda
 *
 * @author Discoduroderoer
 */
public class Agenda {

    //Atributos
    private ListaDinamica<Contacto> contactos;

    //Constructor adaptado
    public Agenda() {
        this.contactos = new ListaDinamica<>();
    }

    //Metodos
    /**
     * Añade un contacto a la agenda
     *
     * @param c
     */
    public void aniadirContacto(Contacto c) {

        //Sino existe se añade a la lista
        if (!contactos.exists(c)) {
            contactos.addLast(c);
            System.out.println("Se ha añadido");
        } else {
            System.out.println("El contacto con ese nombre ya existe");
        }

    }

    /**
     * Indica si existe un contacto
     *
     * @param c
     * @return
     */
    public boolean existeContacto(Contacto c) {

        return contactos.exists(c);

    }

    /**
     * Lista los contactos de la agenda
     */
    public void listarContactos() {

        if (contactos.isEmpty()) {
            System.out.println("No hay contactos que mostrar");
        } else {
            //mostramos la lista
            System.out.println(contactos.toString());
        }

    }

    /**
     * Busca un contacto por su nombre
     *
     * @param nombre
     */
    public void buscarPorNombre(String nombre) {

        Contacto aux = new Contacto(nombre, 0);

        //Busco la posicion del contacto creado
        int posicion = contactos.indexOf(aux);

        //Si devuelve -1, significa que no existe
        if (posicion == -1) {
            System.out.println("No se ha encontrado el contacto");
        } else {
            //Cojo el contacto de la posicion
            aux = contactos.get(posicion);
            System.out.println("Su telefono es " + aux.getTelefono()); //muestro el telefono
        }

    }

    /**
     * Elimina el contacto de la agenda
     *
     * @param c
     */
    public void eliminarContacto(Contacto c) {

        //Busco la posicion del contacto creado
        int posicion = contactos.indexOf(c);

        //Si devuelve -1, significa que no existe
        if (posicion == -1) {
            System.out.println("No se ha eliminado el contacto porque no existe");
        } else {
            //Elimino la posicion indicada
            contactos.remove(posicion);
            System.out.println("Se ha eliminado el contacto");
        }

    }

   
    /**
     * Exporta los contactos actuales al fichero contacto.age
     */
    public void exportarContactos() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("contactos.age"))) {;

            int i = 0;
            Contacto aux;
            //Recorremos los contactos
            while (!contactos.isEmpty()) {

                aux = contactos.get(i);

                //Escribimos el objeto
                oos.writeObject(aux);

                i++;
            }

            System.out.println("Se ha escrito con exito");

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Importa los contactos de un fichero .age
     *
     * @param fichero
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void importarContactos(String fichero) throws IOException, ClassNotFoundException {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {

            Contacto aux;
            //Recorro el fichero
            //Cuando no haya mas datos, salta la exception
            while (true) {
                //Cojo el fichero
                aux = (Contacto) ois.readObject();

                //añado el contacto
                aniadirContacto(aux);
            }

        } catch (EOFException ex) {
        }

    }

}
