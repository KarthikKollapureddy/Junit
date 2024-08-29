package org.pratice;

import org.junit.jupiter.api.*;

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
    @DisplayName("Test method is returning what is passed as input ")
    @Test
    void Test_inputString(){
        assertNull(demoUtils.returnInputString(null),"Input message is Null");
        assertNotNull(demoUtils.returnInputString("Not Null"),"Input message is not Null");
    }
}
