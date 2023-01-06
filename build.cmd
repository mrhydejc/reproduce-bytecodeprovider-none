@echo off
rem IGNORE THIS

setlocal

call "C:\Program Files (x86)\Microsoft Visual Studio\2019\Community\VC\Auxiliary\Build\vcvarsall.bat" x64

set path=c:\Programme\graalvm-ce-java17-22.2.0\bin\;%PATH%;c:\Programme\graalvm-ce-java17-22.2.0\bin\
set java_home=c:\Programme\graalvm-ce-java17-22.2.0\
call mvn -Pnative clean native:compile -DskipTests

endlocal
