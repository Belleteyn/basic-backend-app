package com.lg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("Projekt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String todaysDate = "20 05 2022";
        String birthDate = "09 11 2000";
        LocalDate firstDate = LocalDate.parse(todaysDate, formatter);
        LocalDate secondDate = LocalDate.parse(birthDate, formatter);
        long days = ChronoUnit.YEARS.between(secondDate, firstDate);
        System.out.println("Years between " + birthDate + " and " + todaysDate + " : " + days);
    }
}
