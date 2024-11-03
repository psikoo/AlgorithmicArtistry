package com.AlgoArt.utils.setup;

import java.util.Scanner;

import com.AlgoArt.utils.lib.Frame;

public class SetupFrame {
    private static int height = 20;
    private static int width = 100;
    private static boolean confirmHeight = false;
    private static boolean confirmWidth = false;

    public static int selectHeight() {
        confirmHeight = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!confirmHeight) {
            // Draw frame
            Frame sizeMenu = new Frame(height, width, Frame.borderBuilder(1));
            sizeMenu.setWindowString(0, true, "[ Size Setup ]"); 
            sizeMenu.setWindowString(2, true, "- Select the correct height -"); 
            sizeMenu.setWindowString(3, true, "Leave 1 line empty at the bottom"); 
            sizeMenu.divider(5);
            sizeMenu.setWindowString(6, 2, "[ c ] confirm"); 
            sizeMenu.setWindowString(7, 2, "[ + ] height + 1"); 
            sizeMenu.setWindowString(8, 2, "[ - ] height - 1"); 
            sizeMenu.setWindowString(9, 2, "[ ++ ] height + 10"); 
            sizeMenu.setWindowString(10, 2, "[ -- ] height - 10"); 
            sizeMenu.setWindowString(12, 2, "[ height = "+height+" ]"); 
            sizeMenu.setWindowString(13, 2, "[ width = "+width+" ]"); 
            sizeMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) confirmHeight = true;
            else if(input.equals("+")) height++;
            else if(input.equals("-")) height--;
            else if(input.equals("++")) height += 10;
            else if(input.equals("--")) height -= 10;
        }
        return height;
    }

    public static int selectWidth() {
        confirmWidth = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!confirmWidth) {
            // Draw frame
            Frame sizeMenu = new Frame(height, width, Frame.borderBuilder(1));
            sizeMenu.setWindowString(0, true, "[ Size Setup ]"); 
            sizeMenu.setWindowString(2, true, "- Select the correct width -"); 
            sizeMenu.divider(5);
            sizeMenu.setWindowString(6, 2, "[ c ] confirm"); 
            sizeMenu.setWindowString(7, 2, "[ + ] width + 1"); 
            sizeMenu.setWindowString(8, 2, "[ - ] width - 1"); 
            sizeMenu.setWindowString(9, 2, "[ ++ ] width + 20"); 
            sizeMenu.setWindowString(10, 2, "[ -- ] width - 20"); 
            sizeMenu.setWindowString(12, 2, "[ height = "+height+" ]"); 
            sizeMenu.setWindowString(13, 2, "[ width = "+width+" ]"); 
            sizeMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) confirmWidth = true;
            else if(input.equals("+")) width++;
            else if(input.equals("-")) width--;
            else if(input.equals("++")) width += 20;
            else if(input.equals("--")) width -= 20;
        }
        return width;
    }
}
