package org.pratice.tdd;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/*
Test Driven Development -
    we create tests based on requirement/Functionality then refine our impl code
    to prove the expected result.
 */
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    /*
    if num is divisible by 3 -> Fizz
    if num is divisible by 5 -> Buzz
    if num is divisible by 3 and 5 -> FizzBuzz
    if num is not divisible by either 3 or 5 then return the number
     */
    FizzBuzz fizzBuzz;
    String fizz ="Fizz";
    String buzz ="Buzz";
    String fizzBuzzResult ="FizzBuzz";
    @Test
    @DisplayName("Test Buzz Iff Divisible by 3")
    @Order(1)
    void test_DivisibleByThree(){
       assertEquals(fizz,FizzBuzz.compute(3),
               "Should return Fizz");
    }
    @Test
    @DisplayName("Test Buzz Iff Divisible by 5")
    @Order(2)
    void test_DivisibilityByFive(){
        assertEquals(buzz,FizzBuzz.compute(25),
                "Should return Buzz");
    }
    @Test
    @DisplayName("Test FizzBuzz Iff Divisible by 5")
    @Order(3)
    void test_DivisibilityByThreeAndFive(){
        assertEquals(fizzBuzzResult,FizzBuzz.compute(15),
                "Should return FizzBuzz");
    }
    @Test
    @DisplayName("Test returns input Iff not Divisible by 5 and 3")
    @Order(4)
    void test_NotDivisibilityByThreeAndFive(){
        assertEquals("4",FizzBuzz.compute(4),
                "Should return FizzBuzz");
    }

}
