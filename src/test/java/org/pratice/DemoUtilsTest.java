package org.pratice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

//no need to specify class as public
class DemoUtilsTest {
    @Test
    void test_Add_Method(){
        DemoUtils demoUtils = new DemoUtils();
        assertEquals(8,demoUtils.add(2,6),"2+6 should equals to 8");
        assertNotEquals(6,demoUtils.add(2,6),"2+6 should not equals to 6");
    }
}
