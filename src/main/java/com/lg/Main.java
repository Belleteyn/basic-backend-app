package com.lg;

//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args)  {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String todaysDate = "20 05 2022";
        LocalDate firstDate = LocalDate.parse(todaysDate, formatter);
        LocalDate birthDate;
        long age;

        ArrayList<Client> clients = Client.clientGenerator();
        ArrayList<Client> discountedClients = new ArrayList<>();

        for (Client c : clients) {
            c.show();
            birthDate = c.getDateOfBirth();
            age = ChronoUnit.YEARS.between(birthDate, firstDate);
            System.out.println("Age: "+ age);
            if(age >=18 && age <=26 ){
                c.setDiscount(true); //gives discount to client
                discountedClients.add(c); //adds to another array list from which we write to JSON.
                // this way, there is 1 loop and we write to json once.
            }
        }
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



}
