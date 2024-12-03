package com.AlgoArt.setup;

import com.AlgoArt.utils.Settings;

public class Setup {
    /**
     * Initializes the select height and width process
     */
    public Setup() {
        int height = SetupFrame.selectHeight();
        int width = SetupFrame.selectWidth();
        saveToFile(height, width);
    }

    /**
     * Saves hight and width to the settings file
     * @param height
     * @param width
     */
    private void saveToFile(int height, int width) {
        Settings.setHeight(height);
        Settings.setWidth(width);
        Settings.save();
    }
}
