package modelo;

import conexiondb.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cliente {

    private String NIF;
    private String NyA;
    private String direccion;
    private String poblacion;

    public Cliente() {
    }

    public Cliente(String NIF, String NyA, String direccion, String poblacion) {
        this.NIF = NIF;
        this.NyA = NyA;
        this.direccion = direccion;
        this.poblacion = poblacion;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNyA() {
        return NyA;
    }

    public void setNyA(String NyA) {
        this.NyA = NyA;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return NyA;
    }

    public ObservableList<Cliente> getClientes() {
        ObservableList<Cliente> obs = FXCollections.observableArrayList();
        try {

            // Abro la conexion
            ConexionMySQL conexion = new ConexionMySQL("localhost", "alquiler_vehiculos", "root", "");

            // realizo la consulta
            conexion.ejecutarConsulta("select * from clientes");

            ResultSet rs = conexion.getResultSet();

            // recorro los resultados
            while (rs.next()) {

                // Cojo los datos
                String NIF = rs.getString("NIF");
                String nombre = rs.getString("NyA");
                String direccion = rs.getString("direcion");
                String poblacion = rs.getString("poblacion");

                // Creo el cliente
                Cliente c = new Cliente(NIF, nombre, direccion, poblacion);

                obs.add(c);

            }

            // Cierro la conexion
            conexion.cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

}
