package com.example.goroster.emp;

public class Employee {
    private int id;
    private String name;
    // for login
    private String email;
    private String password;
    private int phone;
    // roster information
    private String monAvailable;
    private String tueAvailable;
    private String webAvailable;
    private String thuAvailable;
    private String friAvailable;
    private String satAvailable;
    private String sunAvailable;

    public Employee() {
    }

    public Employee(String name, String monAvailable, String tueAvailable, String webAvailable, String thuAvailable, String friAvailable, String satAvailable, String sunAvailable) {
        this.name = name;
        this.monAvailable = monAvailable;
        this.tueAvailable = tueAvailable;
        this.webAvailable = webAvailable;
        this.thuAvailable = thuAvailable;
        this.friAvailable = friAvailable;
        this.satAvailable = satAvailable;
        this.sunAvailable = sunAvailable;
    }

    public Employee(int id, String name, String monAvailable, String tueAvailable, String webAvailable, String thuAvailable, String friAvailable, String satAvailable, String sunAvailable) {
        this.id = id;
        this.name = name;
        this.monAvailable = monAvailable;
        this.tueAvailable = tueAvailable;
        this.webAvailable = webAvailable;
        this.thuAvailable = thuAvailable;
        this.friAvailable = friAvailable;
        this.satAvailable = satAvailable;
        this.sunAvailable = sunAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonAvailable() {
        return monAvailable;
    }

    public void setMonAvailable(String monAvailable) {
        this.monAvailable = monAvailable;
    }

    public String getTueAvailable() {
        return tueAvailable;
    }

    public void setTueAvailable(String tueAvailable) {
        this.tueAvailable = tueAvailable;
    }

    public String getWebAvailable() {
        return webAvailable;
    }

    public void setWebAvailable(String webAvailable) {
        this.webAvailable = webAvailable;
    }

    public String getThuAvailable() {
        return thuAvailable;
    }

    public void setThuAvailable(String thuAvailable) {
        this.thuAvailable = thuAvailable;
    }

    public String getFriAvailable() {
        return friAvailable;
    }

    public void setFriAvailable(String friAvailable) {
        this.friAvailable = friAvailable;
    }

    public String getSatAvailable() {
        return satAvailable;
    }

    public void setSatAvailable(String satAvailable) {
        this.satAvailable = satAvailable;
    }

    public String getSunAvailable() {
        return sunAvailable;
    }

    public void setSunAvailable(String sunAvailable) {
        this.sunAvailable = sunAvailable;
    }
}
