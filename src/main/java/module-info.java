module uacm.libros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens uacm.libros to javafx.fxml;
    exports uacm.libros;
}
