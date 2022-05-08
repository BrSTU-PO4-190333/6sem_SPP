module com.example.spp_2sem_po4_galanin_lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.spp_2sem_po4_galanin_lab2 to javafx.fxml;
    exports com.example.spp_2sem_po4_galanin_lab2;
}