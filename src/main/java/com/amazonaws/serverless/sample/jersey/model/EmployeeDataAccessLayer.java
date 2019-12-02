package com.amazonaws.serverless.sample.jersey.model;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeDataAccessLayer {
    private static List<String> names = new ArrayList<String>();
    static {
        names.add("Afghan Hound");
        names.add("Beagle");
        names.add("Bernese Mountain Dog");
        names.add("Bloodhound");
        names.add("Dalmatian");
        names.add("Jack Russell Terrier");
        names.add("Norwegian Elkhound");
    }

    private static List<String> username = new ArrayList<String>();
    static {
        username.add("Bailey");
        username.add("Bella");
        username.add("Max");
        username.add("Lucy");
        username.add("Charlie");
        username.add("Molly");
        username.add("Buddy");
        username.add("Daisy");
        username.add("Rocky");
        username.add("Maggie");
        username.add("Jake");
        username.add("Sophie");
        username.add("Jack");
        username.add("Sadie");
        username.add("Toby");
        username.add("Chloe");
        username.add("Cody");
        username.add("Bailey");
        username.add("Buster");
        username.add("Lola");
        username.add("Duke");
        username.add("Zoe");
        username.add("Cooper");
        username.add("Abby");
        username.add("Riley");
        username.add("Ginger");
        username.add("Harley");
        username.add("Roxy");
        username.add("Bear");
        username.add("Gracie");
        username.add("Tucker");
        username.add("Coco");
        username.add("Murphy");
        username.add("Sasha");
        username.add("Lucky");
        username.add("Lily");
        username.add("Oliver");
        username.add("Angel");
        username.add("Sam");
        username.add("Princess");
        username.add("Oscar");
        username.add("Emma");
        username.add("Teddy");
        username.add("Annie");
        username.add("Winston");
        username.add("Rosie");
    }

    public static List<String> getBreeds() {
        return names;
    }

    public static List<String> getNames() {
        return username;
    }

    public static String getRandomBreed() {
        return names.get(ThreadLocalRandom.current().nextInt(0, names.size() - 1));
    }

    public static String getRandomName() {
        return username.get(ThreadLocalRandom.current().nextInt(0, username.size() - 1));
    }

    public static Date getRandomDoB() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = ThreadLocalRandom.current().nextInt(
                Calendar.getInstance().get(Calendar.YEAR) - 15,
                Calendar.getInstance().get(Calendar.YEAR)
        );

        gc.set(Calendar.YEAR, year);

        int dayOfYear = ThreadLocalRandom.current().nextInt(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        return gc.getTime();
    }
}
