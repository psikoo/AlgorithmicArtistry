echo off
reg add HKEY_CURRENT_USER\Console /v VirtualTerminalLevel /t REG_DWORD /d 0x00000001 /f >NUL
java -jar AlgoArt.jar
PAUSE