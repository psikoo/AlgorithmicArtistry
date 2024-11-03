echo off
set workingDir=%cd%
set desktop="%userprofile%\Desktop"
set algoArtDir="%userprofile%\Desktop\AlgoArt"
set srcDir="%userprofile%\Desktop\AlgoArt\src"

echo #--------------------------------#
echo ^| Starting maven automated setup ^|
echo #--------------------------------#
echo ^| Creating Directories           ^|
echo #--------------------------------#

cd %desktop%
if not exist "%desktop%\AlgoArt" ( mkdir "AlgoArt" )
cd %algoArtDir%
if not exist "%desktop%\AlgoArt\src" ( mkdir "src" )

echo ^| Copying main files             ^|
echo #--------------------------------#

cd "%algoArtDir%"
if exist README.md ( del README.md )
if exist AlgoArt.Ink ( del AlgoArt.Ink )
copy "%workingDir%\README.md" "%algoArtDir%" >NUL
copy "%workingDir%\src\main\resources\scripts\AlgoArt.lnk" "%algoArtDir%" >NUL

echo ^| Copying src files              ^|
echo #--------------------------------#

cd "%srcDir%"
if exist AlgoArt.ico ( del AlgoArt.ico )
if exist start.cmd ( del start.cmd )
if exist AlgoArt.jar ( del AlgoArt.jar )
if exist AlgoArt-1-jar-with-dependencies.jar ( del AlgoArt-1-jar-with-dependencies.jar )
copy "%workingDir%\src\main\resources\img\AlgoArt.ico" "%srcDir%" >NUL
copy "%workingDir%\src\main\resources\scripts\start.cmd" "%srcDir%" >NUL
copy "%workingDir%\target\AlgoArt-1-jar-with-dependencies.jar" "%srcDir%" >NUL
cd "%srcDir%"
ren AlgoArt-1-jar-with-dependencies.jar AlgoArt.jar

echo ^| Finished                       ^|
echo #--------------------------------#