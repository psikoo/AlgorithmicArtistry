package com.AlgoArt.game.story;

import java.util.Scanner;

import com.AlgoArt.menu.SettingsMenu;
import com.AlgoArt.setup.Setup;
import com.AlgoArt.utils.Inputs;
import com.AlgoArt.utils.Settings;
import com.AlgoArt.utils.UI;
import com.AlgoArt.utils.lib.Frame;

public class StoryFrame {
    private static boolean fractalEnd = false;
    private static boolean geomEnd = false;
    private static boolean spiderEnd = false;

    public static void fractal() {
        fractalEnd = false;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (!fractalEnd) {
            // Draw Frame
            int offset = (Settings.getHeight()/2)-2; // TODO Change acording to story size
            Frame frame = UI.standardWindow("Fractal Block World")
                .setWindowString(0+offset, true, "This is a story tittle")
                .setWindowString(Settings.getHeight()-2, 5, "Press enter to continue...")
                .print();
            // Input check
            String input = scanner.nextLine(); // TODO come up with a fucking better solution, this sucks (game advances 1 frame on menu input)
            Inputs.checkStandardInputs(input);
            // Input check and next lines
            frame.setWindowString(2+offset, true, "line1                 ").print();
            input = scanner.nextLine();
            Inputs.checkStandardInputs(input);
            // Input check and next lines
            frame.setWindowString(3+offset, true, "line2                 ").print();
            input = scanner.nextLine();
            Inputs.checkStandardInputs(input);
            fractalEnd = true;
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
            geom.setWindowString(0, true, "[ Geometrical Dominator ]");
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
            spider.setWindowString(0, true, "[ Spider Dance ]");
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
