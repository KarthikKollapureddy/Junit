package org.pratice;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.pratice.DTO.Human;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
/*
junit have generators class which can be used to generate test names
1. Simple - removes () in test method name.
2. ReplaceUnderscore - replaces underscores with spaces.
3. IndicativeSentences - generates sentence based on testClass and testName.
 */
//no need to specify class as public
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("Runs only once before all test, applicable in establishing DB connections " +
                "and connecting to servers");
    }
    @AfterAll
    static void setupAfterAll(){
        System.out.println("Runs only once After all test, applicable in release DB connections " +
                "and disconnecting to servers");
    }

//    Executes before each test (@Test)
    @BeforeEach //lifeCycle Method
    void initialSetup(){
        demoUtils = new DemoUtils();
    }

    @AfterEach //lifeCycle Method
    void releaseResources(){
//        System.out.println("Executes after each test case, mostly to release resources and for cleanup");
    }
    @Test
    void test_Add_Method(){
        assertEquals(8,demoUtils.add(2,6),"2+6 should equals to 8");
        assertNotEquals(6,demoUtils.add(2,6),"2+6 should not equals to 6");
    }
    @Test
    void test_String_is_Null_OR_Empty(){
        assertTrue(demoUtils.isNull("      "),"String is null/empty");
        assertFalse(demoUtils.isNull("Hello"),"String Hello is not null/empty");
    }
    @Test
    void test_inputString(){
        assertNull(demoUtils.returnInputString(null),"Input message is Null");
        assertNotNull(demoUtils.returnInputString("Not Null"),"Input message is not Null");
    }
    /*
    assertSame - assert items refer to same Object
    assertNotSame - assert items DO NOT refer to same Object
     */
    @Test
    void test_Reference_Of_Objects_Is_Same(){
        assertSame(demoUtils.getJunit(),demoUtils.getJunitDuplicate(),"Both should refer to same reference");
        assertNotSame(demoUtils.getJunit(),demoUtils.getJunitDuplicateNew(),"Both should refer to different reference");
    }
    /*
    Assertions for Arrays
    assertArrayEquals - Assert that both object arrays are deeply equal
    assertIterableEquals - Assert that both object iterables are deeply equal
    assertLinesMath - Assert that both lists of strings match
     */
    @Test
    void test_Array_Equals(){
        String[] testArrayActual = {"A", "B", "C"};
        assertArrayEquals(demoUtils.getFirstThreeLettersOfAlphabets(),testArrayActual,
                "Arrays should match");
    }
    @Test
    void test_List_Equals(){
        List<String> testListActual = List.of("Junit", "jupiter", "assertions");
        assertIterableEquals(demoUtils.getStringList(),testListActual,
                "Expected List should be same as actual list");
    }
    @Test
    void test_Lines_Match(){
        List<String> testListActual = List.of("Junit", "jupiter", "assertions");
        assertLinesMatch(demoUtils.getStringList(),testListActual,
                "Lines should match");
    }
    /*
    AssertThrows -> assert that an executable throws an exception of expected type
     */
    @Test
    void test_ThrowsException_for_NegativeValues(){
        assertThrows(Exception.class, () -> {demoUtils.validateNegativeValues(-1);}
        ,"Should throw an Exception");
        assertDoesNotThrow(()->{demoUtils.validateNegativeValues(9);},
                "Should not throw an exception ");

    }
    /*
    assertTimeoutPreemptively -> asserts that executable completes
                    before given timeout is executed
     */
    @Test
    void test_Timeout(){
        assertTimeoutPreemptively(Duration.ofSeconds(4),()->{demoUtils.checkTimeout();},
                "Method should execute under 4 seconds");
    }
    @Test
    @Disabled("Test is disabled due to a bug") // disables a test
    void test_logicUnder_implementation(){
        System.out.println("""
                method to test is under impl
                """);
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testOnlyOnWindows(){
    // windows specific test
    }
    @Test
    @EnabledOnOs({OS.WINDOWS, OS.MAC}) //Multiple OS
    void testOnlyOnWindowsAndMac(){
    // windows specific test
    }
    @Test
    @EnabledOnJre(JRE.JAVA_17) //Run Test for only JRE 17
    void testOnlyOnJava17(){
        System.out.println("we are using java 17!");
        assertEquals("Name: John, age: 23 and profession: Engineer",
                demoUtils.checkObject(new Human("John",23,"Engineer")),
                "Human details must be same!");
    }
    @Test
    @EnabledForJreRange(min = JRE.JAVA_13,max = JRE.JAVA_17) // we can also specify only min as well
    void testOnlyOnJRE17TO18(){
        System.out.println("we are using java 17!");
        assertEquals("Name: John, age: 23 and profession: Engineer",
                demoUtils.checkObject(new Human("John",23,"Engineer")),
                "Human details must be same!");
    }


}
