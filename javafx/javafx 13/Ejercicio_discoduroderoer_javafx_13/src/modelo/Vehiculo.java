package modelo;

import conexiondb.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vehiculo {

    private String matricula;
    private String descripcion;
    private String marca;
    private int km;
    private int precio;
    private short ocupado;

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String descripcion, String marca, int km, int precio, short ocupado) {
        this.matricula = matricula;
        this.descripcion = descripcion;
        this.marca = marca;
        this.km = km;
        this.precio = precio;
        this.ocupado = ocupado;
    }

    public short getOcupado() {
        return ocupado;
    }

    public void setOcupado(short ocupado) {
        this.ocupado = ocupado;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return matricula;
    }

    public ObservableList<Vehiculo> getVehiculos() {
        ObservableList<Vehiculo> obs = FXCollections.observableArrayList();
        try {

            // Abro la conexion
            ConexionMySQL conexion = new ConexionMySQL("localhost", "alquiler_vehiculos", "root", "");

            // Ejcuto la consulta
            conexion.ejecutarConsulta("select * from vehiculos where ocupado = 0");

            ResultSet rs = conexion.getResultSet();

            // Recorro los datos
            while (rs.next()) {

                // Obtengo los datos
                String matricula = rs.getString("matricula");
                String descripcion = rs.getString("descripcion");
                String marca = rs.getString("marca");
                int km = rs.getInt("kilometros");
                int precio = rs.getInt("precio");
                short ocupado = rs.getShort("ocupado");

                // Creo el vehiculo
                Vehiculo v = new Vehiculo(matricula, descripcion, marca, km, precio, ocupado);

                obs.add(v);

            }

            conexion.cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

    public boolean actualizarOcupado() throws SQLException {

        // Abro la conexion
        ConexionMySQL conexion = new ConexionMySQL("localhost", "alquiler_vehiculos", "root", "");

        // Ejcuto la instruccion
        int filas = conexion.ejecutarInstruccion("update vehiculos set ocupado = " + ocupado + " "
                                                    + "where matricula = '" + matricula + "'");

        // Cierro la conexion
        conexion.cerrarConexion();

        // Si hay una o mas filas significa que se hizo correctamente.
        if (filas > 0) {
            return true;
        } else {
            return false;
        }
    }

}
