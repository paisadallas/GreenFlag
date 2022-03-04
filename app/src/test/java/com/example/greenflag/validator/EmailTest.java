package com.example.greenflag.validator;

import static org.junit.Assert.*;

import android.widget.EditText;

import com.example.greenflag.MainActivity2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmailTest {



    @Test
    public void invalidEmails() {
        Email email = new Email();

        List emails = new ArrayList();
        //INVALID EMAILS
        emails.add(".username@yahoo.com");
        emails.add("username@yahoo.com.");
        emails.add("..username@gmail.com");
        emails.add("!username@gmail.com");
       // emails.add("2username@gmail.com");
        emails.add("2user name@gmail.com");
        emails.add("2user*name@gmail.com");
        emails.add("2user*name@gmail.@com");
        emails.add("username@yahoo..com");
        emails.add("username@yahoo.c");
        emails.add("username@ya hoo.corporate");
        emails.add("andres@gmai"); //Invalid Email


//        for(int i =0; i<emails.size();i++){
//            assertEquals(false,email.testEmail((String) emails.get(i)));
//        }

     //   assertEquals(false,email.testEmail((String) emails.get(10)));

    }

    @Test
    public void is_valid_Email(){
        Email email = new Email();

        List emails = new ArrayList();
        //INVALID EMAILS
        emails.add("user@domain.com");
        emails.add("us5ername@yahoo.com");
        emails.add("username@gmail.com");
        emails.add("username@gmail.com.co");
        emails.add("2usern-ame@gmail.com");
        emails.add("2us_ername@gmail.com");
        emails.add("2username@gmail.com");

        emails.add("username@yahoo.com");
        emails.add("username@yahoo.cui");
        emails.add("username@yahoo.corpo");



                for(int i =0; i<emails.size();i++){
            assertEquals(true,email.testEmail((String) emails.get(i)));
        }
   //   assertEquals(true,email.testEmail((String) emails.get(7)));
    }

}