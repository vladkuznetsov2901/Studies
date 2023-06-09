data segment 
    
    prompt1 db 'Input str 1: ',13,10,'$'
    prompt2 db 13,10,'Input str 2: '
    crlf db 13,10,'$'
    txtno db 13,10,'No str$'
    txtyes db 'Str cnt $'
    buf1 db 255,?
    str1 db 255 dup (?)
                        
    buf2 db 255,?
    str2 db 255 dup (?)
                      

data ends

code segment
    assume cs:code,ds:data
 

subroutine proc
    xor al,al 
    mov cl,[di-1] 
    sub cl,[si-1] 
    jb Exit 
    inc cl
    mov ch,al
    
m1: push cx
    push di
    push si
    mov cl,[si-1]
    xor ch,ch 
    repe cmpsb 
    jne m2 
    inc al 
    
m2: pop si 
    pop di 
    inc di
    pop cx
    loop m1 
    Exit: ret
subroutine endp
;=======================================

start: mov ax,data 
    mov ds,ax 
    mov es,ax 
    mov ah,9
    lea dx,prompt1 
    int 21h
    mov ah,10
    lea dx,buf1 
    int 21h
    mov ah,9
    lea dx,prompt2  
    int 21h
    mov ah,10
    lea dx,buf2 
    int 21h
    lea di,str1 
    lea si,str2
    call subroutine
    or al,al 
    jne Yes

No: lea dx,txtno 
    mov ah,9
    int 21h 
    jmp quit

Yes: push ax
    lea dx,crlf 
    mov ah,9
    int 21h
    lea dx,txtyes
    int 21h
    pop ax
    xor ah,ah
    mov bx,300Ah
    div bl
    add bh,ah
    xor ah,ah
    div bl
    mov dx,3030h
    add dx,ax
    mov ah,2
    int 21h
    mov dl,dh
    int 21h
    mov dl,bh
    int 21h

quit: xor ah,ah 
    int 16h
    mov ah,4Ch
    int 21h
code ends
end start