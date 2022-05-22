package com.lg;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //System.out.println("Projekt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String todaysDate = "20 05 2022";
        String birthDate = "09 11 2000";
        LocalDate firstDate = LocalDate.parse(todaysDate, formatter);
        LocalDate secondDate = LocalDate.parse(birthDate, formatter);
        long age = ChronoUnit.YEARS.between(secondDate, firstDate);
        System.out.println("Years between " + birthDate + " and " + todaysDate + " : " + age);

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Wendy", "Byrde", "68041724842", "Lublin, ul. Nadbystrzycka 24", LocalDate.parse("17 04 1968",formatter)));
        clients.add(new Client("Charlotte", "Byrde", "01280443882", "Lublin, ul. Nadbystrzycka 24", LocalDate.parse("04 08 2001",formatter)));
        clients.add(new Client("Ruth", "Langmore", "05232541543", "Lublin, ul. Wigilina 15", LocalDate.parse("25 03 2005",formatter)));
        clients.add(new Client("Marthy", "Byrde", "95013069155", "Lublin, ul. Warszawska 7", LocalDate.parse("30 01 1995",formatter)));
        clients.add(new Client("Camino", "Del Rio", "97112374213", "Lublin, ul. Wiejska 12", LocalDate.parse("23 11 1997",formatter)));
        //clients.add(new Client("Wendy", "Byrde", "68041724842", "Lublin, ul. Nadbystrzycka 24", LocalDate.parse("17 04 1968",formatter)));


        Iterator iter = clients.iterator();
        for (Client c : clients) {
            c.show();
            secondDate = c.getDateOfBirth();
            age = ChronoUnit.YEARS.between(secondDate, firstDate);
            System.out.println(age);
            if(age >=18 && age <=26 ){
                c.setDiscount(true);
            }

            //System.out.println(iter.next());
        }
        System.out.println("PROMO!");
        for (Client c : clients) {
            if(c.isDiscount()){
                c.show();

            }
        }

        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        fileOutputStream
                = new FileOutputStream("yourfile.txt");
        objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(clients.get(4));
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream
                = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        Client odczytany = (Client) objectInputStream.readObject();
        objectInputStream.close();

        if(odczytany.getPESEL() == clients.get(4).getPESEL()) {
            System.out.println("tacy sami");
        }
        else {
            System.out.println("nie");
        }
        //assertTrue(odczytany.getName().equals(person.getName()));
    }

    private static void assertTrue(boolean b) {
    }
}
