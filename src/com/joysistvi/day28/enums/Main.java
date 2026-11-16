package com.joysistvi.day28.enums;

public class Main {

    public static void main(String[] args) {
        //accessing an enum value
//        System.out.println(Day.MONDAY.ordinal());
//        System.out.println(Day.TUESDAY.ordinal());

        Day day = Day.SUNDAY;
        switch (day) { //modern switch
            case SUNDAY -> System.out.println(Day.MONDAY);
            case TUESDAY -> System.out.println(Day.TUESDAY);
        }

        Day day1 = Day.MONDAY;
        switch (day1) {
            case MONDAY:
                System.out.println(Day.SUNDAY);
                case TUESDAY:
                    System.out.println(Day.TUESDAY);
        }

    }
}
