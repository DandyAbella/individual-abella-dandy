package com.joysistvi.day16.oop;

public class Main {
    public static void main(String[] args) {
        //Class Instantiation > create an object
        Laptop laptop = new Laptop();
        laptop.brand = "HP";
        laptop.color = "Black";
        laptop.weight = 2;
        laptop.cpu = "i5";
        laptop.ram = 32;

        laptop.sendMessages();
        laptop.creatDocuments();
        laptop.transferFiles();
        laptop.browseInternet();

        System.out.println(laptop);
        System.out.println(laptop.ram);

        Laptop laptop1 = new Laptop();
        laptop1.brand = "Lenovo";
        laptop1.color = "white";
        laptop1.weight = 3;
        laptop1.cpu = "i9";
        laptop1.ram = 32;

        laptop1.sendMessages();
        laptop1.creatDocuments();
        laptop1.transferFiles();
        laptop1.browseInternet();

        Laptop laptop2 = new Laptop();
        laptop2.brand = "Asus";
        laptop2.color = "Brown";
        laptop2.weight = 2;
        laptop2.cpu = "i7";
        laptop2.ram = 16;

        laptop2.sendMessages();
        laptop2.creatDocuments();


    }//psvm

}//pcM
