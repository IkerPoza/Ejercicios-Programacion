module com.example.prjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires mysql.connector.j;


    opens com.example.prjavafx to javafx.fxml;
    exports com.example.prjavafx;
    exports Vista;
    opens Vista to javafx.fxml;
}