package com.tony.dayone_database;

public class Users {

    private  String name, county, phone, age, email, pass, confrimpass;

    public Users() {
    }

    public Users(String name, String county, String phone, String age, String email, String pass, String confrimpass) {
        this.name = name;
        this.county = county;
        this.phone = phone;
        this.age = age;
        this.email = email;
        this.pass = pass;
        this.confrimpass = confrimpass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getConfrimpass() {
        return confrimpass;
    }

    public void setConfrimpass(String confrimpass) {
        this.confrimpass = confrimpass;
    }
}
