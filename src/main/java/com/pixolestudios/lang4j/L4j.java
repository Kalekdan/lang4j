package main.java.com.pixolestudios.lang4j;

import main.java.com.pixolestudios.exceptions.NoResourceFileException;
import main.java.com.pixolestudios.exceptions.NoResourceFoundException;

public class L4j {
    private static String currentLang = "eng";
    private static String resLoc = "resources/lang";

    private L4j() {
    }

    /**
     * Gets a resource from the provided file using language provided
     * @param resFile file name
     * @param resName name of the resource
     * @param lang language to get resource for
     * @return resource requested, or empty string if not found
     */
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

    /**
     * Gets a resource from the provided file using current language
     * @param resFile file name
     * @param resName name of the resource
     * @return resource requested, or empty string if not found
     */
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

    /**
     * Updates the current language
     * @param lang the new current language, to be used when not otherwise specified
     */
    public static void setCurrentLang(String lang) {
        currentLang = lang;
    }

    /**
     * Updates the resource location
     * @param loc location the resource files are to be expected
     */
    public static void setResLoc(String loc) {
        resLoc = loc;
    }

    /**
     * Gets a resource in a subdirectory from the provided file using current lang
     * @param dir directory the resource will be in
     * @param resFile file name
     * @param resName name of the resource
     * @return resource requested, or empty string if not found
     */
    public static String getResourceInDir(String dir, String resFile, String resName){
        return getResourceInDir(dir, resFile, resName, currentLang);
    }

    /**
     * Gets a resource in a subdirectory from the provided file using language provided
     * @param dir directory the resource will be in
     * @param resFile file name
     * @param resName name of the resource
     * @param lang language to get resource for
     * @return resource requested, or empty string if not found
     */
    public static String getResourceInDir(String dir, String resFile, String resName, String lang) {
        return getResource(dir + "/" + resFile, resName, lang);
    }

}
