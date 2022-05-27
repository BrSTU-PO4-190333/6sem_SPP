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

public class ControllerTableUnitMeasure implements Initializable {
    @FXML
    protected TableView<ModelUnitMeasure> TableView__UnitMeasureModel;

    @FXML
    protected TableColumn<ModelUnitMeasure, Integer> TableColumn__UnitMeasureCode;

    @FXML
    protected TableColumn<ModelUnitMeasure, String> TableColumn__UnitMeasureName;

    @FXML
    protected TextField TextField__UnitMeasureCode_filter;

    @FXML
    protected TextField TextField__UnitMeasureName_filter;

    @FXML
    protected void Button__add_UnitMeasureModel_clicked() {
        open_form("0");
    }

    protected void open_form(String id) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    ControllerTableUnitMeasure.class.getResource(
                            "View-Form-UnitMeasure.fxml"
                    )
            );

            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Форма справочника \"Производители\"");
            stage.setScene(scene);

            ControllerFormUnitMeasure controller = fxmlLoader.getController();
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
    protected void Button__refresh_UnitMeasure_table_clicked() {
        try {
            ObservableList<ModelUnitMeasure> list = get_list();

            TableColumn__UnitMeasureCode.setCellValueFactory(new PropertyValueFactory<>("UnitMeasureCode"));
            TableColumn__UnitMeasureName.setCellValueFactory(new PropertyValueFactory<>("UnitMeasureName"));

            TableView__UnitMeasureModel.setItems(list);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    protected ObservableList<ModelUnitMeasure> get_list() {
        ObservableList<ModelUnitMeasure> list = FXCollections.observableArrayList();
        Connection connection = Database.get_connect_to_database();

        try {
            String sql = "SELECT * FROM \"catalog__UnitMeasure\"\n" +
                    "WHERE\n" +
                    "(\n" +
                    "\tUnitMeasureCode LIKE \"" + TextField__UnitMeasureCode_filter.getText() + "%\"\n" +
                    "\tAND\n" +
                    "\tUnitMeasureName LIKE \"" + TextField__UnitMeasureName_filter.getText() + "%\"\n" +
                    ");";
            System.out.println(sql);
            Statement statement = connection != null ? connection.createStatement() : null;

            ResultSet result_set = statement != null ? statement.executeQuery(sql) : null;

            if (result_set == null) {
                return null;
            }
            ModelUnitMeasure model;
            while(result_set.next()) {
                model = new ModelUnitMeasure(
                        result_set.getInt("UnitMeasureCode"),
                        result_set.getString("UnitMeasureName")
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
        Button__refresh_UnitMeasure_table_clicked();

        TableView.TableViewSelectionModel<ModelUnitMeasure> selectionModel = TableView__UnitMeasureModel.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<ModelUnitMeasure>() {
            @Override
            public void changed(ObservableValue<? extends ModelUnitMeasure> observableValue, ModelUnitMeasure oldValue, ModelUnitMeasure newValue) {
                if (newValue != null) {
                    System.out.println("" + newValue.UnitMeasureCode + " " + newValue.UnitMeasureName);
                    open_form("" + newValue.UnitMeasureCode);
                }
            }
        });
    }
}
