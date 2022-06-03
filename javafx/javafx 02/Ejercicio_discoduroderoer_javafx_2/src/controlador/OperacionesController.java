/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import modelo.Operaciones;

public class OperacionesController implements Initializable {

    @FXML
    private TextField txtOp1;
    @FXML
    private TextField txtOp2;
    @FXML
    private Button btnOperacion;
    @FXML
    private RadioButton rdbSuma;
    @FXML
    private RadioButton rdbResta;
    @FXML
    private RadioButton rdbMult;
    @FXML
    private RadioButton rdbDivision;
    @FXML
    private TextField txtResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup tg = new ToggleGroup();
        this.rdbSuma.setToggleGroup(tg);
        this.rdbResta.setToggleGroup(tg);
        this.rdbMult.setToggleGroup(tg);
        this.rdbDivision.setToggleGroup(tg);
    }

    @FXML
    private void hacerOperacion(ActionEvent event) {

        try {
            // Obtengo los operadores
            int op1 = Integer.parseInt(this.txtOp1.getText());
            int op2 = Integer.parseInt(this.txtOp2.getText());

            // Creo una instancia del modelo
            Operaciones op = new Operaciones(op1, op2);

            // Segun el radio seleccionado, hago una u otra operacion
            if (this.rdbSuma.isSelected()) {
                this.txtResultado.setText(op.suma() + "");
            } else if (this.rdbResta.isSelected()) {
                this.txtResultado.setText(op.resta() + "");
            } else if (this.rdbMult.isSelected()) {
                this.txtResultado.setText(op.mult() + "");
            } else if (this.rdbDivision.isSelected()) {
                // Si el operando 2 es 0, lanzo error
                if (op2 == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El operando 2 no puede ser 0");
                    alert.showAndWait();
                } else {
                    this.txtResultado.setText(op.division() + "");
                }
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }

}
