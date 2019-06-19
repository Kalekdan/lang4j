package main.java.com.pixolestudios.lang4j;

import main.java.com.pixolestudios.exceptions.NoResourceFileException;
import main.java.com.pixolestudios.exceptions.NoResourceFoundException;

public class L4j {
    private static String currentLang = "eng";
    private static String resLoc = "resources/lang";

    private L4j() {
    }

    public static String getResource(String resFile, String resName, String lang) {
        String toReturn;
        try {
            toReturn = readResource(makePath(resFile, lang), resName);
        } catch (NoResourceFileException e) {
            e.printStackTrace();
            toReturn = "";
        } catch (NoResourceFoundException e) {
            e.printStackTrace();
            toReturn = "";
        }
        return toReturn;
    }

    public static String getResource(String resFile, String resName) {
        return getResource(resFile, resName, currentLang);
    }

    private static String makePath(String file, String lang) {
        return resLoc + "/" + file + "_" + lang + ".properties";
    }

    private static String readResource(String path, String res) throws NoResourceFileException, NoResourceFoundException {
        String toReturn = FileUtils.loadResFromPropsFile(path, res);
        if (toReturn == null){
            throw new NoResourceFoundException(path, res);
        }
        return toReturn;
    }

    public static void setCurrentLang(String lang) {
        currentLang = lang;
    }

    public static void setResLoc(String loc) {
        resLoc = loc;
    }

    public static String getResourceInDir(String dir, String resFile, String resName){
        return getResourceInDir(dir, resFile, resName, currentLang);
    }

    public static String getResourceInDir(String dir, String resFile, String resName, String lang) {
        return getResource(dir + "/" + resFile, resName, lang);
    }

}
