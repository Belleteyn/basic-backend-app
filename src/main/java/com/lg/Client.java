package com.lg;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Client implements Serializable {
    private String name;
    private String surname;
    private String PESEL;
    private String address;
    @JsonSerialize(using = LocalDateSerializer.class) //needed to serialize data correctly
    private LocalDate dateOfBirth;
    private boolean discount;

    public Client(String name, String surname, String PESEL, String address, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.PESEL = PESEL;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.discount = false; //by default, clients do not have any discounts
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
        System.out.println(this.name+" "+this.surname+" PESEL: "+this.PESEL+" dateOfBirth: "+this.dateOfBirth.toString()+" address: "+this.address);
    }
    /* //not needed
    @Override
    public String toString(){
        String client = "name: '"+this.name+"', surname: '"+this.surname+"', PESEL: '"+this.PESEL+"', dateOfBirth: '"+this.dateOfBirth.toString()+"', address: '"+this.address;
        if (this.discount) {
            client += "', discount: 'true'";
        }
        else {
            client += "', discount: 'false'";
        }
        return client;
    }

     */

    public static ArrayList<Client> clientGenerator(){
        //generates clients for testing the app
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Wendy", "Byrde", "68041724842", "Lublin, ul. Nadbystrzycka 24", LocalDate.parse("17 04 1968",formatter)));
        clients.add(new Client("Charlotte", "Byrde", "01280443882", "Lublin, ul. Nadbystrzycka 24", LocalDate.parse("04 08 2001",formatter)));
        clients.add(new Client("Ruth", "Langmore", "05232541543", "Lublin, ul. Wigilina 15", LocalDate.parse("25 03 2005",formatter)));
        clients.add(new Client("Marthy", "Byrde", "95013069155", "Lublin, ul. Warszawska 7", LocalDate.parse("30 01 1995",formatter)));
        clients.add(new Client("Camino", "Del Rio", "97112374213", "Lublin, ul. Wiejska 12", LocalDate.parse("23 11 1997",formatter)));
        return clients;
    }

}
