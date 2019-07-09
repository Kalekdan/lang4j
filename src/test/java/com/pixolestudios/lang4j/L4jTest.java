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
        L4j.setDefaultResFileName("resources");
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
    public void resourceInSubDirCanBeAccessed() {
        String res = L4j.getResourceInDir("resourcesSubDir", "defaultTestInDir", "default.resource");
        Assert.assertEquals("english sub directory", res);
    }

    @Test
    public void resourceInSubDirCanBeAccessedWithLangSpecified() {
        String res = L4j.getResourceInDir("resourcesSubDir", "defaultTestInDir", "default.resource", "fr");
        Assert.assertEquals("french sub directory", res);
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
    public void getResourceReturnsString() {
        String res = L4j.getResource("defaultTest", "default.resource");
        Assert.assertTrue(!res.isEmpty());
    }

    @Test
    public void nonExistentResourceReturnsEmptyString() {
        String res = L4j.getResource("defaultTest", "fakeRes");
        Assert.assertTrue(res.isEmpty());
    }

    @Test
    public void nonExistentResourceFileReturnsEmptyString() {
        String res = L4j.getResource("fakeFile", "default.resource");
        Assert.assertTrue(res.isEmpty());
    }

    @Test
    public void getDefaultResourceUsesDefaultFile() {
        String res = L4j.getDefResource("default.resource");
        Assert.assertEquals("defaultfilenameresource_eng", res);

        L4j.setDefaultResFileName("defaultTest");
        res = L4j.getDefResource("default.resource");
        Assert.assertEquals("default resource english", res);
    }

    @Test
    public void getDefaultResourceSpecifiedLangUsesDefaultFile() {
        String res = L4j.getDefResource("default.resource", "fr");
        Assert.assertEquals("defaultfilenameresource_fr", res);

        L4j.setDefaultResFileName("defaultTest");
        res = L4j.getDefResource("default.resource", "eng");
        Assert.assertEquals("default resource english", res);
    }
}