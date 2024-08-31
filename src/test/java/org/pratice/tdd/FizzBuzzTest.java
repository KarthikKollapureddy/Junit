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
    @DisplayName("Test if input is Divisible by 3")
    @Order(1)
    void test_DivisibleByThree(){
       assertEquals(fizz,FizzBuzz.compute(3),
               "Should return Fizz");
    }
}
