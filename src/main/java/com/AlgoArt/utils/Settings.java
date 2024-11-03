package com.AlgoArt.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Settings {
    private static Path settingsFilePath = Paths.get(System.getProperty("user.dir")+"/settings.txt");
    private static int height = 0;
    private static int width = 0;

    public static void setHeight(int height) { Settings.height = height; }
    public static void setWidth(int width) { Settings.width = width; }

    public static int getHeight() {
        int height = 0;
        try { height = Integer.parseInt(Files.readAllLines(settingsFilePath).get(SettingIndex.Height.ordinal())); } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
        return height;
    }
    public static int getWidth() {
        int width = 0;
        try { width = Integer.parseInt(Files.readAllLines(settingsFilePath).get(SettingIndex.Width.ordinal())); } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
        return width;
    }
    private enum SettingIndex {
        HeightString,
        Height,
        WidthString,
        Width,
        //! Add new settings here
    }

    public static void restoreSize() {
        setHeight(getHeight());
        setWidth(getWidth());
    }

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
    public static void saveHeight() {
        try { 
            Files.write(settingsFilePath, "Height=\n".getBytes(), StandardOpenOption.APPEND); 
            Files.writeString(settingsFilePath, Integer.toString(height)+"\n", StandardOpenOption.APPEND);
        } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
    }
    public static void saveWidth() {
        try { 
            Files.write(settingsFilePath, "Width=\n".getBytes(), StandardOpenOption.APPEND); 
            Files.writeString(settingsFilePath, Integer.toString(width)+"\n", StandardOpenOption.APPEND);
        } 
        catch (NumberFormatException | IOException e) { e.printStackTrace(); }
    }
}
