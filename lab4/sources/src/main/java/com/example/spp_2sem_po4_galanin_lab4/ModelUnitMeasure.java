package com.example.spp_2sem_po4_galanin_lab4;

public class ModelUnitMeasure {
    protected Integer UnitMeasureCode;
    protected String UnitMeasureName;

    public ModelUnitMeasure(Integer UnitMeasureCode, String UnitMeasureName) {
        this.UnitMeasureCode = UnitMeasureCode;
        this.UnitMeasureName = UnitMeasureName;
    }

    public Integer getUnitMeasureCode() {
        return UnitMeasureCode;
    }

    public String getUnitMeasureName() {
        return UnitMeasureName;
    }

    public static String get_CREATE_TABLE_sql() {
        return "CREATE TABLE IF NOT EXISTS \"catalog__UnitMeasure\" (UnitMeasureCode integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, UnitMeasureName text);";
    }

    public static String get_CREATE_sql(String UnitMeasureName) {
        return "INSERT INTO \"catalog__UnitMeasure\" (UnitMeasureName) VALUES (\"" + UnitMeasureName +  "\");";
    }

    public static String get_READ_sql(String UnitMeasureCode) {
        return "SELECT * FROM \"catalog__UnitMeasure\" WHERE UnitMeasureCode = \"" + UnitMeasureCode + "\";";
    }

    public static String get_UPDATE_sql(String UnitMeasureCode, String UnitMeasureName) {
        return "UPDATE \"catalog__UnitMeasure\" SET UnitMeasureName = \"" + UnitMeasureName + "\" WHERE UnitMeasureCode = \"" + UnitMeasureCode + "\";";
    }

    public static String get_DELETE_sql(String UnitMeasureCode) {
        return "DELETE FROM \"catalog__UnitMeasure\" WHERE UnitMeasureCode = \"" + UnitMeasureCode + "\";";
    }
}
