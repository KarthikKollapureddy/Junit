package org.pratice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//no need to specify class as public
class DemoUtilsTest {
    @Test
    void test_Add_Method(){
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(8,demoUtils.add(2,6),"2+6 should equals to 8");
        assertNotEquals(6,demoUtils.add(2,6),"2+6 should not equals to 6");
    }
    @Test
    void test_String_is_Null_OR_Empty(){
        DemoUtils demoUtils = new DemoUtils();
        assertTrue(demoUtils.isNull("      "),"String is null/empty");
        assertFalse(demoUtils.isNull("Hello"),"String Hello is not null/empty");
    }
    @Test
    void Test_inputString(){
        DemoUtils demoUtils = new DemoUtils();
        assertNull(demoUtils.returnInputString(null),"Input message is Null");
        assertNotNull(demoUtils.returnInputString("Not Null"),"Input message is not Null");
    }
}
