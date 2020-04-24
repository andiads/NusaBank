/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nusabank.helper;

import junitparams.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junitparams.*;
        
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.nusabank.helper.Validation;
/**
 *
 * @author User
 */
@RunWith(JUnitParamsRunner.class)
public class EmailValidationTest {
     
    Validation validTest = new Validation();
    
    public EmailValidationTest(){
    }
    
    @Test
    @FileParameters("resources/data_email.csv")
    public void testIsValidEmail(final int a, final String b, final boolean c){
        System.out.println("isValidEmail");
        String val = b;  
        boolean expResult = c;
        boolean result = validTest.isValidEmail(val);
        assertEquals(expResult, result);
    }
}
