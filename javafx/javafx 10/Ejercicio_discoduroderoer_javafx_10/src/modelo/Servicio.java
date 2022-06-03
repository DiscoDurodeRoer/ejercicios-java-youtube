package modelo;

import conexiondb.ConexionMySQL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servicio {

    private int idServicio;
    private String matriculaVehiculo;
    private String NIFCliente;
    private LocalDate fechaAlquiler;
    private LocalDate fechaEntrega;
    private int total;

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

}
