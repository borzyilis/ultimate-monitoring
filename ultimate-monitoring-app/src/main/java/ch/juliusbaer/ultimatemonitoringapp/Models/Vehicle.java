package ch.juliusbaer.ultimatemonitoringapp.Models;

public class Vehicle {

    private int id;
    private String uid;
    private String vin;
    private String make_and_model;
    private String color;
    private String transmission;
    private String drive_type;
    private String fuel_type;
    private String car_type;
    private String[] car_options;
    private String[] specs;
    private int doors;
    private int mileage;
    private int kilometrage;
    private String license_plate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake_and_model() {
        return make_and_model;
    }

    public void setMake_and_model(String make_and_model) {
        this.make_and_model = make_and_model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive_type() {
        return drive_type;
    }

    public void setDrive_type(String drive_type) {
        this.drive_type = drive_type;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String[] getCar_options() {
        return car_options;
    }

    public void setCar_options(String[] car_options) {
        this.car_options = car_options;
    }

    public String[] getSpecs() {
        return specs;
    }

    public void setSpecs(String[] specs) {
        this.specs = specs;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }
}
