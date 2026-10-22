package com.joysistvi.day8.conditions;

public class switchStatement {
    public static void main(String[] args) {


        int day = 7;
        String dayName="";

        switch (day) {
            case 1:
                dayName = "monday";
                break;
            case 2:
                dayName = "tuesday";
                break;
            case 3:
                dayName = "wednesday";
                break;
            case 4:
                dayName = "thursday";
                break;
            case 5:
                dayName = "friday";
                break;
            case 6:
                dayName = "saturday";
                break;
            case 7:
                dayName = "sunday";
                break;
            default:
        }
        System.out.println ("Today is: " + dayName);
    }
}
