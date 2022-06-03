package modelo;

import conexiondb.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Servicio {

    private int idServicio;
    private String matriculaVehiculo;
    private String NIFCliente;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private int total;

    // Atributos adicionales para la tabla
    private String marca;
    private int precio;

    public Servicio() {
    }

    public Servicio(int idServicio, String matriculaVehiculo, String NIFCliente, LocalDate fechaAlquiler, LocalDate fechaEntrega, int total) {
        this.idServicio = idServicio;
        this.matriculaVehiculo = matriculaVehiculo;
        this.NIFCliente = NIFCliente;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
    }

    public Servicio(String matriculaVehiculo, String NIFCliente, LocalDate fechaAlquiler, LocalDate fechaEntrega, int total) {
        this.matriculaVehiculo = matriculaVehiculo;
        this.NIFCliente = NIFCliente;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
    }

    // Usado para la tabla
    public Servicio(String matriculaVehiculo, LocalDate fechaAlquiler, LocalDate fechaEntrega, int total, String marca, int precio) {
        this.matriculaVehiculo = matriculaVehiculo;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaEntrega = fechaEntrega;
        this.total = total;
        this.marca = marca;
        this.precio = precio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getMatriculaVehiculo() {
        return matriculaVehiculo;
    }

    public void setMatriculaVehiculo(String matriculaVehiculo) {
        this.matriculaVehiculo = matriculaVehiculo;
    }

    public String getNIFCliente() {
        return NIFCliente;
    }

    public void setNIFCliente(String NIFCliente) {
        this.NIFCliente = NIFCliente;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean insertarServicio() {

        try {

            // Abro la conexion
            ConexionMySQL conexion = new ConexionMySQL("localhost", "alquiler_vehiculos", "root", "");

            // Sentencia para introducir un servicio
            String SQL = "INSERT INTO servicios (matricula_vehiculo, nif_cliente, fecha_alquiler, fecha_entrega, total) "
                    + "values("
                    + "'" + this.getMatriculaVehiculo() + "', "
                    + "'" + this.getNIFCliente() + "', "
                    + "'" + this.fechaAlquiler.toString() + "', "
                    + "'" + this.fechaEntrega.toString() + "',"
                    + total
                    + " )";

            // Devuelvo el numero de filas afectadas
            int filas = conexion.ejecutarInstruccion(SQL);

            conexion.cerrarConexion();

            // Si deuvelve mas de 0, es que hemos insertado registros
            if (filas > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public ObservableList<Servicio> getServicios() {
        //Sobrecarga
        return this.getServicios(null, null, null);
    }

    public ObservableList<Servicio> getServicios(LocalDate fechaAlquiler, LocalDate fechaEntrega, String NIF) {
        ObservableList<Servicio> obs = FXCollections.observableArrayList();
        try {

            // Abro la conexion
            ConexionMySQL conexion = new ConexionMySQL("localhost", "alquiler_vehiculos", "root", "");

            String SQL = "select v.matricula, v.marca, v.precio, s.fecha_alquiler, s.fecha_entrega, s.total "
                    + "from servicios s, vehiculos v, clientes c "
                    + "where s.matricula_vehiculo = v.matricula and s.nif_cliente = c.nif ";

            // completo la consulta segun lo que venga
            if (NIF != null) {
                SQL += "and c.nif='" + NIF + "'";
            }

            if (fechaAlquiler != null && fechaEntrega != null) {
                SQL += "and s.fecha_alquiler >= '" + fechaAlquiler.toString() + "' and s.fecha_entrega <= '" + fechaEntrega.toString() + "' ";
            } else if (fechaAlquiler != null) {
                SQL += "and s.fecha_alquiler >= '" + fechaAlquiler.toString() + "' ";
            } else if (fechaEntrega != null) {
                SQL += "s.fecha_entrega <= '" + fechaEntrega.toString() + "' ";
            }

            // realizo la consulta
            conexion.ejecutarConsulta(SQL);

            ResultSet rs = conexion.getResultSet();

            // recorro los resultados
            while (rs.next()) {

                // Cojo los datos
                String matricula = rs.getString("matricula");
                String marca = rs.getString("marca");
                int precio = rs.getInt("precio");
                LocalDate fechaAlquilerCampo = rs.getDate("fecha_alquiler").toLocalDate();
                LocalDate fechaEntregaCampo = rs.getDate("fecha_entrega").toLocalDate();
                int total = rs.getInt("total");

                // Creo el servicio
                Servicio s = new Servicio(matricula, fechaAlquilerCampo, fechaEntregaCampo, total, marca, precio);

                obs.add(s);

            }

            // Cierro la conexion
            conexion.cerrarConexion();

        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obs;
    }

}
