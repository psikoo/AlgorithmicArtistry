package com.AlgoArt.utils;

import com.AlgoArt.utils.lib.Frame;

public class UI {
    private static int initialOffset = 5; //* Offset of bottom menu from the left
    private static int space = 4;         //* Space between menu options

    /** 
     * Generates an standard window with a different menu depending on the provided menuType
     * @param tittle Text to be centered in the top of the screen
     * @param menuType [ standard | back | empty ] Selector for the bottom menu 
     * @return Frame
     */
    public static Frame standardWindow(String tittle, Menus menuType) {
        Frame frame = new Frame(Settings.getHeight(), Settings.getWidth(), Frame.borderBuilder(1))
            .setWindowString(0, true, "[ "+tittle+" ]"); 
            if (menuType == Menus.standard) standardMenu(frame);
            else if(menuType == Menus.back) backMenu(frame);
            else if(menuType == Menus.empty) frame.print();
        return frame;
    }
    public enum Menus {
        standard,
        back,
        empty
    }

    /** 
     * [ z - Options ]    [ x - Setup ]    [ c - Exit ]
     * @param frame
     */
    private static void standardMenu(Frame frame) {
        String options = "[ z - Options ]";
        String setup = "[ x - Setup ]";
        String exit = "[ c - Exit ]";
        frame.setWindowString(initialOffset, Settings.getHeight()-1, options);
        frame.setWindowString(initialOffset+options.length()+space, Settings.getHeight()-1, setup);
        frame.setWindowString(initialOffset+options.length()+setup.length()+space*2, Settings.getHeight()-1, exit).print(); 
    }
    /** 
     * [ b - Back ]    [ c - Exit ]
     * @param frame
     */
    private static void backMenu(Frame frame) {
        String back = "[ b - Back ]";
        String exit = "[ c - Exit ]";
        frame.setWindowString(initialOffset, Settings.getHeight()-1, back);
        frame.setWindowString(initialOffset+back.length()+space, Settings.getHeight()-1, exit).print();
    }
}
