/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Persona;

public class PersonaDialogControlador implements Initializable {

    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtApellidos;
    @FXML
    private TextField txtNombre;

    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnSalir;

    private Persona persona;

    private ObservableList<Persona> personas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void initAttributtes(ObservableList<Persona> personas) {
        this.personas = personas;
    }

    @FXML
    private void guardar(ActionEvent event) {

        // Cojo los datos
        String nombre = this.txtNombre.getText();
        String apellidos = this.txtApellidos.getText();
        int edad = Integer.parseInt(this.txtEdad.getText());

        // Creo la persona
        Persona p = new Persona(nombre, apellidos, edad);

        // Compruebo si la persona existe
        if (!personas.contains(p)) {
            this.persona = p;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Se ha añadido correctamente");
            alert.showAndWait();

            // Cerrar ventana
            Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La persona ya existe");
            alert.showAndWait();
        }

    }

    @FXML
    private void salir(ActionEvent event) {
        this.persona = null;
        // Cerrar ventana
        Stage stage = (Stage) this.btnGuardar.getScene().getWindow();
        stage.close();

    }

    public Persona getPersona() {
        return persona;
    }

}
