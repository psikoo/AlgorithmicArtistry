package com.AlgoArt.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Settings {
    private static Path settingsFilePath = Paths.get(System.getProperty("user.dir")+"/settings.txt");
    private static int height = 0; //* Frame heigh
    private static int width = 0;  //* Frame width

    public static void setHeight(int height) { Settings.height = height; } //* Set frame heigh
    public static void setWidth(int width) { Settings.width = width; }     //* Set frame width

    
    /** 
     * Reads the second line in the file at settingsFilePath
     * @return int
     */
    public static int getHeight() {
        int height = 0;
        try { height = Integer.parseInt(Files.readAllLines(settingsFilePath).get(SettingIndex.Height.ordinal())); } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
        return height;
    }
    /** 
     * Reads the fourth line in the file at settingsFilePath
     * @return int
     */
    public static int getWidth() {
        int width = 0;
        try { width = Integer.parseInt(Files.readAllLines(settingsFilePath).get(SettingIndex.Width.ordinal())); } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
        return width;
    }
    private enum SettingIndex {
        HeightString,
        Height,         //* File line 2
        WidthString,
        Width,          //* File line 4
        //! Add new settings here
    }

    /** 
     * Reads settings file
     */
    public static void restoreSize() {
        setHeight(getHeight());
        setWidth(getWidth());
    }
    /**
     * Saves class variables to the settings file
     */
    public static void save() {
        try {
            File settings = new File(settingsFilePath.toString());
            if(settings.exists()) settings.delete();
            settings.createNewFile();
        } catch(IOException e) { e.printStackTrace(); }
        saveHeight();
        saveWidth();
        //! Add new settings here
    }
    /**
     * Appends the height to the setting file
     */
    private static void saveHeight() {
        try { 
            Files.write(settingsFilePath, "Height=\n".getBytes(), StandardOpenOption.APPEND); 
            Files.writeString(settingsFilePath, Integer.toString(height)+"\n", StandardOpenOption.APPEND);
        } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
    }
    /**
     * Appends the width to the setting file
     */
    private static void saveWidth() {
        try { 
            Files.write(settingsFilePath, "Width=\n".getBytes(), StandardOpenOption.APPEND); 
            Files.writeString(settingsFilePath, Integer.toString(width)+"\n", StandardOpenOption.APPEND);
        } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
    }
}
