## Init

1. `File` > `Project Structure...`.
2. `Project Settings` > `Libraries` > `+` > `Java`.
3. `C:\Java\openjfx-18_windows-x64_bin-sdk\javafx-sdk-18\lib`.
4. `OK` > `OK`.
5. `Build` > `Build Project`.
6. `Run` > `Edit Configurations...` > `+` > `Application`.
7. `Main class` > `io.github.pavel_innokentevich_galanin.gpi_spp6_lab2.HelloApplication`.
8. `Modify options` > `Add VM options`.
9. `--module-path "C:\Java\openjfx-18_windows-x64_bin-sdk\javafx-sdk-18\lib" --add-modules javafx.controls,javafx.fxml`.
10. Delete file `module-info.java`
11. `Run` > `Run 'Unnamed'`.
