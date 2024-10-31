echo off
set workingDir=%cd%
set desktop="%userprofile%\Desktop"
echo.

echo #--------------------------------#
echo ^| Starting maven automated setup ^|
echo #--------------------------------#

cd %desktop%
if not exist "%desktop%\algorithmicArtistry" ( 
    mkdir "algorithmicArtistry"
    cd "%desktop%\algorithmicArtistry"
) else ( cd "%desktop%\algorithmicArtistry" )

if exist README.md ( del README.md )
if exist start.cmd ( del start.cmd )
if exist ansi.cmd ( del ansi.cmd )
if exist algorithmicArtistry.jar ( del algorithmicArtistry.jar )
if exist algorithmicArtistry-1-jar-with-dependencies.jar ( del algorithmicArtistry-1-jar-with-dependencies.jar )

copy "%workingDir%\README.md" "%desktop%\algorithmicArtistry" >NUL
copy "%workingDir%\src\main\resources\start.cmd" "%desktop%\algorithmicArtistry" >NUL
copy "%workingDir%\src\main\resources\ansi.cmd" "%desktop%\algorithmicArtistry" >NUL
copy "%workingDir%\target\algorithmicArtistry-1-jar-with-dependencies.jar" "%desktop%\algorithmicArtistry" >NUL

cd "%desktop%\algorithmicArtistry"
ren algorithmicArtistry-1-jar-with-dependencies.jar algorithmicArtistry.jar

echo ^| Copying files                  ^|
echo #--------------------------------#