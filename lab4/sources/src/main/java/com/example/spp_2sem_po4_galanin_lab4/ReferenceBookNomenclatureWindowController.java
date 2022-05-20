package com.example.spp_2sem_po4_galanin_lab4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ReferenceBookNomenclatureWindowController implements Initializable {
    @FXML protected TextField text_field_id;
    @FXML protected TextField text_field_name;
    @FXML protected TableView<ReferenceBookNomenclatureModel> table_view;
    @FXML protected TableColumn<ReferenceBookNomenclatureModel, Integer> table_column_id;
    @FXML protected TableColumn<ReferenceBookNomenclatureModel, String> table_column_name;

    @FXML protected void button_create_clicked() {
        String sql = "INSERT INTO \"RM_Nomenclature\" (name) VALUES (\"" + text_field_name.getText() + "\");";
        Database.execute_sql_query(sql);
        button_read_clicked();
    }

    /*@FXML*/ protected void button_read_clicked() {
        try {
            ObservableList<ReferenceBookNomenclatureModel> nomenclature_list = get_nomenclature_list();
            table_column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            table_column_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            table_view.setItems(nomenclature_list);
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @FXML protected void button_update_clicked() {
        String sql = "UPDATE \"RM_Nomenclature\" SET name = \"" + text_field_name.getText() + "\" WHERE id = \"" + text_field_id.getText() + "\";";
        Database.execute_sql_query(sql);
        button_read_clicked();
    }

    @FXML protected void button_delete_clicked() {
        String sql = "DELETE FROM \"RM_Nomenclature\" WHERE id = \"" + text_field_id.getText() + "\";";
        Database.execute_sql_query(sql);
        button_read_clicked();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button_read_clicked();
        TableView.TableViewSelectionModel<ReferenceBookNomenclatureModel> selectionModel = table_view.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<ReferenceBookNomenclatureModel>() {
            @Override
            public void changed(ObservableValue<? extends ReferenceBookNomenclatureModel> observableValue, ReferenceBookNomenclatureModel oldValue, ReferenceBookNomenclatureModel newValue) {
                if (newValue != null) {
                    System.out.println("" + newValue.id + " " + newValue.name);
                    text_field_id.setText("" + newValue.id);
                    text_field_name.setText(newValue.name);
                }
            }
        });
    }

    protected ObservableList<ReferenceBookNomenclatureModel> get_nomenclature_list() {
        ObservableList<ReferenceBookNomenclatureModel> nomenclature_list = FXCollections.observableArrayList();
        Connection connection = Database.get_connect_to_database();

        try {
            String sql = "SELECT * FROM RM_Nomenclature;";
            Statement statement = connection != null ? connection.createStatement() : null;

            ResultSet result_set = statement != null ? statement.executeQuery(sql) : null;

            if (result_set == null) {
                return null;
            }
            ReferenceBookNomenclatureModel Nomenclature;
            while(result_set.next()) {
                Nomenclature = new ReferenceBookNomenclatureModel(
                        result_set.getInt("id"),
                        result_set.getString("name")
                );
                nomenclature_list.add(Nomenclature);
            }
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

        return nomenclature_list;
    }
}
