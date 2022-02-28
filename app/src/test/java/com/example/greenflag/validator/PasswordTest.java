package com.example.greenflag.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PasswordTest {

    @Test
    public void test_password(){

        List pass = new ArrayList();
        pass.add("AAAAAADFASDF");
        pass.add("aaaadsdsdsf");
        pass.add("@#$%^&*()_+{{'/>");
        pass.add("1234567");
        pass.add("AAAa121.");
        pass.add("AAA2a22*");

        Password password = new Password();
        assertEquals(true,password.testCheckPassword((String) pass.get(5)));
    }
}