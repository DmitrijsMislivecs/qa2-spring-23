package model;

import java.util.Date;

public class Beer {
    private String manufacturer;
    private String name;
    private String type;
    private float volume;
    private String tare;
    private int alcohol;
    private Date bestBeforeDate;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public String getTare() {
        return tare;
    }

    public void setTare(String tare) {
        this.tare = tare;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(int alcohol) {
        this.alcohol = alcohol;
    }

    public Date getBestBeforeDate() {
        return bestBeforeDate;
    }

    public void setBestBeforeDate(Date bestBeforeDate) {
        this.bestBeforeDate = bestBeforeDate;
    }

    public void showBeerInformation() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Beer name: " + name);
        System.out.println("Beer type: " + type);
        System.out.println("Volume: " + volume);
        System.out.println("Tare type: " + tare);
        System.out.println("Alcohol %: " + alcohol);
        System.out.println("Best Before date: " + bestBeforeDate);
    }
}
