package com.example.goroster.emp;

public class Employee {
    private String id;
    private String name;
    // for login
    private String email;
    private String password;
    private String phone;
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

// only this constructor for create employee used to sign up
    public Employee(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
