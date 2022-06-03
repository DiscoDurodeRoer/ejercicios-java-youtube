package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Persona;

public class PersonasController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private TableView<Persona> tblPersonas;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidos;
    @FXML
    private TableColumn colEdad;

    private ObservableList<Persona> personas;
    private ObservableList<Persona> filtroPersonas;

    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtFiltrarNombre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();
        filtroPersonas = FXCollections.observableArrayList();

        this.tblPersonas.setItems(personas);

        this.colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.colApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.colEdad.setCellValueFactory(new PropertyValueFactory("edad"));
    }

    @FXML
    private void agregarPersona(ActionEvent event) {

        try {

            // Cargo la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PersonaDialogVista.fxml"));

            // Cargo la ventana
            Parent root = loader.load();

            // Cojo el controlador
            PersonaDialogControlador controlador = loader.getController();
            controlador.initAtributtes(personas);

            // Creo el Scene
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

            // cojo la persona devuelta
            Persona p = controlador.getPersona();
            if (p != null) {
                personas.add(p);
                if (p.getNombre().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                    this.filtroPersonas.add(p);
                }
                this.tblPersonas.refresh();
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void modificar(ActionEvent event) {

        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {

            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PersonaDialogVista.fxml"));

                // Cargo la ventana
                Parent root = loader.load();

                // Cojo el controlador
                PersonaDialogControlador controlador = loader.getController();
                controlador.initAtributtes(personas, p);

                // Creo el Scene
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();
                
                // cojo la persona devuelta
                Persona pSeleccionado = controlador.getPersona();
                if (pSeleccionado != null) {
                    if (!pSeleccionado.getNombre().toLowerCase().contains(this.txtFiltrarNombre.getText().toLowerCase())) {
                        this.filtroPersonas.remove(pSeleccionado);
                    }
                    this.tblPersonas.refresh();
                }

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        }

    }

    @FXML
    private void eliminar(ActionEvent event) {

        Persona p = this.tblPersonas.getSelectionModel().getSelectedItem();

        if (p == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una persona");
            alert.showAndWait();
        } else {
            // Elimino la persona
            this.personas.remove(p);
            this.filtroPersonas.remove(p);
            this.tblPersonas.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Info");
            alert.setContentText("Persona eliminada");
            alert.showAndWait();

        }

    }

    @FXML
    private void filtrarNombre(KeyEvent event) {

        String filtroNombre = this.txtFiltrarNombre.getText();

        // Si el texto del nombre esta vacio, seteamos la tabla de personas con el original
        if (filtroNombre.isEmpty()) {
            this.tblPersonas.setItems(personas);
        } else {

            // Limpio la lista
            this.filtroPersonas.clear();

            for (Persona p : this.personas) {
                if (p.getNombre().toLowerCase().contains(filtroNombre.toLowerCase())) {
                    this.filtroPersonas.add(p);
                }
            }

            this.tblPersonas.setItems(filtroPersonas);

        }

    }

}
