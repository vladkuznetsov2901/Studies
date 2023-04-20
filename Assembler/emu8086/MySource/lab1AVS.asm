
; You may customize this and other start-up templates; 
; The location of this template is c:\emu8086\inc\0_com_template.txt

org 100h

mov Ax, 28Fh
mov Bx, 15Dh
add Ax, Bx

ret




