package Vista;

import com.example.prjavafx.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class menuInicialControllerVista {

    @FXML
    private Button bConsultar;

    @FXML
    private Button bEliminar;

    @FXML
    private Button bInsertar;

    @FXML
    private Button bSalir;

    public menuInicialControllerVista() {
    }

    @FXML
    void onEliminarClick(ActionEvent event) {

    }

    @FXML
    void onInsertarClick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("formularioInsertar.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Insertar");
        stage.setScene(scene);

        formularioInsertarControllerVista controller = fxmlLoader.getController();

        controller.init(stage,this);

        stage.show();
        this.stage.close();
    }

    private Stage stage;

    public void setStage(Stage stage) {
        // Establece la ventana actual
        this.stage = stage;
    }

    public void show() {
        // Muestra la ventana
        stage.show();
    }

    @FXML
    void onSalirClick(ActionEvent event) {
        System.exit(0);
    }

}
