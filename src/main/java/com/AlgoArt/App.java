package com.AlgoArt;

import java.io.File;
import java.util.Scanner;

import com.AlgoArt.menu.MainMenu;
import com.AlgoArt.setup.Setup;
import com.AlgoArt.utils.Settings;

public class App {
    public App(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        // Ansi check
        System.out.println("\nIf you are seeing this run the following command and rerun the program (⚠Windows)");
        System.out.println("reg add HKEY_CURRENT_USER\\Console /v VirtualTerminalLevel /t REG_DWORD /d 0x00000001 /f");
        System.out.print("\033c\033[2J");
        // Full screen prompt
        System.out.println("Please make this window full screen for a better experience");
        System.out.println("> Press enter to continue...");
        scanner.nextLine();

        // Check for settings flag or file
        File settingsFile = new File(System.getProperty("user.dir")+"/settings.txt");
        boolean hasArgs = args.length>0;
        boolean hasSettingsFlag = hasArgs && (args[0].equals("-s") || args[0].equals("--settings"));
        boolean hasNoSettingsFile = !(settingsFile.exists() && !settingsFile.isDirectory());
        
        if(hasSettingsFlag || hasNoSettingsFile) { new Setup(); } //! -s flag
        else { Settings.restoreSize(); }
        new MainMenu();
    }
}
