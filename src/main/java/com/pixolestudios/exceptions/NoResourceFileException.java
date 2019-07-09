package main.java.com.pixolestudios.exceptions;

public class NoResourceFileException extends Exception {
    /**
     * Thrown if resource file has not been found
     *
     * @param fileLoc expected location of resource file
     */
    public NoResourceFileException(String fileLoc) {
        super("No resource file found at \"" + fileLoc + "\"");
    }
}
