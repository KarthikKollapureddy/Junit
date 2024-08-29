package org.pratice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//no need to specify class as public
class DemoUtilsTest {

    DemoUtils demoUtils;
//    Executes before each test (@Test)
    @BeforeEach
    void initialSetup(){
        demoUtils = new DemoUtils();
    }

    @AfterEach
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
    void Test_inputString(){
        assertNull(demoUtils.returnInputString(null),"Input message is Null");
        assertNotNull(demoUtils.returnInputString("Not Null"),"Input message is not Null");
    }
}
