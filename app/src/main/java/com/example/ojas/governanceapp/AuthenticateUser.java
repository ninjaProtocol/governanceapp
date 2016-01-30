package com.example.ojas.governanceapp;

/**
 * Created by Ojas on 22-01-2016.
 */

import org.apache.commons.codec.digest.DigestUtils;

public class AuthenticateUser {

    private short ERRORLEVEL;

    AuthenticateUser(String plainTextEmail, String plainTextPassword) {

        //authentication should be server side
        String mock_userEmail = "admin@iora.com";
        //String mock_userPassword = "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8"; // SHA1 of "password"
        String mock_userPassword = "password";

        //calculate checksum and transmit to server for auth
        //String passwordHash = DigestUtils.sha1Hex(plainTextPassword);

        //send checksum to server for validation and set ERRORLEVEL (default 3)
        ERRORLEVEL = 3; //Exception
        if (plainTextEmail.equalsIgnoreCase(mock_userEmail)) {
            if (mock_userPassword.equalsIgnoreCase(plainTextPassword)) {
                ERRORLEVEL = 0; //successful match
            }
            else
                ERRORLEVEL = 1; //password doesn't match
        } else
            ERRORLEVEL = 2; //email doesn't match
    }

    public short getErrorLevel(){

        /*String passwordHash = DigestUtils.sha1Hex(plainTextPassword); //calculate checksum

        //send checksum to server for validation
        if (plainTextEmail.matches(mock_userEmail)) {
            if (mock_userPassword.equalsIgnoreCase(passwordHash))
                ERRORLEVEL = 0; //successful match
            else
                ERRORLEVEL = 1; //password doesn't match
        }*/
        return ERRORLEVEL;
    }
}