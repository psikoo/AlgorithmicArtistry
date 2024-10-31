echo off
set workingDir=%cd%

start cmd.exe /c %workingDir%\ansi.cmd
java -jar algorithmicArtistry.jar

PAUSE