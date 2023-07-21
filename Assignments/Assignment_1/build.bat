@echo off
cls

set DRIVE_LETTER=%1:
set PATH=%DRIVE_LETTER%\Java\bin;%DRIVE_LETTER%\Java\ant-1.9.9\bin;c:\Windows

ant run-command-line -D drive-letter=%DRIVE_LETTER%  < pizza_input_0.txt
