/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author User
 */
@RunWith(JUnitParamsRunner.class)
public class UsernameValidationTest {
    Validation validTest = new Validation();
    
    @Test
    @FileParameters("resources/data_username.csv")
    public void testIsValidUsername(final String a, final boolean b){
        System.out.println("isValidUsername");
        String val = a;  
        boolean expResult = b;
        boolean result = validTest.isValidUsername(val);
        assertEquals(expResult, result);
    }
}
