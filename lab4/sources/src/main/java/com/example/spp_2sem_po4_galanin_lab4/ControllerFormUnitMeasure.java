package com.example.spp_2sem_po4_galanin_lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ControllerFormUnitMeasure {
    @FXML
    protected TextField TextField__UnitMeasureCode;

    @FXML
    protected TextField TextField__UnitMeasureName;

    @FXML
    protected Button Button__create;

    @FXML
    protected Button Button__read;

    @FXML
    protected Button Button__update;

    @FXML
    protected Button Button__delete;

    public void initData(String UnitMeasureCode) {
        try {
            TextField__UnitMeasureCode.setText(UnitMeasureCode);

            if(UnitMeasureCode == "0") {
                Button__create.setDisable(false);
                Button__read.setDisable(true);
                Button__update.setDisable(true);
                Button__delete.setDisable(true);
            }

            Button_read_clicked();
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
    }

    @FXML
    protected void Button_create_clicked() {
        String sql = ModelUnitMeasure.get_CREATE_sql(TextField__UnitMeasureName.getText());
        Database.execute_sql_query(sql);
    }

    @FXML
    protected void Button_read_clicked() {
        ObservableList<ModelUnitMeasure> nomenclature_list = FXCollections.observableArrayList();
        Connection connection = Database.get_connect_to_database();

        try {
            String sql = ModelUnitMeasure.get_READ_sql(TextField__UnitMeasureCode.getText());
            Statement statement = connection != null ? connection.createStatement() : null;

            ResultSet result_set = statement != null ? statement.executeQuery(sql) : null;

            if (result_set == null) {
                return;
            }

            while(result_set.next()) {
                TextField__UnitMeasureCode.setText("" + result_set.getInt("UnitMeasureCode"));
                TextField__UnitMeasureName.setText(result_set.getString("UnitMeasureName"));
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    protected void Button_update_clicked() {
        String sql = ModelUnitMeasure.get_UPDATE_sql(TextField__UnitMeasureCode.getText(), TextField__UnitMeasureName.getText());
        Database.execute_sql_query(sql);
    }

    @FXML
    protected void Button_delete_clicked() {
        String sql = ModelUnitMeasure.get_DELETE_sql(TextField__UnitMeasureCode.getText());
        Database.execute_sql_query(sql);
    }
}
