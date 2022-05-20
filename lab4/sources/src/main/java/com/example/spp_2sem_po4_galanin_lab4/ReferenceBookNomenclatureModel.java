package com.example.spp_2sem_po4_galanin_lab4;

public class ReferenceBookNomenclatureModel {
    protected Integer id;
    protected String name;

    public ReferenceBookNomenclatureModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public ReferenceBookNomenclatureModel(String name) {
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
