package com.lg;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args)  {

        ArrayList<Client> discountedClients = giveDiscounts(); //returns list of clients who were given discounts

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("target/discounted.json"), discountedClients); //writes to file
            String json = mapper.writeValueAsString(discountedClients); //writes json as string
            System.out.println("JSON = " + json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

public static ArrayList<Client> giveDiscounts(){
//gives discounts to clients aged 18-26 and adds them to an array. returns that array.
    LocalDate todaysDate = LocalDate.now();
    LocalDate birthDate;
    long age;

    ArrayList<Client> clients = Client.clientGenerator();
    ArrayList<Client> discountedClients = new ArrayList<>();


    for (Client c : clients) {
        c.show();
        birthDate = c.getDateOfBirth();
        age = ChronoUnit.YEARS.between(birthDate, todaysDate); //calculates client's age based on his birthDate and todaysDate
        System.out.println("Age: "+ age);
        if(age >=18 && age <=26 ){
            c.setDiscount(true); //gives discount to client
            discountedClients.add(c); //adds to another array list from which we write to JSON.
            // this way, there is 1 loop and we write to json once.
        }
    }

    return discountedClients;
}

}
