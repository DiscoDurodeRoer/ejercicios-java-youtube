package ejercicio_bd_ddr_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio_BD_DDR_2 {

    public static void main(String[] args) {
        try {

            //Creo la conexión
            ConexionMySQL conexion = new ConexionMySQL("localhost", "empleadoss_departamentoss", "root", "root");

            //Ejecuto la consulta
            conexion.ejecutarConsulta("select * from empleados");

            //Recojo el ResultSet
            ResultSet rs = conexion.getResultSet();

            //Muestro la consulta
            while (rs.next()) {
                System.out.println(rs.getString("nomEmp"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
