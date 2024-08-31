package org.pratice.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    /*
    we can use parameterized tests as well and iterate the test for n values.
    we can achieve this by using @ParameterizedTest Note: @Test not req
    For source test data we can use:
        @ValueSource -> array of values string, int, double etc
        @CsvSource -> Array of csv String values
        @CsvFileSource -> CSV value read from file
        @EnumSource -> Enum Const values
        @MethodSource -> Method to provide values
     */
    @ParameterizedTest(name = "value = {0}, expected = {1}") // 0 and 1 are indices respectively for csv data
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "4,4",
            "5,Buzz",
            "6,Fizz",
            "15,FizzBuzz",
            "30,FizzBuzz",
    })
    @Order(5)
    void test_FizzBuzzForCSVData(String value, String result){
        assertEquals(result,FizzBuzz.compute(Integer.parseInt(value)));
    }
    //Test all Fizz
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {3, 6, 9, 12, 21, 27, 81})
    @Order(7)
    void test_FizzValues(int value){
        assertEquals(fizz,FizzBuzz.compute(value));
    }
    //Test all Buzz
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(ints = {5, 10, 20, 25, 35, 40, 80})
    @Order(8)
    void test_BuzzValues(int value){
        assertEquals(buzz,FizzBuzz.compute(value));
    }
//    Test medium csv data
    @DisplayName("Test medium data for Fizz Buzz")
    @ParameterizedTest(name = "value = {0}, expected = {1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void test_mediumCSV_Data(String value, String expected){
        assertEquals(expected,FizzBuzz.compute(Integer.parseInt(value)));
    }
}
