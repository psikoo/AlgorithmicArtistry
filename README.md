# AlgoArt

Algorithmic Artistry is a text-based game made with Java. The game has 3 characters to play as, 3 enemies to defeat and 5 endings to find.  

⚠ The game requires a console that can process basic ansi codes.

⚠ The game has only been tested in windows, but it should work fine in linux and macOS.


## Build the game yourself

**Build information:**

This project uses Maven as its build tool for Java. To build from source you must install Maven.

**Build steps:**

- Download the code as a [zip](https://github.com/psikoo/AlgorithmicArtistry/archive/refs/heads/main.zip), or clone the repository from its [git](https://github.com/psikoo/AlgorithmicArtistry.git).

- Run this command from the main project directory (AlgorithmicArtistry-main or AlgorithmicArtistry depending on your download method):

Build compile .class, create project information site, create javadoc, compile jar, compile jar with dependencies, run mavenInstall.cmd:

```bash
mvn clean validate compile site javadoc:javadoc assembly:assembly -DdescriptorId=jar-with-dependencies exec:exec
```

Build compile .class, compile jar, compile jar with dependencies:
```bash
mvn clean validate compile assembly:assembly -DdescriptorId=jar-with-dependencies
```

- mavenInstall.cmd:
mavenInstall.cmd is a utility script, its main purpose is to create a folder in the user's desktop named "AlgoArt" and copy the compiled .jar with dependencies, the README and and other scripts into it. This allows for a smother user experience when building this project, as all you would need to run the app is inside this new folder. This script is run automatically when building the project (to stop it from running, remove the "exec:exec" argument from the build command). Additionally, the script also starts the app to see if it's working.

- AlgoArt.lnk:
AlgoArt.lnk is a shortcut to the script "src/start.cmd". Due to windows poor usability of lnk files it has to have an absolute reference to start.cmd, this means that the best I could to is point the lnk file to "%USERPROFILE%\Desktop\AlgoArt\src\start.cmd" if start.cmd isn't in this location the shortcut wont work (you can always just run the game from start.cmd).

## Running the game

Once you have built the app or downloaded it from the [releases](https://github.com/psikoo/AlgorithmicArtistry/releases), you can simply run the app by running AlgoArt.lnk or start.cmd. This runs the following command: 

```bash
reg add HKEY_CURRENT_USER\Console /v VirtualTerminalLevel /t REG_DWORD /d 0x00000001 /f >NUL
java -jar AlgoArt.jar
```
The first line of the command allows ansi codes on the windows 10 terminal (as they are turned of by default).

**Launch parameters:**

- `-s` forces the setup screen on program start. Usage: `java -jar AlgoArt.jar -s`

## Photos

**Splash screen**
![AlgoArt splash screen](https://i.imgur.com/3PvDz9B.png)
**Introduction**
![AlgoArt initial lore](https://i.imgur.com/mIpPTPG.png)
**Battle**
![AlgoArt battle](https://i.imgur.com/AYlWiS7.png)