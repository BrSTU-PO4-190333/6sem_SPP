package com.example.spp_2sem_po4_galanin_lab4;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProducerFormController {
    @FXML
    protected TextField TextField__ProducerCode;

    @FXML
    protected TextField TextField__ProducerName;

    @FXML
    protected Button Button__create;

    @FXML
    protected Button Button__read;

    @FXML
    protected Button Button__update;

    @FXML
    protected Button Button__delete;

    public void initData(String ProducerCode) {
        try {
            TextField__ProducerCode.setText(ProducerCode);

            if(ProducerCode == "0") {
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
        String sql = ProducerModel.get_CREATE_sql(TextField__ProducerName.getText());
        Database.execute_sql_query(sql);
    }

    @FXML
    protected void Button_read_clicked() {
        ObservableList<ReferenceBookNomenclatureModel> nomenclature_list = FXCollections.observableArrayList();
        Connection connection = Database.get_connect_to_database();

        try {
            String sql = ProducerModel.get_READ_sql(TextField__ProducerCode.getText());
            Statement statement = connection != null ? connection.createStatement() : null;

            ResultSet result_set = statement != null ? statement.executeQuery(sql) : null;

            if (result_set == null) {
                return;
            }
            ReferenceBookNomenclatureModel Nomenclature;
            while(result_set.next()) {
                //Nomenclature = new ReferenceBookNomenclatureModel(
                //        result_set.getInt("id"),
                //        result_set.getString("name")
                //);
                //nomenclature_list.add(Nomenclature);
                TextField__ProducerCode.setText("" + result_set.getInt("ProducerCode"));
                TextField__ProducerName.setText(result_set.getString("ProducerName"));
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML
    protected void Button_update_clicked() {
        String sql = ProducerModel.get_UPDATE_sql(TextField__ProducerCode.getText(), TextField__ProducerName.getText());
        Database.execute_sql_query(sql);
    }

    @FXML
    protected void Button_delete_clicked() {
        String sql = ProducerModel.get_DELETE_sql(TextField__ProducerCode.getText());
        Database.execute_sql_query(sql);
    }
}
