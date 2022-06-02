package ejercicio_bd_ddr_4;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Lleva la gestion de una agenda
 *
 * @author Discoduroderoer
 */
public class Agenda {

    //Atributos
    private ArrayList<Contacto> contactos;
    private ConexionOracle conexion;

    //Constructores
    public Agenda() {
        contactos = new ArrayList<>();
        conexion = new ConexionOracle("192.168.100.250", "orcl", "agenda_ddr", "123456");
        obtenerContactos();
    }

    //Metodos
    /**
     * Añade un contacto a la agenda
     *
     * @param c
     * @return
     */
    public boolean aniadirContacto(Contacto c) {

        if (existeContacto(c)) {
            return false;
        } else {

            String sql = "insert into contacto values "
                    + "('" + c.getNombre() + "', " + c.getTelefono() + ")";
            try {
                this.conexion.ejecutarInstruccion(sql);
                contactos.add(c);

                return true;
            } catch (SQLException ex) {
                return false;
            }

        }

    }

    /**
     * Indica si existe un contacto
     *
     * @param c
     * @return
     */
    public boolean existeContacto(Contacto c) {

        return !this.conexion.consultaVacia("select count(*) "
                + "from contacto "
                + "where nombre = '" + c.getNombre() + "'");

    }

    /**
     * Lista los contactos de la agenda
     */
    public void obtenerContactos() {

        String sql = "select * from contacto";

        try {
            this.conexion.ejecutarConsulta(sql);
            ResultSet rs = this.conexion.getResultSet();

            Contacto c;
            while (rs.next()) {
                c = new Contacto(rs.getString("nombre"), rs.getInt("telefono"));
                contactos.add(c);
            }

        } catch (SQLException ex) {
        }

    }

    /**
     * Elimina el contacto de la agenda
     *
     * @param c
     * @return
     */
    public boolean eliminarContacto(Contacto c) {
        try {
            String sql = "delete from contacto "
                    + "where nombre='" + c.getNombre() + "'";

            this.conexion.ejecutarInstruccion(sql);
            contactos.remove(c);
            return true;
        } catch (SQLException ex) {
        }

        return false;

    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

}
