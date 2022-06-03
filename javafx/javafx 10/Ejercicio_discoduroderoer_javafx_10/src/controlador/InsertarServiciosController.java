/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Servicio;
import modelo.Vehiculo;

public class InsertarServiciosController implements Initializable {

    @FXML
    private Button btnGrabar;
    @FXML
    private ComboBox<Cliente> cmbClientes;
    @FXML
    private ComboBox<Vehiculo> cmbVehiculos;
    @FXML
    private TextField txtDirCli;
    @FXML
    private TextField txtNIFCli;
    @FXML
    private TextField txtPrecioVeh;
    @FXML
    private TextField txtKmVeh;
    @FXML
    private TextField txtMarcaVeh;
    @FXML
    private TextField txtDescripcionVeh;
    @FXML
    private TextField txtPobCli;
    @FXML
    private DatePicker dtpFechaAlquiler;
    @FXML
    private DatePicker dtpFechaEntrega;
    @FXML
    private TextField txtTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        initCombos();
    }

    public void initCombos() {

        Cliente c = new Cliente();

        ObservableList<Cliente> obsClientes = c.getClientes();

        this.cmbClientes.setItems(obsClientes);

        Vehiculo v = new Vehiculo();

        ObservableList<Vehiculo> obsVehiculos = v.getVehiculos();

        this.cmbVehiculos.setItems(obsVehiculos);

    }

    public void closeWindows() {
        try {
            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuVista.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene y el stage
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            // Asocio el stage con el scene
            stage.setScene(scene);
            stage.show();

            // Ciero la ventana donde estoy
            Stage myStage = (Stage) this.btnGrabar.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void seleccionarCliente(ActionEvent event) {

        // Obtengo el valor del como del cliente
        Cliente c = this.cmbClientes.getValue();

        if (c != null) {

            //Seteo los calores
            this.txtNIFCli.setText(c.getNIF());
            this.txtDirCli.setText(c.getDireccion());
            this.txtPobCli.setText(c.getPoblacion());

        }

    }

    @FXML
    private void seleccionarVehiculo(ActionEvent event) {

        
        // Obtengo el valor del combo del vehiculo
        Vehiculo v = this.cmbVehiculos.getValue();

        if (v != null) {

            // Seteo los valores
            this.txtDescripcionVeh.setText(v.getDescripcion());
            this.txtMarcaVeh.setText(v.getMarca());
            this.txtKmVeh.setText(v.getKm() + "");
            this.txtPrecioVeh.setText(v.getPrecio() + "");
            calcularTotalServicio();

        }

    }

    @FXML
    private void seleccionarFechaAlquiler(ActionEvent event) {
        calcularTotalServicio();
    }

    @FXML
    private void seleccionarFechaEntrega(ActionEvent event) {
        calcularTotalServicio();
    }

    public void calcularTotalServicio() {

        // Obtengo las fechas de inicio y fin
        LocalDate inicio = this.dtpFechaAlquiler.getValue();
        LocalDate fin = this.dtpFechaEntrega.getValue();

        // Entramos si el inicio y el fin no es nulo y hay un vehiculo seleccionado
        if (inicio != null && fin != null && this.cmbVehiculos.getValue() != null) {

            // Obtengo la diferencia de dias
            Period p = Period.between(inicio, fin);
            long dias = p.getDays();

            // Calculo el total
            long total = dias * Integer.parseInt(this.txtPrecioVeh.getText() + "");

            if (total < 0) {
                this.txtTotal.setText("0");
            } else {
                this.txtTotal.setText(total + "");
            }

        } else {
            this.txtTotal.setText("0");
        }

    }

    @FXML
    private void grabarServicio(ActionEvent event) {

        // Obtengo los valores
        Vehiculo v = this.cmbVehiculos.getValue();
        Cliente c = this.cmbClientes.getValue();
        LocalDate inicio = this.dtpFechaAlquiler.getValue();
        LocalDate fin = this.dtpFechaEntrega.getValue();
        int total = Integer.parseInt(this.txtTotal.getText());

        // Validamos
        String errores = "";

        if (c == null) {
            errores += "- Debes seleccionar un cliente\n";
        }

        if (v == null) {
            errores += "- Debes seleccionar un vehiculo\n";
        }

        if (inicio == null) {
            errores += "- Debes seleccionar una fecha de alquiler\n";
        }

        if (fin == null) {
            errores += "- Debes seleccionar una fecha de entrega\n";
        }

        if (inicio != null && fin != null && inicio.isAfter(fin)) {
            errores += "- La fecha de alquiler no puede superar a la de entrega\n";
        }

        if (total == 0) {
            errores += "- El total no puede ser 0\n";
        }

        if (errores.isEmpty()) {

            // Creo el servicio
            Servicio s = new Servicio(v.getMatricula(), c.getNIF(), inicio, fin, total);
            
            // lo inserto
            if (s.insertarServicio()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Exito");
                alert.setContentText("Se inserto correctamente");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("No se inserto correctamente");
                alert.showAndWait();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(errores);
            alert.showAndWait();
        }

    }

}
