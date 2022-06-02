package ejercicio_bd_ddr_2;

public class ConexionOracle extends ConexionDB {

    public ConexionOracle(String host, String puerto, String SID, String usuario, String password) {
        super("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@" + host + ":" + puerto + ":" + SID, usuario, password);
    }

    public ConexionOracle(String host, String SID, String usuario, String password) {
        super("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@" + host + ":1521:" + SID, usuario, password);
    }

}
