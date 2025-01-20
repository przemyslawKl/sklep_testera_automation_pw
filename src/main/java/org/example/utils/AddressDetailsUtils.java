package org.example.utils;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Random;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressDetailsUtils {

    public static String getRandomAddress() {
        return new Faker().address().fullAddress();
    }

    public static String getRandomCompanyName() {
        return new Faker().company().name();
    }
    public static String getRandomPostalCode() {
        Random rand = new Random();
        int number = rand.nextInt(90000) + 10000; // generates a 5-digit number between 10000 and 99999
        return String.format("%s-%s", String.valueOf(number).substring(0, 2), String.valueOf(number).substring(2));
    }

    public static String getRandomCity() {
        return new Faker().address().city();
    }

    public static long getRandomPhoneNumber() {
        return new Faker().number().numberBetween(10000000L, 99999999L);
    }

    public static long getRandomVatNumber() {
        return new Faker().number().numberBetween(100000000000L, 999999999999L);
    }

}
