package com.liuwill.kata.phone_numbers;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Liu Will on 2017/6/14.
 */
public class Contactor implements Comparable<Contactor>{
    private String name;
    private String phone;
    private String id;

    public Contactor(String name, String phone) {
        this.name = name;
        this.phone = phone;

        id = name+":"+phone;
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

    @Override
    public int compareTo(@NotNull Contactor o) {
        if(phone.length() > o.phone.length()){
            return 1;
        }else if(phone.length() < o.phone.length()){
            return -1;
        }
        return 0;
    }

    public String toString(){
        return "Contact [name:"+name+" - phone:"+phone+"]";
    }

    public boolean equals(Object o){
        if (!(o instanceof Contactor) || o == null)
            return false;
        Contactor fieldPosition = (Contactor) o;

        if(!fieldPosition.id.equals(this.id)){
            return false;
        }
        return true;
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
