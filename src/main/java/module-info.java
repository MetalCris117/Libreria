module uacm.libros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens uacm.libros to javafx.fxml;
    exports uacm.libros;
}
