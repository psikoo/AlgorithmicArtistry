package com.AlgoArt.setup;

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
            sizeMenu.setWindowString(2, true, "leave 1 empty line at the bottom"); 
            sizeMenu.divider(5);
            sizeMenu.setWindowString(6, 2, "[ height = "+height+" ]"); 
            sizeMenu.setWindowString(7, 2, "[ width = "+width+" ]");
            sizeMenu.setWindowString(9, 2, "[ +num ] height + number"); 
            sizeMenu.setWindowString(10, 2, "[ -num ] height - number");
            sizeMenu.setWindowString(11, 2, "[ c ] confirm"); 
            sizeMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) confirmHeight = true;
            else if(input.charAt(0) == '+') height+=extractNumber(input);
            else if(input.charAt(0) == '-') height-=extractNumber(input);
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
            sizeMenu.setWindowString(6, 2, "[ height = "+height+" ]"); 
            sizeMenu.setWindowString(7, 2, "[ width = "+width+" ]");
            sizeMenu.setWindowString(9, 2, "[ +num ] width + number"); 
            sizeMenu.setWindowString(10, 2, "[ -num ] width - number");
            sizeMenu.setWindowString(11, 2, "[ c ] confirm"); 
            sizeMenu.print();
            // Controls
            String input = scanner.nextLine();
            if(input.equals("c")) confirmWidth = true;
            else if(input.charAt(0) == '+') width+=extractNumber(input);
            else if(input.charAt(0) == '-') width-=extractNumber(input);
        }
        return width;
    }

    private static int extractNumber(String string) {
        try { return Integer.valueOf(string.substring(1)); } 
        catch (Exception ignore) { return 0; }
    }
}
