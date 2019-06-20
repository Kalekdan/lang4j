package com.pixolestudios.lang4j;

import main.java.com.pixolestudios.lang4j.L4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class L4jTest {

    @Before
    public void setDefaults() {
        L4j.setResLoc("src/test/java/com/pixolestudios/lang4j/testResources");
        L4j.setCurrentLang("eng");
    }

    @Test
    public void noSpecifiedLanguageUsesCurrentLang() {
        String languageName = L4j.getResource("defaultTest", "languagename");
        Assert.assertEquals("english", languageName);
    }

    @Test
    public void specifiedLanguageUsesLang() {
        String languageName = L4j.getResource("defaultTest", "languagename", "fr");
        Assert.assertEquals("french", languageName);
    }

    @Test
    public void setCurrentLangUpdatesCurrent() {
        L4j.setCurrentLang("eng");
        String languageName = L4j.getResource("defaultTest", "languagename");
        Assert.assertEquals("english", languageName);
        L4j.setCurrentLang("fr");
        languageName = L4j.getResource("defaultTest", "languagename");
        Assert.assertEquals("french", languageName);
    }

    @Test
    public void getResourceReturnsString(){
        String res = L4j.getResource("defaultTest", "default.resource");
        Assert.assertTrue(!res.isEmpty());
    }

    @Test
    public void nonExistentResourceReturnsEmptyString(){
        String res = L4j.getResource("defaultTest", "fakeRes");
        Assert.assertTrue(res.isEmpty());
    }
}