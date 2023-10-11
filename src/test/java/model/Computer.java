package model;

public class Computer {
    private String hardDrive;
    private String CPU;
    private String RAM;
    private String motherBoard;
    private String videoAdapter;
    private String networkAdapter;
    private String manufacturer;

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public String getVideoAdapter() {
        return videoAdapter;
    }

    public void setVideoAdapter(String videoAdapter) {
        this.videoAdapter = videoAdapter;
    }

    public String getNetworkAdapter() {
        return networkAdapter;
    }

    public void setNetworkAdapter(String networkAdapter) {
        this.networkAdapter = networkAdapter;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void displayComputerMainParameters() {
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("CPU: " + CPU);
        System.out.println("Mother Board: " + manufacturer);
        System.out.println("RAM: " + RAM);
    }
}

//2 custom methods
//create class with @Test, create class, fill data,
//у нас есть машина паравоз и самолет
//есть маршрут из точки А в точку Б
//используя объкты нам необходимо прописать характеристики всех ТС
//и прописать характеритики маршрута
//вывести в консоль информацию о количестве топлива каждому виду транспорта для преодоления каждого маршрута
