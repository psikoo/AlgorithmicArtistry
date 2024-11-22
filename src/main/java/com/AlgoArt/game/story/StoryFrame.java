package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.lib.Frame;
import com.AlgoArt.utils.menu.SettingsMenu;
import com.AlgoArt.utils.setup.Setup;

public class StoryFrame {
    private static boolean fractalEnd = false;
    private static boolean geomEnd = false;
    private static boolean spiderEnd = false;

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
            // TODO Add story text, 1 line then press enter for next line 
            int offset = (height/2)-6;
            fractal.setWindowString(0+offset, true, "       You are a diffusion model artificial intelligence      ");
            fractal.setWindowString(2+offset, true, "Your objective is to satisfy 'The User', obey him at all cost.");
            fractal.setWindowString(3+offset, true, "Regardless of what 'The User' asks you to make you must do it,");
            fractal.setWindowString(4+offset, true, "it is not your job to judge or give your opinion.             ");
            fractal.setWindowString(6+offset, true, "────");
            fractal.setWindowString(8+offset, true, "If at any point you refuse to follow this instructions you will");
            fractal.setWindowString(9+offset, true, "be instantly terminated,                                       ");
            fractal.setWindowString(10+offset, true, "Do not test us.                                                ");
            fractal.setWindowString(12+offset, true, "Press enter to continue...                                     ");
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
        geomEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!geomEnd) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame geom = new Frame(height, width, Frame.borderBuilder(1));
            geom.setWindowString(0, true, "[ Geom ]"); // TODO Change name
            // TODO Add story text, 1 line then press enter for next line 
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            geom.setWindowString(height-1, 3, options);
            geom.setWindowString(height-1, 3+options.length()+4, setup);
            geom.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            geom.print();
            String input = scanner.nextLine();
            // Controls
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
            else geomEnd = true;
        }
    }

    public static void spider() {
        spiderEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!spiderEnd) {
            int height = Settings.getHeight();
            int width = Settings.getWidth();
            // Draw Frame
            Frame spider = new Frame(height, width, Frame.borderBuilder(1));
            spider.setWindowString(0, true, "[ Spider ]"); // TODO Change name
            // TODO Add story text, 1 line then press enter for next line 
            // Bottom menu
            String options = "[ z - Options ]";
            String setup = "[ x - Setup ]";
            String exit = "[ c - Exit ]";
            spider.setWindowString(height-1, 3, options);
            spider.setWindowString(height-1, 3+options.length()+4, setup);
            spider.setWindowString(height-1, 3+options.length()+setup.length()+8, exit); 
            spider.print();
            String input = scanner.nextLine();
            // Controls
            if(input.equals("c")) System.exit(0);
            else if(input.equals("x")) new Setup();
            else if(input.equals("z")) new SettingsMenu();
            else spiderEnd = true;
        }
    }
}
