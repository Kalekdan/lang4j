package com.pixolestudios.lang4j;

import org.junit.Assert;
import org.junit.Test;

public class JUnitFrameworkTest {
    @Test
    public void TestJUnitSetup(){
        String toAssert = "Expected";
        Assert.assertEquals("Expected", toAssert);
    }
}
