package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.menu.SettingsMenu;
import com.AlgoArt.utils.setup.Setup;

public class StoryFrame {
    private static boolean fractalEnd = false;
    public static void fractal() {
        fractalEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!fractalEnd) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame fractal = new Frame(height, width, Frame.borderBuilder(1));
            fractal.setWindowString(0, true, "[ Fractal ]"); // TODO Change name
            // TODO Add strory text, 1 line then enter for next line
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            fractal.setWindowString(height-1, 3, options);
            fractal.setWindowString(height-1, 3+options.length()+4, setup);
            fractal.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            fractal.print();
            String input = scanner.nextLine();
            // Controls
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
            else fractalEnd = true;
        }
    }

    public static void geom() {

    }

    public static void spider() {

    } // TODO
}
