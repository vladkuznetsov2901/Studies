
data segment
x db 0
str db 10, 13, '$'
vvod db 100, ?, 100 dup (?)
mess1 db 'Input string', 10, 13, '$'
data ends
code segment
assume cs: code, ds: data
start:  
    mov ax, data
    mov ds, ax
    mov ah, 09h
    lea dx, mess1
    int 21h
    lea dx, vvod
    mov ah, 0ah
    int 21h
    inc dx
    mov bx, dx
    xor ch, ch
    mov cl, byte ptr [bx]
    inc dx
    mov bx, dx
    push bx
    add bx, cx
    mov byte ptr [bx+1],' '
    mov byte ptr [bx+2],'$'
    add cl, 2
    pop bx
    mov ah, 09h
begin:  
    cmp byte ptr [bx], ' '
    jne no
    push dx
    lea dx, str
    int 21h
    push cx
    mov cl, x
    jcxz first
ot: int 21h
    loop ot
first:  pop cx
    pop dx
    mov [bx], byte ptr '$'
    int 21h
    mov dx, bx
    inc dx
no: inc bx
    loop begin
    lea dx, str
    int 21h
quit:   mov ah, 08h
    int 21h
    mov ax, 4c00h
    int 21h
code ends
end start






