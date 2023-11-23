package com.zafar.javapractice.arrays;

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {

        String weekdays[] = new String[4];
        System.out.println(Arrays.toString(weekdays));
        weekdays[0] = "Monday";
        weekdays[1] = "Tuesday";
        weekdays[2] = "Wednesday";
        weekdays[3] = "Thursday";

        ArraysExample ae = new ArraysExample();
        ae.makeUpperCase(weekdays);


        System.out.println(Arrays.toString(weekdays));
    }

    public  void makeUpperCase(String[] weekdays) {
        for (int i = 0; i < weekdays.length; i++) {
            weekdays[i] = weekdays[i].toUpperCase();
        }
    }
}
