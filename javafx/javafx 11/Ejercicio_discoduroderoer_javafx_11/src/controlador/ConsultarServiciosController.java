package controlador;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Servicio;

public class ConsultarServiciosController implements Initializable {

    @FXML
    private DatePicker dtpFechaInicial;
    @FXML
    private ComboBox<Cliente> cmbClientes;
    @FXML
    private TableView<Servicio> tblServicios;
    @FXML
    private TableColumn<Servicio, String> colMatricula;
    @FXML
    private TableColumn<Servicio, String> colMarca;
    @FXML
    private TableColumn<Servicio, Integer> colPrecio;
    @FXML
    private TableColumn<Servicio, LocalDate> colFechaAlquiler;
    @FXML
    private TableColumn<Servicio, LocalDate> colFechaEntrega;
    @FXML
    private TableColumn<Servicio, Integer> colTotal;
    @FXML
    private DatePicker dtpFechaFinal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Asocio los atributos de servicio con las columnas de la tabla
        this.colMatricula.setCellValueFactory(new PropertyValueFactory("matriculaVehiculo"));
        this.colMarca.setCellValueFactory(new PropertyValueFactory("marca"));
        this.colPrecio.setCellValueFactory(new PropertyValueFactory("precio"));
        this.colFechaAlquiler.setCellValueFactory(new PropertyValueFactory("fechaAlquiler"));
        this.colFechaEntrega.setCellValueFactory(new PropertyValueFactory("fechaEntrega"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory("total"));

        // Cargo los servicios en la tabla
        Servicio s = new Servicio();
        ObservableList<Servicio> items = s.getServicios();
        this.tblServicios.setItems(items);

        // Cargo los clientes en el combobox
        Cliente c = new Cliente();
        ObservableList<Cliente> obsClientes = c.getClientes();
        this.cmbClientes.setItems(obsClientes);

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
            Stage myStage = (Stage) this.cmbClientes.getScene().getWindow();
            myStage.close();

        } catch (IOException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
