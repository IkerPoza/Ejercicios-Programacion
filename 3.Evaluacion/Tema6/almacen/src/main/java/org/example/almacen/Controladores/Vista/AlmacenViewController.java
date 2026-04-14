package org.example.almacen.Controladores.Vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import org.example.almacen.Controladores.Modelo.AlmacenController;
import org.example.almacen.Modelo.Producto;
import org.example.almacen.Modelo.ProductoDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlmacenViewController {

    @FXML
    private Button bAceptar;

    @FXML
    private Button bCancelar;

    @FXML
    private CheckBox cbProntoPago;

    @FXML
    private ComboBox<String> cbProveedores;

    @FXML
    private CheckBox cbVolumen;

    @FXML
    private ToggleGroup gOperacion;

    @FXML
    private TitledPane pCompra;

    @FXML
    private TitledPane pOperacion;

    @FXML
    private HBox hbBotones;

    @FXML
    private TitledPane pVenta;

    @FXML
    private RadioButton rbCompra;

    @FXML
    private RadioButton rbVenta;

    @FXML
    private TextField tfCliente;

    @FXML
    private TextField tfImporteCompra;

    @FXML
    private TextField tfImporteVenta;

    @FXML
    private TextField tfNombreProducto;

    @FXML
    private TextField tfPrecio;

    @FXML
    private TextField tfPrecioVenta;

    @FXML
    private TextField tfUnidades;

    @FXML
    void aceptar(ActionEvent event) throws Exception {
        if (operacion.equalsIgnoreCase("compra")) {
            AlmacenController.actualizarProductoCompra(unidades, Float.parseFloat(tfPrecio.getText()), tfNombreProducto.getText());
            mostrarAlerta("Compra realizada", "La compra se ha realizado correctamente", Alert.AlertType.INFORMATION);
        } else if (operacion.equalsIgnoreCase("venta")) {
            AlmacenController.actualizarProductoVenta(unidades, tfNombreProducto.getText());
            mostrarAlerta("Venta realizada", "La venta se ha realizado correctamente", Alert.AlertType.INFORMATION);
        }
    }

    // Variable global para saber  que operación realizar en el botón aceptar
    private String operacion;

    @FXML
    void activarCompra(ActionEvent event) {
        // Habilitar los campos de compra y deshabilitar los de venta.
        try {
            operacion = "Compra";
            pCompra.setVisible(true);
            pVenta.setVisible(false);
            colocarBotones(pCompra.getPrefHeight());
            cbProveedores.getItems().clear();
            // LLenar combo
            AlmacenController.llenarCombo(cbProveedores);
            tfPrecio.requestFocus();
        } catch (Exception ex) {
            mostrarAlerta("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }


    @FXML
    void activarVenta(ActionEvent event) {
        // Habilitar los campos de venta y deshabilitar los de compra.
        try {
            operacion = "Venta";
            pCompra.setVisible(false);
            pVenta.setVisible(true);
            colocarBotones(pVenta.getPrefHeight());
        } catch (Exception ex) {
            mostrarAlerta("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void aplicarDescuentoPorVolumen(ActionEvent event) throws Exception {
        float descuento = Float.parseFloat(tfPrecioVenta.getText()) * 0.02f;
        if (cbVolumen.isSelected()) {
            tfImporteVenta.setText(String.valueOf(Float.parseFloat(tfPrecioVenta.getText())-descuento));
        }else {
            tfImporteVenta.setText(String.valueOf(Float.parseFloat(tfImporteVenta.getText())+descuento));
        }
    }

    @FXML
    void aplicarDescuentoProntoPago(ActionEvent event) throws Exception {
        float descuento = Float.parseFloat(tfPrecioVenta.getText()) * 0.03f;
        if (cbProntoPago.isSelected()) {
            tfImporteVenta.setText(String.valueOf(Float.parseFloat(tfPrecioVenta.getText())-descuento));
        }else {
            tfImporteVenta.setText(String.valueOf(Float.parseFloat(tfImporteVenta.getText())+descuento));
        }
    }

    @FXML
    void cancelar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void validarCliente(ActionEvent event) {
        try {
            String nombre = tfCliente.getText();
            if (nombre.isEmpty())
                throw new Exception("El nombre del cliente es un campo obligatorio");
            Pattern pat = Pattern.compile("^[A-Z][a-z]*$");
            Matcher mat = pat.matcher(nombre);

            float precio = AlmacenController.precioVenta(tfNombreProducto.getText());
            tfPrecioVenta.setText(String.valueOf(precio*2));
            tfImporteVenta.setText(String.valueOf(Float.parseFloat(tfPrecioVenta.getText())*unidades));

            if (!mat.matches())
                throw new Exception("El nombre del cliente no tiene un formato adecuado");
        } catch (Exception e) {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfCliente.requestFocus();
        }
    }

    @FXML
    void validarPrecioCompra(ActionEvent event) {
        try {
            int precio = Integer.parseInt(tfPrecio.getText());
            if (precio < 0)
                throw new Exception("El precio es un campo numérico mayor o igual que cero");
            int importe = precio * unidades;
            tfImporteCompra.setText(String.valueOf(importe));
        } catch (Exception e) {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfUnidades.requestFocus();
        }
    }

    private int unidades;

    @FXML
    void validarUnidades(ActionEvent event) {
        // Comprobar que las unidades son un número entero positivo.
        try {
            unidades = Integer.parseInt(tfUnidades.getText());
            if (unidades <= 0)
                throw new Exception("Las unidades son un campo numérico mayor que cero");
        } catch (Exception e) {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfUnidades.requestFocus();
        }

    }

    @FXML
    void validarYBuscarProducto(ActionEvent event) {
        // Comprobar que es texto y que existe en la base de datos.
        try {
            String nombre = tfNombreProducto.getText();
            if (nombre.isEmpty())
                throw new Exception("El nombre del producto es un campo obligatorio");
            Pattern pat = Pattern.compile("^[A-Z][a-z]*$");
            Matcher mat = pat.matcher(nombre);
            if (!mat.matches())
                throw new Exception("El nombre del producto no tiene un formato adecuado");

            // Buscar en la base de datos el producto
            AlmacenController.buscarProducto(nombre);
        } catch (Exception e) {
            mostrarAlerta("Error de Validación", e.getMessage(), Alert.AlertType.ERROR);
            tfNombreProducto.requestFocus();
        }

    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();

    }

    // Se ejecuta automáticamente al cargar el FXML
    @FXML
    public void initialize() {
        // Evento de foco perdido. No está en sceneBuilder
        tfNombreProducto.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // el campo perdió el foco
                validarYBuscarProducto(null); // reutiliza el mismo método
            }
        });

        pCompra.setVisible(false);
        pVenta.setVisible(false);
        colocarBotones(0); // sin panel visible, altura 0
    }

    private static final double LAYOUT_Y_PANELES = 253.0;  // layoutY de pCompra y pVenta
    private static final double MARGEN = 15.0;

    private void colocarBotones(double alturaPanelVisible) {
        hbBotones.setLayoutY(LAYOUT_Y_PANELES + alturaPanelVisible + MARGEN);
    }
}
