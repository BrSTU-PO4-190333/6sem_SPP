module com.example.spp_2sem_po4_galanin_lab4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.spp_2sem_po4_galanin_lab4 to javafx.fxml;
    exports com.example.spp_2sem_po4_galanin_lab4;
}