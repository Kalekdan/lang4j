package main.java.com.pixolestudios.exceptions;

public class NoResourceFoundException extends Exception {
    /**
     * Thrown if resource is not found within resource file
     * @param path path to resource file
     * @param resource the resource which could not be found
     */
    public NoResourceFoundException(String path, String resource) {
        super("No resource \"" + resource + "\" found in resource file " + path);
    }
}