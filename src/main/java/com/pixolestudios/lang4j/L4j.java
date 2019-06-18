package main.java.com.pixolestudios.lang4j;

public class L4j {
    private static String currentLang = "eng";
    private static String resLoc = "resources/lang";

    private L4j() {
    }

    public static String getResource(String resFile, String resName, String lang) {
        return readResource(makePath(resFile, lang), resName);
    }

    public static String getResource(String resFile, String resName) {
        return getResource(resFile, resName, currentLang);
    }

    private static String makePath(String file, String lang) {
        return resLoc + "/" + file + "_" + lang + ".properties";
    }

    private static String readResource(String path, String res) {
        return FileUtils.loadResFromPropsFile(path, res);
    }

    public static void setCurrentLang(String lang) {
        currentLang = lang;
    }

    public static void setResLoc(String loc) {
        resLoc = loc;
    }

}
