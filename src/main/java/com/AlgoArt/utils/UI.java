package com.AlgoArt.utils;

import com.AlgoArt.utils.lib.Frame;

public class UI {
    private static int initialOffset = 5;
    private static int space = 4;

    public static Frame standardWindow(String tittle) {
        Frame frame = new Frame(Settings.getHeight(), Settings.getWidth(), Frame.borderBuilder(1))
            .setWindowString(0, true, "[ "+tittle+" ]"); 
        UI.bottomMenu(frame);
        return frame;
    }
    public static Frame standardWindow(String tittle, String bottomMenu) {
        Frame frame = new Frame(Settings.getHeight(), Settings.getWidth(), Frame.borderBuilder(1))
            .setWindowString(0, true, "[ "+tittle+" ]"); 
            if(bottomMenu.equalsIgnoreCase("empty")) frame.print();
            else if(bottomMenu.equalsIgnoreCase("back")) UI.backMenu(frame);
        return frame;
    }

    private static void bottomMenu(Frame frame) {
        String options = "[ z - Options ]";
        String setup = "[ x - Setup ]";
        String exit = "[ c - Exit ]";
        frame.setWindowString(initialOffset, Settings.getHeight()-1, options);
        frame.setWindowString(initialOffset+options.length()+space, Settings.getHeight()-1, setup);
        frame.setWindowString(initialOffset+options.length()+setup.length()+space*2, Settings.getHeight()-1, exit).print(); 
    }

    private static void backMenu(Frame frame) {
        String back = "[ b - Back ]";
        String exit = "[ c - Exit ]";
        frame.setWindowString(initialOffset, Settings.getHeight()-1, back);
        frame.setWindowString(initialOffset+back.length()+space, Settings.getHeight()-1, exit).print();
    }
}
