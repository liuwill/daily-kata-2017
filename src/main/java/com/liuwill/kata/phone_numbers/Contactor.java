package com.liuwill.kata.phone_numbers;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class Contactor {
    private String name;
    private String phone;

    public Contactor(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
