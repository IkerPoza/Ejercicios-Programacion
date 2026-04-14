module org.example.almacen {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.almacen to javafx.fxml;
    exports org.example.almacen;
    exports org.example.almacen.Controladores.Vista;
    opens org.example.almacen.Controladores.Vista to javafx.fxml;

}