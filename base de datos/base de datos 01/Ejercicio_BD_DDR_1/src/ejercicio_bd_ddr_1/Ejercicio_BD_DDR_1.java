package ejercicio_bd_ddr_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio_BD_DDR_1 {

    public static void main(String[] args) {

        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Clase Connection que nos permite conectarnos a una base de datos
            //dado una cadena de conexion y un usuario y pass
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleadoss_departamentoss", "root", "root");

            //Creamos una sentencia
            Statement sentencia = conexion.createStatement();
            //Resultset guarda los resultados de la consulta
            ResultSet resultSet = sentencia.executeQuery("select * from empleados");

            //muestro la consulta
            while (resultSet.next()) {

                System.out.println(resultSet.getString("nomemp"));

            }

            resultSet.close();
            sentencia.close();

            conexion.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
