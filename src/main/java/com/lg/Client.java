package com.lg;

import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable {
    private String name;
    private String surname;
    private String PESEL; //sprawdzać spójność PESEL z datą?
    private String address;
    private transient LocalDate dateOfBirth;
    private boolean discount;

    public Client(String name, String surname, String PESEL, String address, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.discount = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public void show(){
        System.out.println(this.name+" "+this.surname+" PESEL: "+this.PESEL+" born on "+this.dateOfBirth.toString()+" addr: "+this.address);
    }

    public String clientToString(){
        String client = this.name+" "+this.surname+" PESEL: "+this.PESEL+" born on "+this.dateOfBirth.toString()+" addr: "+this.address;
        if (this.discount) {
            client += " discount: YES";
        }
        else {
            client += " discount: NO";
        }
        return client;
    }
}
