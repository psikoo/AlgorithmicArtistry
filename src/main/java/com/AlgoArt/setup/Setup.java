package com.AlgoArt.setup;

import com.AlgoArt.utils.Settings;

public class Setup {
    public Setup() {
        int height = SetupFrame.selectHeight();
        int width = SetupFrame.selectWidth();
        saveToFile(height, width);
    }

    private void saveToFile(int height, int width) {
        Settings.setHeight(height);
        Settings.setWidth(width);
        Settings.save();
    }
}
