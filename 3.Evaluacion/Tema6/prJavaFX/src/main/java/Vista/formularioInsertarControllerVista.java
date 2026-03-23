package Vista;

import Utilidades.ValidarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class formularioInsertarControllerVista {

    @FXML
    private Button bAñadir;

    @FXML
    private Button bVolver;

    @FXML
    private TextField tApellido;

    @FXML
    private TextField tDni;

    @FXML
    private DatePicker dpFechaNac;

    @FXML
    private TextField tNombre;

    @FXML
    private TextField tTelefono;
    private menuInicialControllerVista controller;
    private Stage stage;

    @FXML
    void onAñadirClick(ActionEvent event) {
        if (tDni.getText().isEmpty() || tNombre.getText().isEmpty() || tApellido.getText().isEmpty() || dpFechaNac.getValue() == null || tTelefono.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incompletos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, rellena todos los campos.");
            alert.showAndWait();
        }
        String dni = ValidarDato.validarDato(tDni.getText(), "DNI", "^[0-9]{8}[A-Z]$");

    }

    @FXML
    void onVolverClick(ActionEvent event) {
        controller.show();
        stage.close();
    }

    public void init(Stage stage, menuInicialControllerVista menuInicialControllerVista) {
        this.controller = menuInicialControllerVista;
        this.stage = stage;
    }
}
