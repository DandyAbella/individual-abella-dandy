package com.joysistvi.day14.string;

public class Activity10_Abella {
    public static void main(String[] args) {

        //contains() - checks if a string contains a specified sequence of characters.
        // returns true or false, it is a case sensitive

        String helloworld = "Hello World";
        System.out.println(helloworld.contains("World"));

        //endsWith() - checks if a string ends with a specific suffix
        // returns true or false, it is a case sensitive

        String fileName = "fileName.java";
        System.out.println(fileName.endsWith(".java"));

        //startWith() - checks if a string starts with a specific prefix
        // returns true or false, it is a case sensitive

        String website = "https://joysis.edu";
        System.out.println(website.startsWith("htt"));

        //indexOf() - returns the position (index) of the first occurrence of a character or substring
        //returns -1 if not found, white spaces not included in the count

        String movie = "pirates of the carrebean";
        System.out.println(movie.indexOf("o"));

        //trim() - removes leading and tailing spaces from a string

        String phrase = "               hello           world    dddd";
        System.out.println(phrase.trim());

        //replace() - replaces all occurrences of a specified character or string with another

        String message = "hello World, welcome";
        System.out.println(message.replace("World","students"));

        //toCharArray() - converts a string into an array of characters

        String myname = "Dandy";
        char[] letters = myname.toCharArray();
        for (char ch : letters) {
            System.out.println(ch);
        }

        //presentation phase
        //method: contains()
        //checks whether  a string contains a specific sequence of characters
        //it returns true if the sequence exists and false otherwise

        String qoutes = "Love is composed of a single soul inhabiting two bodies. — Aristotle";
        if (qoutes.contains("Love")) {
            System.out.println("yes, Love found");
        } else {
            System.out.println("no, love not found");
        }

        String country = "Philippines";
        //Display the first and last character of the string.
        char firstChar = country.charAt(0);
        char lastChar = country.charAt(country.length() - 1);
        System.out.println("firt character of " + country + " is: " + firstChar);
        System.out.println("last character of " + country + " is: " + lastChar);

        //Count and display how many times the character "P/p" appears in the string.
        int pcount = 0;
        for (int i = 0; i < country.length(); i++) {
            char pnum = country.charAt(i);
            if (pnum == 'p' || pnum == 'P') {
                pcount++;
            }
        }
        System.out.println("Number of P/p: " + pcount);

        //Count and display the total number of vowels (a, e, i, o, u) in the string.
        int vowelnum = 0;
        for (int j = 0; j < country.length(); j++) {
            char ch = Character.toLowerCase(country.charAt(j));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelnum++;
            }
        }
        System.out.println("Total vowels: " + vowelnum);





    }
}
