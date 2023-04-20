data segment
    NB db 10100100b, 10110100b ;10100100b, 10110100b
    cnt db 0
    data ends
    
     ; ���������� ������ � �������� ������� 3
code segment
    assume cs: code, ds: data
START:
    mov ax, data
    mov ds, ax
    lea bx, NB
    
    mov cx, 2 ; 8 ���� � NB
    mov cnt, 0 ; ������������� ��������
    mov si, 0
    
BEG:
    mov al, [bx]
    dec cx
    
    
     
    
COUNT_LOOP:
    
    shl al, 2
    shl al, 1
    jc COUNT
    jmp NOT_COUNT
    
    
COUNT:
   inc cnt
   shl al, 2
   shl al, 1
   jc COUNT2
   jmp NOT_COUNT
   
COUNT2:
    inc cnt
    cmp cx, 0
    je quit
    inc bx
    jmp beg
    
NOT_COUNT:
   shl al, 2
   shl al, 1
   jc COUNT2
   cmp cx, 0
    je quit
    inc bx
   jmp beg
 
QUIT:  
   mov ax, 4C00h
   int 21h
code ends
end START