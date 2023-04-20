data segment
    mass dw 10,24,-1,79,-345,28,-24,70,127,97
data ends

code segment
    assume cs:code,ds:data
start:
    mov ax,data
    mov ds,ax
    mov cx, 15
    lea bx,mass
beg:
    cmp [bx],0
    jge no
    mov word ptr [bx],0
no:
    inc bx
    loop beg
quit:
    mov ax,4C00h
    int 21h
code ends
end start
