package com.algorithmicArtistry;

import java.util.Scanner;

public class MainMenu {
    private int height = 0;
    private int width = 0;

    public void setHeight(int height) { this.height = height; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public int getWidth() { return width; }

    public MainMenu(int height, int width) {
        this.height = height;
        this.width = width;
        mainMenu();
    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        Frame mainMenu = new Frame(height, width, Frame.borderBuilder(1));

        mainMenu.setWindowString(0, true, "[ Algorithmic Artistry ]"); 
        mainMenu.setWindowString(2, true, "This is a framework to create frames in a cli program");
        mainMenu.divider(4);
        mainMenu.setWindowString(6, 3, "- Single and double frame ('─', '═')");
        mainMenu.setWindowString(7, 3, "- Add strings (supports x and y position or auto center)");
        mainMenu.setWindowString(8, 3, "- Different modes to clear the frame");
        mainMenu.setWindowString(9, 3, "- Horizontal divisors");

        mainMenu.print();
        scanner.nextLine();
        scanner.close();
    }
}
