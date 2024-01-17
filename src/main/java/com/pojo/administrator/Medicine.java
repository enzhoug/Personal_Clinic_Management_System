package com.pojo.administrator;

public class Medicine {
    private int id;
    private String medicinename;
    private double medicineprice;
    private int medicineinventory;
    private String medicinesupplier;
    private String medicineintroduce;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMedicinename() {
        return medicinename;
    }
    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }
    public double getMedicineprice() {
        return medicineprice;
    }
    public void setMedicineprice(double medicineprice) {
        this.medicineprice = medicineprice;
    }
    public int getMedicineinventory() {
        return medicineinventory;
    }
    public void setMedicineinventory(int medicineinventory) {
        this.medicineinventory = medicineinventory;
    }
    public String getMedicinesupplier() {
        return medicinesupplier;
    }
    public void setMedicinesupplier(String medicinesupplier) {
        this.medicinesupplier = medicinesupplier;
    }
    public String getMedicineintroduce() {
        return medicineintroduce;
    }
    public void setMedicineintroduce(String medicineintroduce) {
        this.medicineintroduce = medicineintroduce;
    }
    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", medicinename='" + medicinename + '\'' +
                ", medicineprice=" + medicineprice +
                ", medicineinventory=" + medicineinventory +
                ", medicinesupplier='" + medicinesupplier + '\'' +
                ", medicineintroduce='" + medicineintroduce + '\'' +
                '}';
    }
}
