package com.bl.userregistration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class EmailValidationTest {
         String email;
         boolean expectedResult;
        public EmailValidationTest(String email, boolean expectedResult) {
            this.email = email;
            this.expectedResult = expectedResult;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"john.doe@example.com", true},
                    {"jane.doe@example.com", true},
                    {"foo@example.com", true},
                    {"bar@example.com", true},
                    {"example.com", false},
                    {"john.doe@.com", false},
                    {"john.doe@ex", false}
            });
        }
        @Test
        public void testIsValidEmail() {
            assertEquals(expectedResult, UserRegistration.isValidEmail(email));
        }
    }

