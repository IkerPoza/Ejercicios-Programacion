package Vista;

import Controlador.personaControlador;
import Utilidades.ValidarDato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class formularioEliminarControllerVista {

    @FXML
    private Button bEliminar;

    @FXML
    private Button bVolver;

    @FXML
    private TextField tDni;

    private menuInicialControllerVista controller;
    private Stage stage;

    @FXML
    void onEliminarClick(ActionEvent event) {
        try {
            if (tDni.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Campo incompleto");
                alert.setHeaderText(null);
                alert.setContentText("Por favor, rellena todos los campos.");
                alert.showAndWait();
            }else {
                String dni = ValidarDato.validarDato(tDni.getText(), "^[0-9]{8}[A-Z]$");
                personaControlador.eliminar(dni);
                tDni.clear();
            }

        }catch (Exception ex){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos incorrectos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, completa los campos correctamente.");
            alert.showAndWait();
        }
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
