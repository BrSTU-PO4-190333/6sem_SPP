package com.example.spp_2sem_po4_galanin_lab4;

public class ModelProducer {
    protected Integer ProducerCode;
    protected String ProducerName;

    public ModelProducer(Integer ProducerCode, String ProducerName) {
        this.ProducerCode = ProducerCode;
        this.ProducerName = ProducerName;
    }

    public Integer getProducerCode() {
        return ProducerCode;
    }

    public String getProducerName() {
        return ProducerName;
    }

    public static String get_CREATE_TABLE_sql() {
        return "CREATE TABLE IF NOT EXISTS \"catalog__producer\" (ProducerCode integer NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ProducerName text);";
    }

    public static String get_CREATE_sql(String ProducerName) {
        return "INSERT INTO \"catalog__producer\" (ProducerName) VALUES (\"" + ProducerName +  "\");";
    }

    public static String get_READ_sql(String ProducerCode) {
        return "SELECT * FROM \"catalog__producer\" WHERE ProducerCode = \"" + ProducerCode + "\";";
    }

    public static String get_UPDATE_sql(String ProducerCode, String ProducerName) {
        return "UPDATE \"catalog__producer\" SET ProducerName = \"" + ProducerName + "\" WHERE ProducerCode = \"" + ProducerCode + "\";";
    }

    public static String get_DELETE_sql(String ProducerCode) {
        return "DELETE FROM \"catalog__producer\" WHERE ProducerCode = \"" + ProducerCode + "\";";
    }
}
