package main.java.com.pixolestudios.lang4j;

public class L4j {
    private static String currentLang = "eng";
    private static String resLoc = "resources/lang";

    private static final String placeHolderStr = "placeholderstring";

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
        String toReturn = FileUtils.loadResFromPropsFile(path, res);
        if (toReturn == null){
            toReturn = placeHolderStr;
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
