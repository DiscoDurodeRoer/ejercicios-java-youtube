package ejercicio_bd_ddr_2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Discoduroderoer
 */
public abstract class ConexionDB {

    protected Connection conexion;
    protected Statement sentencia;
    protected ResultSet resultSet;

    /**
     * @param claseNombre
     * @param cadenaConexion
     */
    public ConexionDB(String claseNombre, String cadenaConexion) {
        try {
            Class.forName(claseNombre);
            conexion = DriverManager.getConnection(cadenaConexion);
            conexion.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ConexionDB(String claseNombre, String cadenaConexion, String usuario, String pass) {
        try {
            Class.forName(claseNombre);
            conexion = DriverManager.getConnection(cadenaConexion, usuario, pass);
            conexion.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Devuelve la sentencia
     *
     * @return Sentencia de la conexión
     */
    public Statement getSentencia() {
        return sentencia;
    }

    /**
     * Devuelve la conexión
     *
     * @return Conexión
     */
    public Connection getconexion() {
        return conexion;
    }

    /**
     * Devuelve el ResultSet
     *
     * @return ResultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * Finaliza la transaccion, aceptando los cambios en la base de datos
     */
    public void commit() {

        try {
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Vuelve a un estado previo a la base de datos
     */
    public void rollback() {

        try {
            conexion.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra el ResultSet
     */
    public void cerrarResult() {
        try {
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra la sentencia
     */
    public void cerrarSentencia() {
        try {
            sentencia.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cierra la conexion
     */
    public void cerrarConexion() {
        try {
            if (resultSet != null) {
                cerrarResult();
            }
            if (sentencia != null) {
                cerrarSentencia();
            }
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Devuelve al resultset los resultados de una consulta
     *
     * @param consulta Consulta a ejecutar
     */
    public void ejecutarConsulta(String consulta) {
        try {
            sentencia = conexion.createStatement();
            resultSet = sentencia.executeQuery(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Devuelve el numero de filas afectadas por un delete, update o insert No
     * hace commit
     *
     * @param instruccion Instruccion a afectar (Insert, Update o Delete)
     * @return Números de filas afectadas
     */
    public int ejecutarInstruccion(String instruccion) {

        int filas = 0;

        try {
            sentencia = conexion.createStatement();
            filas = sentencia.executeUpdate(instruccion);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filas;
    }

    /**
     * Ejecuta una intrucción y podemos indicar si queremos hacer o no commit
     *
     * @param instruccion Instruccion a ejecutar
     * @param commit True = ejecuta también el commit
     * @return Número de filas afectadas por un delete, update o insert
     */
    public int ejecutarInstruccionCommit(String instruccion, boolean commit) {

        int filas = 0;

        try {
            sentencia = conexion.createStatement();
            filas = sentencia.executeUpdate(instruccion);

            if (commit) {
                commit();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return filas;
    }

    /**
     * Indica si exite el valor que le indicamos Recomendable para valores
     * únicos de String
     *
     * @param valor Valor que queremos saber si existe
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la columna de la base de datos
     * @return Indica si existe o no el valor
     */
    public boolean existeValor(String valor, String columna, String tabla) {

        boolean existe = false;

        Statement sentenciaAux;
        try {
            sentenciaAux = conexion.createStatement();

            ResultSet aux = sentenciaAux.executeQuery("select count(*) from " + tabla + " where upper(" + columna + ")='" + valor.toUpperCase() + "'");

            aux.next();

            if (aux.getInt(1) >= 1) {
                existe = true;
            }

            aux.close();
            sentenciaAux.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    /**
     * Indica si exite el valor que le indicamos Recomendable para valores
     * unicos de int
     *
     * @param valor Valor que queremos saber si existe
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la columna de la base de datos
     * @return Indica si existe o no el valor
     */
    public boolean existeValor(int valor, String tabla, String columna) {

        boolean existe = false;

        Statement sentenciaAux;

        try {
            sentenciaAux = conexion.createStatement();

            ResultSet aux = sentenciaAux.executeQuery("select count(*) from " + tabla + " where " + columna + "=" + valor + "");

            aux.next();

            if (aux.getInt(1) >= 1) {
                existe = true;
            }

            aux.close();
            sentenciaAux.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return existe;
    }

    /**
     * Indica si el resultado devuelve uno o mas registros La consulta debe ser
     * un count
     *
     * @param query Consulta que queremos comprobar que tiene mas o igual de un
     * registro
     * @return True = La consulta genera uno o mas registros
     */
    public boolean masOIgualQueUno(String query) {

        boolean vacio = false;

        Statement sentenciaAux;
        try {
            sentenciaAux = conexion.createStatement();

            ResultSet aux = sentenciaAux.executeQuery(query);

            aux.next();

            if (aux.getInt(1) >= 1) {
                vacio = true;
            }

            aux.close();
            sentenciaAux.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacio;

    }

    /**
     * Devuelve un valor int, recomendado para valores únicos
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Valor que devuelve la consulta
     */
    public int devolverValorInt(String columna, String tabla, String condicion) {

        try (Statement sentenciaAux = conexion.createStatement();
                ResultSet aux = sentenciaAux.executeQuery("select " + columna + " from " + tabla + " where " + condicion);) {

            aux.next();
            return aux.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     * Devuelve un unico valor String
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Valor que devuelve la consulta
     */
    public String devolverValorString(String columna, String tabla, String condicion) {

        try (Statement sentenciaAux = conexion.createStatement();
                ResultSet aux = sentenciaAux.executeQuery("select " + columna + " from " + tabla + " where " + condicion);) {

            if (consultaVacia("select " + columna + " from " + tabla + " where " + condicion)) {
                JOptionPane.showMessageDialog(null, "Error, consulta vacia");
                return null;
            } else {
                aux.next();

                return aux.getString(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Devuelve un array de int con todos los valores int de la columna
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Array con todos los valores int de la columna
     */
    public int[] devolverValoresInt(String columna, String tabla, String condicion) {

        try (Statement sentenciaAux = conexion.createStatement();
                ResultSet aux = sentenciaAux.executeQuery("select " + columna + " from " + tabla + " where " + condicion);) {

            if (consultaVacia("select count(" + columna + ") from " + tabla + " where " + condicion)) {
                JOptionPane.showMessageDialog(null, "Error, consulta vacia");
                return null;
            } else {

                int total = cuentaRegistrosConsulta(tabla, condicion);

                int valores[] = new int[total];

                for (int i = 0; aux.next(); i++) {
                    valores[i] = aux.getInt(1);
                }

                return valores;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Devuelve un array de String con todos los valores String de la columna
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Array con todos los valores String de la columna
     */
    public String[] devolverValoresString(String columna, String tabla, String condicion) {

        try (Statement sentenciaAux = conexion.createStatement();
                ResultSet aux = sentenciaAux.executeQuery("select " + columna + " from " + tabla + " where " + condicion);) {

            if (consultaVacia("select count(" + columna + ") from " + tabla + " where " + condicion)) {
                JOptionPane.showMessageDialog(null, "Error, consulta vacia");
                return null;
            } else {

                int total = cuentaRegistrosConsulta(tabla, condicion);

                String valores[] = new String[total];

                for (int i = 0; aux.next(); i++) {
                    valores[i] = aux.getString(1);
                }

                return valores;

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * Cuenta el numero de registros
     *
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Número de registros de la consulta
     */
    public int cuentaRegistrosConsulta(String tabla, String condicion) {

        String consulta;

        if (condicion.equals("")) {
            consulta = "select count(*) from " + tabla;
        } else {
            consulta = "select count(*) from " + tabla + " where " + condicion;
        }

        try (Statement sentenciaAux = conexion.createStatement();
                ResultSet aux = sentenciaAux.executeQuery(consulta);) {

            return aux.getInt(0);

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }

    }

    /**
     * Indica si el resutado de una consulta es vacia
     *
     * @param query Consulta, debe contener un count
     * @return True = consulta vacia
     */
    public boolean consultaVacia(String query) {

        boolean vacio = false;

        Statement sentenciaAux;
        try {
            sentenciaAux = conexion.createStatement();

            ResultSet aux = sentenciaAux.executeQuery(query);

            aux.next();

            if (aux.getInt(1) == 0) {
                vacio = true;
            }

            aux.close();
            sentenciaAux.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vacio;

    }

    /**
     * Indica el ultimo ID de la base de datos No tiene en cuenta si esta o no
     * eliminado
     *
     * @param columnaID Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @return Valor del último ID de la base de datos
     */
    public int ultimoID(String columnaID, String tabla) {

        int IDMaximo = -1;
        Statement sm;
        try {
            sm = conexion.createStatement();
            ResultSet rs = sm.executeQuery("select max(" + columnaID + ") as " + columnaID + " from " + tabla + "");
            rs.next();
            IDMaximo = rs.getInt(columnaID);

            rs.close();
            sm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDMaximo;

    }

    /**
     * Devuelve el proximo ID sobre el que podemos usar Si no hay registros
     * empieza en 1
     *
     * @param columnaID Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @return Valor del último ID que podemos usar
     */
    public int proximoIDDisponible(String columnaID, String tabla) {

        int id = ultimoID(columnaID, tabla);

        if (id == -1) {
            return 1;
        } else {
            return id + 1;
        }

    }

    /**
     * Devuelve el ultimo id que no esta eliminado (si se usa una columna
     * eliminado)
     *
     * @param columnaEliminado Nombre de la columna usada para indicar si esta
     * eliminado o no un registro de la base de datos
     * @param columnaID Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @return Valor del último ID sin eliminar que podemos usar
     */
    public int ultimoIDSinEliminar(String columnaEliminado, String columnaID, String tabla) {

        int IDMaximo = -1;
        Statement sm;
        try {
            sm = conexion.createStatement();
            ResultSet rs = sm.executeQuery("select max(" + columnaID + ") as " + columnaID + " from " + tabla + " where " + columnaEliminado + "=0");
            rs.next();
            IDMaximo = rs.getInt(columnaID);

            rs.close();
            sm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDMaximo;

    }

    /**
     * Devuelve el primer ID de la base de datos
     *
     * @param columnaID Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @return Valor del primer ID
     */
    public int primerID(String columnaID, String tabla) {

        int IDMaximo = -1;
        Statement sm;
        try {
            sm = conexion.createStatement();
            ResultSet rs = sm.executeQuery("select min(" + columnaID + ") as " + columnaID + " from " + tabla + "");
            rs.next();
            IDMaximo = rs.getInt(columnaID);

            rs.close();
            sm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDMaximo;

    }

    /**
     * Devuelve el primer ID que no esta eliminado
     *
     * @param columnaEliminado Nombre de la columna usada para indicar si esta
     * eliminado o no un registro de la base de datos
     * @param columnaID Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @return Valor del primer ID sin eliminar que podemos usar
     */
    public int primerIDSinEliminar(String columnaEliminado, String columnaID, String tabla) {

        int IDMaximo = -1;
        Statement sm;
        try {
            sm = conexion.createStatement();
            ResultSet rs = sm.executeQuery("select min(" + columnaID + ") as " + columnaID + " from " + tabla + " where " + columnaEliminado + "=0");
            rs.next();
            IDMaximo = rs.getInt(columnaID);

            rs.close();
            sm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return IDMaximo;

    }

    /**
     * Devuelve el registro menor de una columna Ordenado alfabeticamente
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Valor mínimo de una columna
     */
    public String minimoDe(String columna, String tabla, String condicion) {

        String resultado = "";

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet rs;
            if (condicion.equals("")) {
                rs = sm.executeQuery("select min(" + columna + ") as " + columna + " from " + tabla + "");
            } else {
                rs = sm.executeQuery("select min(" + columna + ") as " + columna + " from " + tabla + " where " + condicion);
            }

            rs.next();
            resultado = rs.getString(columna);

            rs.close();
            sm.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    /**
     * Devuelve el registro mayor de una tabla Ordenado alfabeticamente
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Valor máximo de una columna
     */
    public String maximoDe(String columna, String tabla, String condicion) {

        String resultado = "";

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet rs;
            if (condicion.equals("")) {
                rs = sm.executeQuery("select max(" + columna + ") as " + columna + " from " + tabla + "");
            } else {
                rs = sm.executeQuery("select max(" + columna + ") as " + columna + " from " + tabla + " where " + condicion);
            }

            rs.next();
            resultado = rs.getString(columna);

            rs.close();
            sm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;

    }

    /**
     * Devuelve la suma de una columna de la base de datos
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Total de la suma
     */
    public int sumaDeInt(String columna, String tabla, String condicion) {

        String resultado = "";

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet rs;
            if (condicion.equals("")) {
                rs = sm.executeQuery("select sum(" + columna + ") as " + columna + " from " + tabla + "");
            } else {
                rs = sm.executeQuery("select sum(" + columna + ") as " + columna + " from " + tabla + " where " + condicion);
            }

            rs.next();
            resultado = rs.getString(columna);

            rs.close();
            sm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Integer.parseInt(resultado);

    }

    /**
     * Devuelve la suma de una columna de la base de datos
     *
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     * @return Total de la suma
     */
    public double sumaDeDouble(String columna, String tabla, String condicion) {

        String resultado = "";

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet rs;
            if (condicion.equals("")) {
                rs = sm.executeQuery("select sum(" + columna + ") as " + columna + " from " + tabla + "");
            } else {
                rs = sm.executeQuery("select sum(" + columna + ") as " + columna + " from " + tabla + " where " + condicion);
            }

            rs.next();
            resultado = rs.getString(columna);

            rs.close();
            sm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Double.parseDouble(resultado);

    }

    /**
     * Rellena un combobox de String La columna debe der del tipo String Solo
     * una columna
     *
     * @param cmb ComboBox que queremos rellenar
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     */
    public void rellenaComboBoxBDString(JComboBox cmb, String columna, String tabla, String condicion) {

        cmb.removeAllItems();

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet consulta = sm.executeQuery("select distinct " + columna + " from " + tabla);

            ResultSet correspondiente = null;

            if (!condicion.equals("")) {

                Statement smAux = conexion.createStatement();

                correspondiente = sm.executeQuery("select distinct " + columna + " from " + tabla + " where " + condicion);
                correspondiente.next();

                while (consulta.next()) {

                    cmb.addItem(consulta.getString(columna));
                    if (correspondiente.getString(columna).equals(consulta.getString(columna))) {
                        cmb.setSelectedItem(correspondiente.getString(columna));
                    }
                }

                correspondiente.close();
                smAux.close();
            } else {

                while (consulta.next()) {

                    cmb.addItem(consulta.getString(columna));

                }

            }

            consulta.close();
            sm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Rellena un combobox de Integer La columna debe der del tipo Int Solo una
     * columna
     *
     * @param cmb ComboBox que queremos rellenar
     * @param columna Nombre de la columna de la base de datos
     * @param tabla Nombre de la tabla de la base de datos
     * @param condicion Condicion (sin where)
     */
    public void rellenaComboBoxBDInt(JComboBox cmb, String tabla, String columna, String condicion) {

        cmb.removeAllItems();

        Statement sm;
        try {
            sm = conexion.createStatement();

            ResultSet consulta = sm.executeQuery("select distinct " + columna + " from " + tabla);

            ResultSet correspondiente = null;

            if (!condicion.equals("")) {

                Statement smAux = conexion.createStatement();

                correspondiente = smAux.executeQuery("select distinct " + columna + " from " + tabla + " where " + condicion);
                correspondiente.next();

                while (consulta.next()) {

                    cmb.addItem(consulta.getInt(columna));
                    if (correspondiente.getInt(columna) == consulta.getInt(columna)) {
                        cmb.setSelectedItem(correspondiente.getInt(columna));
                    }
                }

                correspondiente.close();
                smAux.close();
            } else {

                while (consulta.next()) {

                    cmb.addItem(consulta.getInt(columna));

                }

            }

            consulta.close();

            sm.close();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Rellena un combobox con dos columnas, el id(no visible) y el nombre La
     * consulta debe devolver el codigo y un nombre (por ese orden)
     *
     * @param cmb ComboBox donde se rellenaran los datos
     * @param consulta Consulta usada
     * @param inicio Primer valor personalizado (puede estar vacio)
     * @param columnaNoVisible Nombre de la columna que no se verá en el
     * comboBOx (ID por ejemplo)
     * @param columnaVisible Nombre de la columna que será visible en el
     * comboBox
     */
    public void rellenaComboBox2Columnas(JComboBox cmb, String consulta, String inicio, String columnaNoVisible, String columnaVisible) {

        String datos[] = new String[2];
        try {
            cmb.removeAllItems(); //Borra todos los Items
            Statement aux = conexion.createStatement();
            ResultSet resultado = aux.executeQuery(consulta);

            //Dato inicial
            if (!inicio.equals("")) {
                datos[0] = Integer.toString(-1);
                datos[1] = inicio;
                cmb.addItem(new String[]{datos[0], datos[1],});
            }

            while (resultado.next()) {
                datos[0] = Integer.toString(resultado.getInt(columnaNoVisible));
                datos[1] = resultado.getString(columnaVisible);
                cmb.addItem(new String[]{datos[0], datos[1],});
            }

            cmb.setRenderer(new DefaultListCellRenderer() {
                @Override
                public java.awt.Component getListCellRendererComponent(
                        JList l, Object o, int i, boolean s, boolean f) {
                    return new JLabel(((String[]) o)[1]);
                }
            });

        } catch (SQLException e) {
            System.out.println(e.getStackTrace());
        }

    }

    /**
     * Rellena un DefaultTableModel de una consulta. Se adapta automaticamente
     * al número de columnas Se debe ejecutar el metodo "ejecutarConsulta" antes
     * de llamar a este método
     *
     * @param tabla Elemento donde se muestran los datos
     */
    public void rellenaJTableBD(DefaultTableModel tabla) {
        try {

            //Cabecera
            ResultSetMetaData metadatos = resultSet.getMetaData();

            tabla.setColumnCount(metadatos.getColumnCount());

            int numeroColumnas = tabla.getColumnCount();

            String[] etiquetas = new String[numeroColumnas];

            for (int i = 0; i < numeroColumnas; i++) {
                etiquetas[i] = metadatos.getColumnLabel(i + 1);
            }

            tabla.setColumnIdentifiers(etiquetas);

            //Contenido
            while (resultSet.next()) {
                Object[] datosFila = new Object[tabla.getColumnCount()];
                for (int i = 0; i < tabla.getColumnCount(); i++) {
                    datosFila[i] = resultSet.getObject(i + 1);
                }
                tabla.addRow(datosFila);
            }

            cerrarResult();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
