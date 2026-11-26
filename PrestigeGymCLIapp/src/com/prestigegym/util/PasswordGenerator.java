package com.prestigegym.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordGenerator {

    public static void main(String[] args) {

        String hash = BCrypt.hashpw("1234", BCrypt.gensalt());

        System.out.println(hash);
    }
}