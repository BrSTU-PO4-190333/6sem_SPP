package com.example.spp_2sem_po4_galanin_lab4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ProducerController implements Initializable {
    @FXML
    protected TableView<ProducerModel> TableView__ProducerModel;

    @FXML
    protected TableColumn<ProducerModel, Integer> TableColumn__ProducerCode;

    @FXML
    protected TableColumn<ProducerModel, String> TableColumn__ProducerName;

    @FXML
    protected TextField TextField__ProducerCode_filter;

    @FXML
    protected TextField TextField__ProducerName_filter;

    @FXML
    protected void Button__add_ProducerModel_clicked() {
        open_form("0");
    }

    protected void open_form(String id) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    ProducerController.class.getResource(
                            "producer-form-view.fxml"
                    )
            );

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Форма справочника \"Производители\"");
            stage.setScene(scene);

            ProducerFormController controller = fxmlLoader.getController();
            controller.initData(id);
            fxmlLoader.setController(controller);

            stage.show();
        }
        catch (Exception exception) {
            System.out.println(exception);
            exception.printStackTrace();
        }
    }

    @FXML
    protected void Button__refresh_Producer_table_clicked() {
        try {
            ObservableList<ProducerModel> list = get_list();

            TableColumn__ProducerCode.setCellValueFactory(new PropertyValueFactory<>("ProducerCode"));
            TableColumn__ProducerName.setCellValueFactory(new PropertyValueFactory<>("ProducerName"));

            TableView__ProducerModel.setItems(list);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    protected ObservableList<ProducerModel> get_list() {
        ObservableList<ProducerModel> list = FXCollections.observableArrayList();
        Connection connection = Database.get_connect_to_database();

        try {
            String sql = "SELECT * FROM \"catalog__producer\"\n" +
                    "WHERE\n" +
                    "(\n" +
                    "\tProducerCode LIKE \"" + TextField__ProducerCode_filter.getText() + "%\"\n" +
                    "\tAND\n" +
                    "\tProducerName LIKE \"" + TextField__ProducerName_filter.getText() + "%\"\n" +
                    ");";
            System.out.println(sql);
            Statement statement = connection != null ? connection.createStatement() : null;

            ResultSet result_set = statement != null ? statement.executeQuery(sql) : null;

            if (result_set == null) {
                return null;
            }
            ProducerModel model;
            while(result_set.next()) {
                model = new ProducerModel(
                        result_set.getInt("ProducerCode"),
                        result_set.getString("ProducerName")
                );
                list.add(model);
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return list;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Button__refresh_Producer_table_clicked();

        TableView.TableViewSelectionModel<ProducerModel> selectionModel = TableView__ProducerModel.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<ProducerModel>() {
            @Override
            public void changed(ObservableValue<? extends ProducerModel> observableValue, ProducerModel oldValue, ProducerModel newValue) {
                if (newValue != null) {
                    System.out.println("" + newValue.ProducerCode + " " + newValue.ProducerName);
                    open_form("" + newValue.ProducerCode);
                }
            }
        });
    }
}
