module io.github.pavel_innokentevich_galanin.gpi_spp6_lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.github.pavel_innokentevich_galanin.gpi_spp6_lab2 to javafx.fxml;
    exports io.github.pavel_innokentevich_galanin.gpi_spp6_lab2;
}